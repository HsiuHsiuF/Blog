package com.example.Blog.service;

import com.example.Blog.Entity.Tag;
import com.example.Blog.Entity.TagInput;

import java.util.List;

public interface TagService {

    public List<Tag> getTagbyUsername(String username);

    public Tag getTagByArticleId(Integer id);

    public Tag getTagById(Integer id);

    public String addTag(TagInput tagInput, String username);

    public boolean deleteTag(Integer id);

    public boolean updateTag(TagInput tagInput, Integer tagId);
}
