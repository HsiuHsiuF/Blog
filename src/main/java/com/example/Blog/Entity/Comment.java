package com.example.Blog.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String name;
    @Column
    private String content;

    @Column
    private String created_time;

    @ManyToOne
//    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name="article_id")
    private Article article;


}
