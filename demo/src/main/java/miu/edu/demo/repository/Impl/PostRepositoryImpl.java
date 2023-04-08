package miu.edu.demo.repository.Impl;

import miu.edu.demo.domain.Post;
import miu.edu.demo.repository.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private final List<Post> database = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public Post findById(Long id) {
        return database.stream()
                .filter(post -> Objects.equals(post.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post save(Post post) {
        post.setId(nextId++);
        database.add(post);
        return post;
    }

    @Override
    public void deleteById(Long id) {
        database.removeIf(post -> Objects.equals(post.getId(), id));
    }

    @Override
    public List<Post> findByAuthor(String author) {
        return database.stream()
                .filter(post -> Objects.equals(post.getAuthor(), author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> findByTitle(String title) {
        return database.stream()
                .filter(post -> Objects.equals(post.getTitle(), title))
                .collect(Collectors.toList());
    }

}
