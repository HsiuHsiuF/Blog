package com.example.Blog.service;

import com.example.Blog.Entity.Comment;

public interface CommentService {

    public String addComment(Comment comment, Integer Article_id);
}
