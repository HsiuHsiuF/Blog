package com.example.Blog.service;

import com.example.Blog.Entity.Article;
import com.example.Blog.Entity.ArticleInput;

import java.util.List;

public interface ArticleService {

    public Iterable<Article> findAllArticleByUsername(String username);
    public Article findArticleById(Integer id);

    public Article findArticleById(Integer id,String userName,String password);

    public boolean addArticle(ArticleInput articleInput, Integer id);

    public boolean updateArticle(ArticleInput articleInput, Integer articleId, Integer tagId);

    public boolean deleteArticle(Integer id);

    public List<Article> findArticleByTagId(Integer tagId);

}
