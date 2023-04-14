package miu.edu.demo.service;

import jakarta.persistence.EntityNotFoundException;
import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.User;
import miu.edu.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public List<User> getUsersWithMoreThanOnePost() {
        return userRepository.findByPostsSizeGreaterThan(1);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
        return user.get();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<Post> getUserPostsById(Long id) {
        User user = getUserById(id);
        return user.getPosts();
    }
        public List<User> getUsersWithMoreThanNPosts(int n) {
            return userRepository.findByPostsSizeGreaterThan(n);
        }

        public void deleteUserById(Long id) {
            userRepository.deleteById(id);
        }




}
