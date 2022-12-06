package com.example.Blog.service;

import com.example.Blog.Entity.User;
import com.example.Blog.Entity.UserLogin;

import java.util.Optional;

public interface UserService {

    public User findByUsername(String username);

    public String createUser(UserLogin userLogin);

    public String login(User user);

    public Optional<User> getArticleByUserId(Integer id);

}
