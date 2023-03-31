package com.example.Blog.repository;

import com.example.Blog.Entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ArticleDaoImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Article> findArticleByTagId(Integer id){
        String sql = " select * from article a inner join tag t on a.tag_id = t.tag_id and a.tag_id = ?";
        List<Article> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Article>(Article.class)/*資料庫欄位自動對應實體變數*/, new Object[] { id });
        return result;
    };
}
