package com.example.Blog.repository;

import com.example.Blog.Entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TagDaoImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<Tag> findByArticleId(Integer id){
        String sql = " select * from article a inner join tag t on a.tag_id = t.tag_id and a.article_id = ?";
        List<Tag> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Tag>(Tag.class)/*資料庫欄位自動對應實體變數*/, new Object[] { id });
        return result;
    };
}
