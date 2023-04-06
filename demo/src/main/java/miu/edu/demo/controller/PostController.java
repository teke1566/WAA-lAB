package miu.edu.demo.controller;

import miu.edu.demo.domain.Post;
import miu.edu.demo.dto.PostDto;
import miu.edu.demo.repository.PostRepository;
import miu.edu.demo.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final ModelMapper modelMapper;
    private PostRepository postRepository;

    @Autowired
    public PostController(PostService postService, ModelMapper modelMapper) {
        this.postService = postService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public List<PostDto> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return posts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        return convertToDto(post);
    }

    @PostMapping("/")
    public PostDto savePost(@RequestBody PostDto postDto) {
        Post post = convertToEntity(postDto);
        Post savedPost = postService.savePost(post);
        return convertToDto(savedPost);
    }

    @PutMapping("/{id}")
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
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        Post postToDelete = postService.getPostById(id);
        if (postToDelete == null) {
            return ResponseEntity.notFound().build();
        }
        postService.deletePostById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/posts")
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
