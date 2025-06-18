package com.spring.security.users.controller;

import com.spring.security.users.modal.AuthRequest;
import com.spring.security.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
            //create jwt token
            return jwtUtil.generateToken(authRequest.getUsername());
//            return "jwt token";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
