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

    @GetMapping("/homeTags")
    public String showHomeTags() {
        return "homeTags";
    }

    @GetMapping("/tags")
    public String showtags() {
        return "tags";
    }

    @GetMapping("/tagsInput")
    public String showtagsInput() {
        return "tags-input";
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
