package com.example.springboot_3_1.repository;

import com.example.springboot_3_1.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public void deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    public void editUser(User user) {
        entityManager.merge(user);
    }

    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
}
