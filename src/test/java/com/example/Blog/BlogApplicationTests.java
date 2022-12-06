package com.example.Blog;

import com.example.Blog.Entity.Article;
import com.example.Blog.Entity.User;
import com.example.Blog.repository.ArticleDao;
import com.example.Blog.repository.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BlogApplicationTests {

	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private UserDao userDao;

	@Test
	public void add(){
		User user1 = new User();
		user1 = userDao.findByUsername("abc123456");
		System.out.println(user1.getId());
		Article article = new Article();
		article.setTitle("123");
		article.setContent("456789");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		article.setCreated_time(date);
		article.setModified_time(date);
		article.setUser(user1);


		articleDao.save(article);
	}

}
