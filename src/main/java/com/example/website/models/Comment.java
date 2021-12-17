package com.example.website.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    @NotEmpty(message = "*Please write something")
    private String text;
    private LocalDateTime createdAt;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "post_id", referencedColumnName = "id")
    private Article post;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


}
