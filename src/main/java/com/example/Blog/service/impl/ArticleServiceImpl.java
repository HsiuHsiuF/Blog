package com.example.Blog.service.impl;

import com.example.Blog.Entity.Article;
import com.example.Blog.Entity.Tag;
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
    public Iterable<Article> findAllArticleByUserId(Integer id){
        Iterable<Article> articleList = articleDao.findByUser_id(id);
        return articleList;
    }

    @Override
    public Article findArticleById(Integer id,String userName){
        Article article = articleDao.findById(id).get();
        User user = article.getUser();
        if(!user.equals(userDao.findByUsername(userName))){
            return null;
        }

        return article;

    }

    @Override
    public Article findArticleById(Integer id,String userName,String password){
        Article article = articleDao.findById(id).get();
        User user = article.getUser();
        if(!user.equals(userDao.findByUsername(userName))){
            return null;
        }
        if(article.getPassword() != null){
            if(!article.getPassword().equals(password)){
                return null;
            }
        }
        return article;
    }

    @Override
    public String addArticle(String userName, Article article, Tag tag){
        User user = userDao.findByUsername(userName);
        article.setUser(user);

        article.setTag(tag);
        Article result = articleDao.save(article);

        if(result == null)return"新增文章時發生錯誤";

        return"Success";
    }
}
