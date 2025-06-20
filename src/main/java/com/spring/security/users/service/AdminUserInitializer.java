package com.spring.security.users.service;

import com.spring.security.users.modal.Users;
import com.spring.security.users.respository.UsersRepository;
import org.hibernate.annotations.Comment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminUserInitializer {
    @Bean
    public CommandLineRunner createAdminUser(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (usersRepository.findByUsername("admin").isEmpty()) {
                Users admin = new Users();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin1234"));
                admin.setRole("ROLE_ADMIN");
                usersRepository.save(admin);
                System.out.println("Default admin user created");
            }
        };
    }
}
