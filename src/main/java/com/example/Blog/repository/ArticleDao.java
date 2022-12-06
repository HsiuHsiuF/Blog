package com.example.Blog.repository;

import com.example.Blog.Entity.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends CrudRepository<Article, Integer> {

}
