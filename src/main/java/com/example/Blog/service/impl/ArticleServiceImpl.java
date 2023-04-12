package com.example.Blog.service.impl;

import com.example.Blog.Entity.Article;
import com.example.Blog.Entity.ArticleInput;
import com.example.Blog.Entity.Tag;
import com.example.Blog.Entity.User;
import com.example.Blog.repository.ArticleDao;
import com.example.Blog.repository.ArticleDaoImpl;
import com.example.Blog.repository.TagDao;
import com.example.Blog.repository.UserDao;
import com.example.Blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Autowired
    UserDao userDao;

    @Autowired
    TagDao tagDao;

    @Autowired
    ArticleDaoImpl articleDaoImpl;

    @Override
    public Iterable<Article> findAllArticleByUsername(String username){
        Iterable<Article> articleList = articleDao.findByUsername(username);
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

    //新增文章
    @Override
    public boolean addArticle(ArticleInput articleInput, Integer tagId, String username){
        User user = userDao.findByUsername(username);
        Tag tag = tagDao.findById(tagId).get();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        Article article = new Article();
        article.setTitle(articleInput.getTitle());
        article.setContent(articleInput.getContent());
        article.setContent_md(articleInput.getContent_md());
        article.setUser(user);
        article.setUsername(user.getUsername());
        article.setTag(tag);
        article.setCreated_time(date);
        article.setModified_time(date);
        Article result = articleDao.save(article);

        if(result == null)return false;

        return true;
    }

    //修改文章
    @Override
    public boolean updateArticle(ArticleInput articleInput, Integer articleId, Integer tagId){
        Article article = articleDao.findById(articleId).get();
        Tag tag = tagDao.findById(tagId).get();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        article.setTitle(articleInput.getTitle());
        article.setContent(articleInput.getContent());
        article.setContent_md(articleInput.getContent_md());
        article.setTag(tag);
        article.setModified_time(date);
        Article result =articleDao.save(article);
        if(result == null)return false;

        return true;
    };

    //刪除文章
    @Override
    public boolean deleteArticle(Integer id){
        boolean result = articleDao.existsById(id);
        if(!result){
            return false;
        }
        articleDao.deleteById(id);
        return true;
    };

    @Override
    public List<Article> findArticleByTagId(Integer tagId){
        List<Article> result = articleDaoImpl.findArticleByTagId(tagId);
        return result;
    };
}
