package com.spring.security.users.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

//    @Autowired
//    private UserService userService;

//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return userService.createUser(user);
//    }

//    @GetMapping("/{id}")
//    public User getUser(@PathVariable Long id) {
//        return userService.getUserById(id);
//    }

    //    @GetMapping
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
    @GetMapping("/")
    public ResponseEntity getUser() {
        return new ResponseEntity("hello user ", HttpStatus.OK);
    }

//    @PutMapping("/{id}")
//    public User updateUser(@PathVariable Long id, @RequestBody User user) {
//        return userService.updateUser(id, user);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return "User deleted successfully.";
//    }
}