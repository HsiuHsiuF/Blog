package com.example.Blog.controller;

import com.example.Blog.Entity.Comment;
import com.example.Blog.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @Autowired
    CommentServiceImpl commentService;

    //儲存留言
    @PostMapping("/comment/{ArticleId}")
    public ResponseEntity addComment(@PathVariable("ArticleId")Integer id, @RequestBody Comment comment){
        String result = commentService.addComment(comment, id);
        return ResponseEntity.status(HttpStatus.OK).body(comment);
    }

    //刪除留言
    @DeleteMapping ("/comment/{commentId}")
    public ResponseEntity deleteComment(@PathVariable Integer commentId){
        boolean result = commentService.deleteComment(commentId);
        if(!result){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("已刪除");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
}
