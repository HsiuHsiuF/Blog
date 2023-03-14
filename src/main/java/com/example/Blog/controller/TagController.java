package com.example.Blog.controller;

import com.example.Blog.Entity.Tag;
import com.example.Blog.Entity.TagInput;
import com.example.Blog.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {

    @Autowired
    TagServiceImpl tagServiceimpl;

    //取得文章分類
//    @GetMapping("/getAllTag")
//    public ResponseEntity getAllTag () {
//        List<Tag> tags = tagServiceimpl.getTagbyUserId(5);
//        return ResponseEntity.status(HttpStatus.OK).body(tags);
//    }

    //取得USER個人分類
    @GetMapping("/tag/{id}")
    public ResponseEntity getTagByUserId (@PathVariable Integer id) {
        List<Tag> tags = tagServiceimpl.getTagbyUserId(id);
        return ResponseEntity.status(HttpStatus.OK).body(tags);
    }

    //取得分類
    @GetMapping("/tag/by/{id}")
    public ResponseEntity getTagById (@PathVariable Integer id) {
        Tag tag = tagServiceimpl.getTagById(id);
        return ResponseEntity.status(HttpStatus.OK).body(tag);
    }

    //新增分類
    @PostMapping("/tag")
    public ResponseEntity addtag(@RequestBody TagInput tagInput){
        String result = tagServiceimpl.addTag(tagInput);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping ("/tag/{id}")
    public ResponseEntity deletetag(@PathVariable Integer id){
        boolean result = tagServiceimpl.deleteTag(id);
        if(!result){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("已刪除");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }


}
