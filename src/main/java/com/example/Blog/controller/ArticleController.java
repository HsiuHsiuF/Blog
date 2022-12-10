package com.example.Blog.controller;

import com.example.Blog.Entity.Article;
import com.example.Blog.Entity.User;
import com.example.Blog.repository.UserDao;
import com.example.Blog.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ArticleController {

    @Autowired
    ArticleServiceImpl articleServiceImpl;

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public ResponseEntity getAllArticles (@PathVariable("userName") String userName){
        User user= userDao.findByUsername(userName);
        Set<Article> articleList = user.getArticles();
        return ResponseEntity.status(HttpStatus.OK).body(articleList);
    }
}
