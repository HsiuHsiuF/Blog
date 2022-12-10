package com.example.Blog.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer tag_id;

    @Column
    private String name;

    @OneToMany(mappedBy = "tag")
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    private Set<Article> articleList;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="user_id")
    private User user;


}
