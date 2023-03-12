package com.example.Blog.service;

import com.example.Blog.Entity.Tag;

import java.util.List;

public interface TagService {

    public List<Tag> getTagbyUserId(Integer userId);

    public Tag getTagbyArticleId(Integer Id);
}
