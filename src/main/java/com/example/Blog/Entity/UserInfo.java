package com.example.Blog.Entity;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class UserInfo {

    private Integer user_id;
    private String name;
    private String e_mail;
    private String username;

    @Pattern(regexp = "09\\d{8}", message = "手機號碼格式錯誤")
    private String phone;
    private Date birthday;
}
