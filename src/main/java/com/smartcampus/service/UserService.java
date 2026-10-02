package com.smartcampus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartcampus.entity.User;
import com.smartcampus.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElse(null);
    }

    public User login(String email, String password, String role) {

        User user = userRepository.findByEmail(email)
                .orElse(null);

        if (user != null
                && user.getPassword() != null
                && user.getPassword().equals(password)
                && user.getRole() != null
                && user.getRole().equals(role)) {

            return user;
        }

        return null;
    }

    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }

        userRepository.deleteById(id);
    }
}