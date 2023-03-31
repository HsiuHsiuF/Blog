package com.example.Blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/login")
    public String showLogin() { return "login"; }

    @GetMapping("/register")
    public String showRegister() { return "register"; }

    @GetMapping("/home/{username}")
    public String showHome() {
        return "home";
    }

    @GetMapping("/homeTags/{username}")
    public String showHomeTags() {
        return "homeTags";
    }

    @GetMapping("/tags/{username}")
    public String showtags() {
        return "tags";
    }

    @GetMapping("/tagsInput/{username}")
    public String showtagsInput() {
        return "tags-input";
    }
    @GetMapping("/blog/{username}")
    public String showblog() {
        return "blog";
    }

    @GetMapping("/blogs/{username}")
    public String showblogs() {
        return "blogs";
    }

    @GetMapping("/blogsInput/{username}")
    public String showblogsInput() {
        return "blogs-input";
    }

    @GetMapping("/blogsUpdate/{username}")
    public String showblogsUpdate() {
        return "blogs-update";
    }

}
