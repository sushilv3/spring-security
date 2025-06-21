package com.spring.security.users.controller;

import com.spring.security.users.modal.AuthRequest;
import com.spring.security.users.modal.DemoModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping
    public String demoGet() {
        return "demo";
    }

    @PostMapping
    public String demoPost(@RequestBody DemoModel model) {
        System.out.println("Post api called : ");
        return "post demo :" + model;
    }

    @PutMapping("/{id}")
    public String demoPut(@PathVariable String id) {
        return "put demo : " + id;
    }

    @DeleteMapping("/{id}")
    public String demo(@PathVariable String id) {
        return "delete demo : " + id;
    }
}
