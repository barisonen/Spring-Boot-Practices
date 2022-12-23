package com.hibernate.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Table(name = "User")
@Data
@NamedQueries({
        @NamedQuery(name="User.findOsman",
                    query = "SELECT u FROM User u WHERE LOWER(u.name) = 'osman'"),
        @NamedQuery(name="User.findBaris",
                    query = "SELECT u FROM User u WHERE LOWER(u.name) = 'baris'")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "user")
    private Set<Post> posts;
}
