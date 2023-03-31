package com.example.Blog.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String e_mail;

    @Column
    private String username;

    @Column
    private String password;
    @Column
    private String salt;

    @Column
    private String phone;

    @Column
    private Date birthday;

    @Column
    private String created_time;

    @Column
    private String modified_time;

    @OneToMany(mappedBy = "user")
//    @JsonManagedReference
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<Article> articles;

    @OneToMany(mappedBy = "user")
//    @JsonManagedReference
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private List<Tag> tagList;

//    @JsonBackReference 正常序列化 反序列化
//    @JsonManagedReference  data to json 会被序列化
//    @JsonIgnore  直接忽略子实体

}
