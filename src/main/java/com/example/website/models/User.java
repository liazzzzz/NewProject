package com.example.website.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email can't be empty")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotEmpty(message = "Please provide your name")
    private String firstname;
    @NotEmpty(message = "Please provide your name")
    private String lastname;
    @NotEmpty(message = "Please enter the password")
    private String hashPassword;

    @OneToMany(mappedBy = "user")
    private Set<Article> articles;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @Enumerated(EnumType.STRING)
    private State state;
    @Enumerated(EnumType.STRING)
    private Role role;
}
