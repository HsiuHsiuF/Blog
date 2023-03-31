package com.example.Blog.service.impl;

import com.example.Blog.Entity.Tag;
import com.example.Blog.Entity.TagInput;
import com.example.Blog.Entity.User;
import com.example.Blog.repository.TagDao;
import com.example.Blog.repository.TagDaoImpl;
import com.example.Blog.repository.UserDao;
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

    @Autowired
    UserDao userDao;

    @Override
    public List<Tag> getTagbyUserId(Integer userId){

        List<Tag> tags = tagDao.findByUser_id(userId);
        //tags.forEach((n) -> n.setArticleList(null));
        return tags;
    }

    @Override
    public Tag getTagByArticleId(Integer id){
        Tag tag = tagDaoImpl.findByArticleId(id).get(0);
        return tag;
    };

    @Override
    public Tag getTagById(Integer id){
        Tag tag = tagDao.findById(id).get();
        return tag;
    };

    @Override
    public String addTag(TagInput tagInput){
        User user = userDao.findByUsername("aaa");
        Tag tag = new Tag();
        tag.setName(tagInput.getName());
        tag.setUser(user);
        Tag result = tagDao.save(tag);
        if(result == null)return"新增分類時發生錯誤";

        return"Success";
    };

    @Override
    public boolean deleteTag(Integer id){
        boolean result = tagDao.existsById(id);
        if(!result){
            return false;
        }
        tagDao.deleteById(id);
        return true;
    };

    @Override
    public boolean updateTag(TagInput tagInput, Integer tagId){
        Tag tag = tagDao.findById(tagId).get();
        tag.setName(tagInput.getName());
        Tag result = tagDao.save(tag);
        if(result == null)return false;

        return true;
    };
}
