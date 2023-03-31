package com.example.Blog.controller;

import com.example.Blog.Entity.User;
import com.example.Blog.Entity.UserInfo;
import com.example.Blog.Entity.UserSignup;
import com.example.Blog.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
    public ResponseEntity createUser(@Valid @RequestBody UserSignup UserSignup){
        String result = userServiceImpl.createUser(UserSignup);
        if(result != "Success"){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("該帳號已被使用");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    //登入
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid User user, HttpSession session, HttpServletResponse response){
        UserInfo result = userServiceImpl.login(user);
        if(result == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("帳號或密碼有誤");
        }
        session.setAttribute("user", result);
        Cookie cookie = new Cookie("user", result.getUsername());
        cookie.setMaxAge(session.getMaxInactiveInterval());
        response.addCookie(cookie);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //登出
    @GetMapping("/logout")
    public ResponseEntity logout(HttpSession session, SessionStatus sessionStatus, HttpServletResponse response){
        if(session.getAttribute("user") != null){
            session.removeAttribute("user");
            sessionStatus.setComplete();
            Cookie cookie = new Cookie("user", null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
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

    //請求USER資訊
    @GetMapping("/userInfo/{username}")
    public ResponseEntity userInfo(@PathVariable("username") String username){
        User user = userServiceImpl.findByUsername(username);
        UserInfo userInfo = new UserInfo();
        userInfo.setUser_id(user.getId());
        userInfo.setName(user.getName());
        userInfo.setE_mail(user.getE_mail());
        userInfo.setUsername(user.getUsername());
        userInfo.setBirthday(user.getBirthday());
        userInfo.setPhone(user.getPhone());
        return ResponseEntity.status(HttpStatus.OK).body(userInfo);
    }


}
