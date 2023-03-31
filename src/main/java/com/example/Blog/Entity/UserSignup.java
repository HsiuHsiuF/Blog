package com.example.Blog.Entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;


@Data
public class UserSignup {

    @NotBlank(message = "姓名不可為空")
    private String name;

    @Email
    @NotBlank(message = "E-mail不可為空")
    private String e_mail;

    @NotBlank(message = "帳號不可為空")
    @Length(min = 6 ,max = 18, message = "帳號長度為6~18")
    private String username;

    @NotBlank(message = "密碼不可為空")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z]).{6,18}$",
            message = "密碼必須為長度6~18英文加數字")
    private String password;

    @NotBlank(message = "再次輸入密碼不可為空")
    private String checkPassword;

    @Pattern(regexp = "09\\d{8}", message = "手機號碼格式錯誤")
    @NotBlank(message = "電話號碼不可為空")
    private String phone;

    @Past(message = "生日不可為未來日期")
    private Date birthday;
}
