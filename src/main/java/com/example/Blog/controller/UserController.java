package com.example.Blog.controller;

import com.example.Blog.Entity.User;
import com.example.Blog.Entity.UserLogin;
import com.example.Blog.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    //註冊
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity createUser(@Valid @RequestBody UserLogin userLogin , BindingResult bindingResult){
        String result;
        if(bindingResult.hasErrors()){
            result = bindingResult.getAllErrors().get(0).getDefaultMessage();
        }else {
            result = userServiceImpl.createUser(userLogin);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    //登入
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity loginUser(@Valid @RequestBody User user , BindingResult bindingResult){
        String result;
        if(bindingResult.hasErrors()){
            result = bindingResult.getAllErrors().get(0).getDefaultMessage();
        }else {
            result = userServiceImpl.login(user);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @RequestMapping(value = "/users/{id}/article", method = RequestMethod.GET)
    public ResponseEntity getArticleByUserId (@PathVariable Integer id) {
        Optional<User> article = userServiceImpl.getArticleByUserId(id);
        return ResponseEntity.status(HttpStatus.OK).body(article);
    }

}
