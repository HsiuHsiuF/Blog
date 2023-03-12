package com.example.Blog.Entity;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ArticleInput {

    @Column
    private String title;

    @Column
    private String content;
}
