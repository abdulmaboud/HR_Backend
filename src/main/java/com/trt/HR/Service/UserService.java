package com.trt.HR.Service;

import com.trt.HR.Model.Exceptions.ExistUserException;
import com.trt.HR.Model.User.User;
import com.trt.HR.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null); // Handle user not found
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) throws ExistUserException {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new ExistUserException();
        }
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void updateUser(User user) {
        if (userRepository.existsById(user.getId())) {
            userRepository.save(user);
        }
    }

    public void changePassword(String username, String oldPassword, String newPassword) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            user.setPassword(newPassword); // No encoding
            userRepository.save(user);
        }
    }
}