package com.example.Blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @GetMapping("/home")
    public String showHome() {
        return "home";
    }

    @GetMapping("/blog")
    public String showblog() {
        return "blog";
    }

    @GetMapping("/blogs")
    public String showblogs() {
        return "blogs";
    }

    @GetMapping("/blogsInput")
    public String showblogsInput() {
        return "blogs-input";
    }
}
