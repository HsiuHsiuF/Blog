package com.example.Blog.controller;

import com.example.Blog.Entity.Tag;
import com.example.Blog.Entity.TagInput;
import com.example.Blog.Entity.UserInfo;
import com.example.Blog.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class TagController {

    @Autowired
    TagServiceImpl tagServiceimpl;


    //取得USER個人分類
    @GetMapping("/tag/{username}")
    public ResponseEntity getTagByUserId (@PathVariable String username) {
        List<Tag> tags = tagServiceimpl.getTagbyUsername(username);
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
    public ResponseEntity addTag(@RequestBody TagInput tagInput, HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        String result = tagServiceimpl.addTag(tagInput, userInfo.getUsername());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //刪除分類
    @DeleteMapping ("/tag/{id}")
    public ResponseEntity deleteTag(@PathVariable Integer id){
        boolean result = tagServiceimpl.deleteTag(id);
        if(!result){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("已刪除");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

    //修改分類
    @PutMapping("/tag/{tagId}")
    public ResponseEntity updateTag(@RequestBody TagInput tagInput, @PathVariable Integer tagId){
        boolean result = tagServiceimpl.updateTag(tagInput, tagId);
        if(!result){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("修改時發生錯誤");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

}
