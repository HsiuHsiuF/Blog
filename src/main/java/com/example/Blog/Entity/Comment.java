package com.example.Blog.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer comment_id;

    @Column
    private String content;

    @Column
    private String created_time;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="article_id")
    private Article article;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="user_id")
    private User user;
}
