package com.hibernate.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "content")
    private String content;
}
