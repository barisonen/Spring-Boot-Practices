package com.hibernate.repository;

import com.hibernate.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EMRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> exercise(int age) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.age = :age",
                User.class
        );

        return query.setParameter("age", age).getResultList();
    }

    public List<User> exercise2(int id) {
        User u = entityManager.find(User.class, id);

        if(u == null) {
            return new ArrayList<>();
        }

        entityManager.remove(u);

        return new ArrayList<>();
    }

    public List<User> exercise3() {

        TypedQuery<User> query = entityManager.createNamedQuery("User.findOsman", User.class);
        return query.getResultList();
    }
}
