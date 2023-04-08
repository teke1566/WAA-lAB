package miu.edu.demo.repository;

import miu.edu.demo.domain.Post;

import java.util.List;

public interface PostRepository {

    List<Post> findAll();

    Post findById(Long id);

    Post save(Post post);

    void deleteById(Long id);

    List<Post> findByAuthor(String author);
    List<Post> findByTitle(String title);
}
