package com.example.Blog.service.impl;

import com.example.Blog.Entity.User;
import com.example.Blog.repository.UserDao;
import com.example.Blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public  String getMd5Password(String password ,String salt){
        //springframework的加密方式
        //md5DigestAsHex參數是Bytes，所以透過java String類將字串轉為Bytes
        String result = password + salt;
        return DigestUtils.md5DigestAsHex(result.getBytes());
    }

    @Override
    public User findByUsername(String username){
        return userDao.findByUsername(username);
    };

    @Override
    public String createUser(User user){
        if(!user.getPassword().equals(user.getCheckPassword())){
            return "兩次輸入密碼不相符";
        }

        //如果查詢結果不為null，代表有重複名稱
        User username =findByUsername(user.getUsername());
        if(username != null){
            return "該帳號已被使用";
        }

        // 產生鹽值
        String salt = UUID.randomUUID().toString().replaceAll("-","");;

        // 密碼加密
        String md5Password = getMd5Password(user.getPassword(),salt);

        // 新增UserEntity資料
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        user.setPassword(md5Password);
        user.setSalt(salt);
        user.setCreated_time(date);
        user.setModified_time(date);
        User result = userDao.save(user);
        if(result == null) return "新增會員資料時發生錯誤";

        return "Success";
    };
}