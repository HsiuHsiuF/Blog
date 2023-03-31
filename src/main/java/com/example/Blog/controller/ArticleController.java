package com.example.Blog.controller;

import com.example.Blog.Entity.Article;
import com.example.Blog.Entity.ArticleInput;
import com.example.Blog.Entity.Tag;
import com.example.Blog.repository.UserDao;
import com.example.Blog.service.impl.ArticleServiceImpl;
import com.example.Blog.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class  ArticleController {

    @Autowired
    ArticleServiceImpl articleServiceImpl;

    @Autowired
    UserDao userDao;

    @Autowired
    TagServiceImpl tagServiceImpl;


    //查USER的全部文章
    @GetMapping("/article/all/{username}")
    public ResponseEntity getAllArticles (@PathVariable("username") String username){
        Iterable<Article> articles = articleServiceImpl.findAllArticleByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).body(articles);
    }

    //沒有鎖密碼的文章
    @GetMapping("/article/{articleId}")
    public ResponseEntity getArticles (@PathVariable("articleId") Integer id){
        Article article = articleServiceImpl.findArticleById(id);
        Tag tag = tagServiceImpl.getTagByArticleId(id);
        List list = new ArrayList<>();
        list.add(article);
        list.add(tag);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
//
//    //有鎖密碼的文章
//    @PostMapping("/{userName}/{id}")
//    public ResponseEntity getArticles (@PathVariable("id") Integer id, @PathVariable("userName")String userName, @RequestBody ArticlePassword articlePassword){
//        String password = articlePassword.getArticlePassword();
//        Article article = articleServiceImpl.findArticleById(id,userName,password);
//        return ResponseEntity.status(HttpStatus.OK).body(article);
//    }
//
//
    //儲存文章
    @PostMapping("/article/{tagId}")
    public ResponseEntity addArticle(@RequestBody ArticleInput articleInput, @PathVariable("tagId") Integer id){
        boolean result = articleServiceImpl.addArticle(articleInput,id);
        if(!result){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("新增文章時發生錯誤");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

    //修改文章
    @PutMapping("/article/{articleId}/{tagId}")
    public ResponseEntity updateTag(@RequestBody ArticleInput articleInput, @PathVariable Integer articleId, @PathVariable Integer tagId){
        boolean result = articleServiceImpl.updateArticle(articleInput, articleId, tagId);
        if(!result){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("修改時發生錯誤");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

    //刪除文章
    @DeleteMapping ("/article/{articleId}")
    public ResponseEntity deleteArticle(@PathVariable Integer articleId){
        boolean result = articleServiceImpl.deleteArticle(articleId);
        if(!result){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("已刪除");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

    //查詢分類裡的所有文章
    @GetMapping("/article/byTag/{tagId}")
    public ResponseEntity getArticlesByTagId (@PathVariable("tagId") Integer id){
       List<Article> result = articleServiceImpl.findArticleByTagId(id);
        Tag tag = tagServiceImpl.getTagById(id);
        List list = new ArrayList<>();
        list.add(result);
        list.add(tag);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
