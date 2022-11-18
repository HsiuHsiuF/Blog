package com.example.Blog.service;

import com.example.Blog.Entity.User;

public interface UserService {

    public User findByUsername(String username);

    public String createUser(User user);
}
