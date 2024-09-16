package com.trt.HR.Control;

import com.trt.HR.Model.User.User;
import com.trt.HR.Service.UserService;
import com.trt.HR.Model.Exceptions.ExistUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        try {
            userService.createUser(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (ExistUserException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping("/signIn")
    public ResponseEntity<String> signIn(@RequestBody User user) {
        // Simplified to only check existence
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null) {
            return ResponseEntity.ok("Sign in successful");
        } else {
            return ResponseEntity.status(400).body("Invalid username");
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        User user = userService.findByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.ok("User updated successfully");
    }

    @PostMapping("/changePassword")
    public ResponseEntity<String> changePassword(
            @RequestParam String username,
            @RequestParam String oldPassword,
            @RequestParam String newPassword) {
        userService.changePassword(username, oldPassword, newPassword);
        return ResponseEntity.ok("Password changed successfully");
    }
}