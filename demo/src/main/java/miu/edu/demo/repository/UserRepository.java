package miu.edu.demo.repository;

import miu.edu.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE SIZE(u.posts) > :n")
    List<User> findByPostsSizeGreaterThan(@Param("n") int n);

User findByEmail(String email);


}


