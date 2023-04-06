package miu.edu.demo.service;

import jakarta.persistence.EntityNotFoundException;
import miu.edu.demo.domain.Post;
import miu.edu.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }

    public Post updatePost(Long id, Post updatedPost) {
        Post post = postRepository.findById(id);
        if (post == null) {
            throw new EntityNotFoundException("Post not found with id: " + id);
        }
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        post.setAuthor(updatedPost.getAuthor());
        return postRepository.save(post);
    }
}
