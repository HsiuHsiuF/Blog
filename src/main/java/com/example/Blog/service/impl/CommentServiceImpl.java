package com.example.Blog.service.impl;

import com.example.Blog.Entity.Article;
import com.example.Blog.Entity.Comment;
import com.example.Blog.repository.ArticleDao;
import com.example.Blog.repository.CommentDao;
import com.example.Blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Autowired
    ArticleDao articleDao;

    //新增留言
    @Override
    public String addComment(Comment comment, Integer Article_id){
        Article article = articleDao.findById(Article_id).get();
        comment.setArticle(article);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        comment.setCreated_time(date);
        Comment result = commentDao.save(comment);
        if(result == null)return"新增留言時發生錯誤";

        return"Success";
    };

    //刪除留言
    @Override
    public boolean deleteComment(Integer commentId){
        boolean result = commentDao.existsById(commentId);
        if(!result){
            return false;
        }
        commentDao.deleteById(commentId);
        return true;
    };
}
