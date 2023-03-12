package com.example.Blog.service.impl;

import com.example.Blog.Entity.Tag;
import com.example.Blog.repository.TagDao;
import com.example.Blog.repository.TagDaoImpl;
import com.example.Blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagDaoImpl tagDaoImpl;

    @Autowired
    TagDao tagDao;

    @Override
    public List<Tag> getTagbyUserId(Integer userId){

        List<Tag> tags = tagDao.findByUser_id(userId);
        //tags.forEach((n) -> n.setArticleList(null));
        return tags;
    }

    @Override
    public Tag getTagbyArticleId(Integer Id){
        Tag tag = tagDaoImpl.findByArticleId(Id).get(0);
        return tag;
    };
}
