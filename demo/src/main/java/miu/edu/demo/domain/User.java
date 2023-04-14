package miu.edu.demo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;
    private String firstname;
    private String lastname;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference

    private List<Post> posts;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;


}
