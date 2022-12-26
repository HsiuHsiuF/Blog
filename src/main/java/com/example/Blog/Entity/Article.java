package com.example.Blog.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

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
    private int islock;

    @Column
    private String password;

    @Column
    private String password_hint;

    @Column
    private String created_time;

    @Column
    private String modified_time;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="tag_id")
    private Tag tag;

    @OneToMany(mappedBy = "article")
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    private Set<Comment> commentList;
}
