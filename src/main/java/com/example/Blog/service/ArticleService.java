package com.example.Blog.service;

import com.example.Blog.Entity.Article;
import com.example.Blog.Entity.Tag;

public interface ArticleService {

    public Iterable<Article> findAllArticleByUserId(Integer id);
    public Article findArticleById(Integer id,String userName);

    public Article findArticleById(Integer id,String userName,String password);

    public String addArticle(String userName,Article article,Tag tag);

}
