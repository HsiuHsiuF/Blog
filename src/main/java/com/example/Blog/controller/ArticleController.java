package com.example.Blog.controller;

import com.example.Blog.Entity.Article;
import com.example.Blog.Entity.UserInfo;
import com.example.Blog.repository.UserDao;
import com.example.Blog.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class  ArticleController {

    @Autowired
    ArticleServiceImpl articleServiceImpl;

    @Autowired
    UserDao userDao;

    //查USER的全部文章
    @GetMapping("/article")
    public ResponseEntity getAllArticles (HttpSession session){
        UserInfo userInfo= (UserInfo)session.getAttribute("user");
        Iterable<Article> articles = articleServiceImpl.findAllArticleByUserId(5);
        return ResponseEntity.status(HttpStatus.OK).body(articles);
    }

//    //沒有鎖密碼的文章
//    @GetMapping("/{userName}/{id}")
//    public ResponseEntity getArticles (@PathVariable("id") Integer id,@PathVariable("userName")String userName){
//        Article article = articleServiceImpl.findArticleById(id,userName);
//
//        return ResponseEntity.status(HttpStatus.OK).body(article);
//    }
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
//    //儲存文章
//    @PostMapping("/{userName}/edit")
//    public ResponseEntity addArticle( @PathVariable("userName")String userName, @RequestBody Article article, @RequestBody Tag tag){
//        String result = articleServiceImpl.addArticle(userName,article,tag);
//        return ResponseEntity.status(HttpStatus.OK).body(result);
//    }
}
