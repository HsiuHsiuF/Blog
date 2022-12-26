package com.example.Blog.service;

import com.example.Blog.Entity.Tag;

import java.util.List;

public interface TagService {

    public List<Tag> getTagbyUserName(String userName);
}
