package com.example.Blog.controller;

import com.example.Blog.Entity.Article;
import com.example.Blog.Entity.ArticleInput;
import com.example.Blog.Entity.Tag;
import com.example.Blog.Entity.UserInfo;
import com.example.Blog.repository.UserDao;
import com.example.Blog.service.impl.ArticleServiceImpl;
import com.example.Blog.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    @GetMapping("/article")
    public ResponseEntity getAllArticles (HttpSession session){
        UserInfo userInfo= (UserInfo)session.getAttribute("user");
        Iterable<Article> articles = articleServiceImpl.findAllArticleByUserId(5);
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
        String result = articleServiceImpl.addArticle(articleInput,id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
