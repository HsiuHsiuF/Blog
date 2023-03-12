package com.example.Blog.service.impl;

import com.example.Blog.Entity.Article;
import com.example.Blog.Entity.ArticleInput;
import com.example.Blog.Entity.Tag;
import com.example.Blog.Entity.User;
import com.example.Blog.repository.ArticleDao;
import com.example.Blog.repository.TagDao;
import com.example.Blog.repository.UserDao;
import com.example.Blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Autowired
    UserDao userDao;

    @Autowired
    TagDao tagDao;

    @Override
    public Iterable<Article> findAllArticleByUserId(Integer id){
        Iterable<Article> articleList = articleDao.findByUser_id(id);
        return articleList;
    }

//    @Override
//    public Article findArticleById(Integer id,String userName){
//        Article article = articleDao.findById(id).get();
//        User user = article.getUser();
//        if(!user.equals(userDao.findByUsername(userName))){
//            return null;
//        }
//
//        return article;
//
//    }

    @Override
    public Article findArticleById(Integer id){
        Article article = articleDao.findById(id).get();

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
    public String addArticle(ArticleInput articleInput, Integer id){
        User user = userDao.findByUsername("aaa");
        Tag tag = tagDao.findById(id).get();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        Article article = new Article();
        article.setTitle(articleInput.getTitle());
        article.setContent(articleInput.getContent());
        article.setUser(user);
        article.setUsername(user.getName());
        article.setTag(tag);
        article.setCreated_time(date);
        article.setModified_time(date);
        Article result = articleDao.save(article);

        if(result == null)return"新增文章時發生錯誤";

        return"Success";
    }
}
