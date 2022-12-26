package com.example.Blog.controller;

import com.example.Blog.Entity.UserInfo;
import com.example.Blog.Entity.UserLogin;
import com.example.Blog.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@RestController

public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/session")
    public ResponseEntity checkSession(HttpSession session){
        UserInfo result = (UserInfo) session.getAttribute("user");
        if(result == null){
            return ResponseEntity.status(HttpStatus.OK).body("已登出");
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //註冊
    @PostMapping("/signup")
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
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UserLogin user, HttpSession session){
        UserInfo result = userServiceImpl.login(user);
        if(result == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("帳號或密碼有誤");
        }
        session.setAttribute("user", result);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //登出
    @GetMapping("/logout")
    public ResponseEntity logout(HttpSession session, SessionStatus sessionStatus){
        if(session.getAttribute("user") != null){
            session.removeAttribute("user");
            sessionStatus.setComplete();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

    //修改USER資訊
    @PostMapping("/userInfoUpdate")
    public ResponseEntity loginUser(@RequestBody UserInfo userInfo, @SessionAttribute(value = "user") UserInfo user, HttpSession session){
        userInfo.setUsername(user.getUsername());
        UserInfo result = userServiceImpl.update(userInfo);
        if(result == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("修改失敗");
        }
        session.setAttribute("user", result);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
