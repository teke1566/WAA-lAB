package miu.edu.demo.controller;

import miu.edu.demo.aspects.annotation.ExecutionTime;
import miu.edu.demo.aspects.annotation.LoggerInfo;
import miu.edu.demo.domain.Post;
import miu.edu.demo.dto.PostDto;
import miu.edu.demo.repository.PostRepository;
import miu.edu.demo.service.Impl.AwesomeUserDetailsService;
import miu.edu.demo.service.LoggerService;
import miu.edu.demo.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private final PostService postService;
    private final ModelMapper modelMapper;
    @Autowired
    private AwesomeUserDetailsService userDetailsService;
    @Autowired
    private LoggerService loggerService;
    private PostRepository postRepository;

    @Autowired
    public PostController(PostService postService, ModelMapper modelMapper) {
        this.postService = postService;
        this.modelMapper = modelMapper;
    }

//    @GetMapping
//    @LoggerInfo
//    @ExecutionTime
//    public List<PostDto> getAllPosts() {
//        List<Post> posts = postService.getAllPosts();
//        return posts.stream()
//                .map(this::convertToDto)
//                .collect(Collectors.toList());
//    }
    @GetMapping
    public List<PostDto> getAllPosts() {
        // Logging logic
        loggerService.logInfo("Getting all posts");
        loggerService.logExecutionTime("GET", "PostController.getAllPosts", LocalTime.now());

        List<Post> posts = postService.getAllPosts();
        return posts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @LoggerInfo
    @ExecutionTime
    public PostDto getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        return convertToDto(post);
    }

    @PostMapping
    @LoggerInfo
    @ExecutionTime
//    public PostDto savePost(@RequestBody PostDto postDto) {
//        Post post = convertToEntity(postDto);
//        Post savedPost = postService.savePost(post);
//        return convertToDto(savedPost);
//    }
    @Secured({"ROLE_CLIENT", "ROLE_ADMIN"})
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        // Extract user details from authenticated user
        String username = userDetailsService.loadUserByUsername(post.getUser().getEmail()).getUsername();
        post.getUser().setEmail(username);
        Post createdPost = postService.savePost(post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @LoggerInfo
    @ExecutionTime
    public ResponseEntity<PostDto> updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
        Post postToUpdate = postService.getPostById(id);
        if (postToUpdate == null) {
            return ResponseEntity.notFound().build();
        }
        postToUpdate.setTitle(postDto.getTitle());
        postToUpdate.setContent(postDto.getContent());
        postToUpdate.setAuthor(postDto.getAuthor());
        Post updatedPost = postService.savePost(postToUpdate);
        PostDto updatedPostDto = convertToDto(updatedPost);
        return ResponseEntity.ok(updatedPostDto);
    }

    @DeleteMapping("/{id}")
    @LoggerInfo
    @ExecutionTime
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        Post postToDelete = postService.getPostById(id);
        if (postToDelete == null) {
            return ResponseEntity.notFound().build();
        }
        postService.deletePostById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/author")
    @LoggerInfo
    @ExecutionTime
    public List<Post> getPostsByAuthor(@RequestParam("author") String author) {
        return postRepository.findByAuthor(author);
    }

    private PostDto convertToDto(Post post) {
        return new PostDto(post.getId(), post.getTitle(), post.getContent(), post.getAuthor());
    }

    private Post convertToEntity(PostDto postDto) {
        return new Post(postDto.getId(), postDto.getTitle(), postDto.getContent(), postDto.getAuthor());
    }

}
