package com.example.Blog.service;

import com.example.Blog.Entity.User;
import com.example.Blog.Entity.UserInfo;
import com.example.Blog.Entity.UserLogin;


public interface UserService {

    public User findByUsername(String username);
    public String createUser(UserLogin userLogin);

    public UserInfo login(UserLogin userLogin);

    public UserInfo update(UserInfo userInfo);

}
