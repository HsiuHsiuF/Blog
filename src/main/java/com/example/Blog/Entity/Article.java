package com.example.Blog.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "article")
@Data
public class Article {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer article_id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String password;

    @Column
    private String password_hint;

    @Column
    private String created_time;

    @Column
    private String modified_time;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
