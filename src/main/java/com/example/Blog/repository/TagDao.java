package com.example.Blog.repository;

import com.example.Blog.Entity.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagDao extends CrudRepository<Tag, Integer> {
}
