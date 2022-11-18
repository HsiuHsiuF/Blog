package com.example.Blog.controller;

import com.example.Blog.Entity.User;
import com.example.Blog.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity createUser(@Valid @RequestBody User user , BindingResult bindingResult){
        String result;
        if(bindingResult.hasErrors()){
            result = bindingResult.getAllErrors().get(0).getDefaultMessage();
        }
        result = userServiceImpl.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
