package com.example.Blog.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "姓名不可為空")
    @Column
    private String name;

    @Email
    @NotBlank(message = "E-mail不可為空")
    @Column
    private String e_mail;

    @NotBlank(message = "帳號不可為空")
    @Length(min = 6 ,max = 18, message = "帳號長度為6~18")
    @Column
    private String username;

    @NotBlank(message = "密碼不可為空")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,18}$",
            message = "密碼必須為長度6~18英文加數字")
    @Column
    private String password;
    @Column
    private String salt;

    @NotBlank(message = "手機號碼不可為空")
    @Length(min = 10,message = "手機號碼格式錯誤")
    @Column
    private String phone;

    @NotBlank(message = "生日不可為空")
    @Column
    private String birthday;

    @Column
    private String created_time;

    @Column
    private String modified_time;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    private Set<Article> articles;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    private List<Tag> tagList;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    private Set<Comment> commentList;

}
