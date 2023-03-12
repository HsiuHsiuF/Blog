package com.example.Blog.repository;

import com.example.Blog.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao extends JpaRepository<Article, Integer> {

    public Iterable<Article> findByUser_id(Integer id);



}
