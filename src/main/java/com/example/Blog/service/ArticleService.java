package com.example.Blog.service;

import com.example.Blog.Entity.User;

public interface ArticleService {

    public User findAllArticleByUserName(String userName);

}
