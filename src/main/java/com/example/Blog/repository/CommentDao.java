package com.example.Blog.repository;

import com.example.Blog.Entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao extends CrudRepository<Comment, Integer> {
}
