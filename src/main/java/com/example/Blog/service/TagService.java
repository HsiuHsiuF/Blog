package com.example.Blog.service;

import com.example.Blog.Entity.Tag;
import com.example.Blog.Entity.TagInput;

import java.util.List;

public interface TagService {

    public List<Tag> getTagbyUserId(Integer userId);

    public Tag getTagByArticleId(Integer id);

    public Tag getTagById(Integer id);

    public String addTag(TagInput tagInput);

    public boolean deleteTag(Integer id);
}
