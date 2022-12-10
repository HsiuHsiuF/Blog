package com.example.Blog.service.impl;

import com.example.Blog.Entity.User;
import com.example.Blog.repository.ArticleDao;
import com.example.Blog.repository.UserDao;
import com.example.Blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Autowired
    UserDao userDao;

    @Override
    public User findAllArticleByUserName(String userName){
        User data = userDao.findByUsername(userName);

        return data;
    }
}
