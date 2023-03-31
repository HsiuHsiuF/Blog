package com.example.Blog.service;

import com.example.Blog.Entity.User;
import com.example.Blog.Entity.UserInfo;
import com.example.Blog.Entity.UserSignup;


public interface UserService {

    public User findByUsername(String username);
    public String createUser(UserSignup userSignup);

    public UserInfo login(User guest);

    public UserInfo update(UserInfo userInfo);

}
