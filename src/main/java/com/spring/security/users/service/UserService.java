package com.spring.security.users.service;

import com.spring.security.users.modal.RegisterUserRequest;
import com.spring.security.users.modal.UserResponse;
import com.spring.security.users.modal.Users;
import com.spring.security.users.respository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public UserResponse registerUser(RegisterUserRequest registerUserRequest){
        //todo check if user already present
        if(usersRepository.findByUsername(registerUserRequest.getUsername()).isPresent()){
            throw new RuntimeException("User Already Exist");
        }
        //todo encode password
        Users users = new Users();
        users.setUsername(registerUserRequest.getUsername());
        users.setRole(registerUserRequest.getRole());
        users.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));
        //todo save user
        Users savedUsers =   usersRepository.save(users);
return new UserResponse(savedUsers.getId(), savedUsers.getUsername(),savedUsers.getRole().name());
    }
}
