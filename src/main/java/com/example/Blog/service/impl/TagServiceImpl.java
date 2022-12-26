package com.example.Blog.service.impl;

import com.example.Blog.Entity.Tag;
import com.example.Blog.repository.TagDao;
import com.example.Blog.repository.UserDao;
import com.example.Blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    UserDao userDao;

    @Autowired
    TagDao tagDao;

    @Override
    public List<Tag> getTagbyUserName(String userName){
        Integer id = userDao.findByUsername(userName).getId();
        List<Tag> tags = tagDao.findByUser_id(id);
        tags.forEach((n) -> n.setArticleList(null));
        return tags;
    }
}
