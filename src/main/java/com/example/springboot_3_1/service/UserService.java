package com.example.springboot_3_1.service;

import com.example.springboot_3_1.model.User;
import com.example.springboot_3_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Transactional
    public void deleteUser(long id) {
        userRepository.deleteUser(id);
    }

    @Transactional
    public void editUser(User user) {
        userRepository.editUser(user);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }

}
