package com.example.Blog.repository;

import com.example.Blog.Entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagDao extends JpaRepository<Tag, Integer> {

    public List<Tag> findByUser_id(Integer id);
}
