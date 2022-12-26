package com.example.Blog.controller;

import com.example.Blog.Entity.Tag;
import com.example.Blog.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagController {

    @Autowired
    TagServiceImpl tagServiceimpl;

    //取得文章分類
    @GetMapping("/{userName}/getAllTag")
    public ResponseEntity getAllTag (@PathVariable("userName") String userName) {
        List<Tag> tags = tagServiceimpl.getTagbyUserName(userName);
        return ResponseEntity.status(HttpStatus.OK).body(tags);
    }
}
