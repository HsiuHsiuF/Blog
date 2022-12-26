package com.example.Blog;

import com.example.Blog.Entity.Article;
import com.example.Blog.Entity.Tag;
import com.example.Blog.Entity.User;
import com.example.Blog.repository.ArticleDao;
import com.example.Blog.repository.CommentDao;
import com.example.Blog.repository.TagDao;
import com.example.Blog.repository.UserDao;
import com.example.Blog.service.impl.UserServiceImpl;
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

	@Autowired
	private TagDao tagDao;

	@Autowired
	private CommentDao commentDao;

	@Autowired
	private UserServiceImpl userService;

	@Test
	public void add(){
		User user1 = new User();
		user1 = userDao.findByUsername("aaa");
		System.out.println(user1.getId());
		Tag tag1 = new Tag();
		tag1 = tagDao.findById(3).get();
		System.out.println(tag1.getTag_id());
		Article article = new Article();
		article.setTitle("海港城");
		article.setContent("吃吃吃一直吃");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		article.setCreated_time(date);
		article.setModified_time(date);
		article.setUser(user1);
		article.setTag(tag1);

		articleDao.save(article);
	}

	@Test
	public void addTag(){
		User user1 = new User();
		user1 = userDao.findByUsername("aaa");
		System.out.println(user1.getId());
		Tag tag = new Tag();
		tag.setName("吃吃吃");
		tag.setUser(user1);
		tagDao.save(tag);
	}
//
//	@Test
//	public void addComment(){
//		User user1 = new User();
//		user1 = userDao.findByUsername("abc123456");
//		System.out.println(user1.getId());
//		Article article1 = new Article();
//		article1 = articleDao.findById(4).get();
//		Comment comment = new Comment();
//		comment.setContent("789");
//		comment.setUser(user1);
//		comment.setArticle(article1);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String date = df.format(new Date());
//		comment.setCreated_time(date);
//		commentDao.save(comment);
//	}
//
//    @Test
//    public void findArticleByUser_id(){
//        Article article = new Article();
//        article = articleDao.findById(1).get();
//        System.out.println("標題: "+article.getTitle());
//        System.out.println("內容: "+article.getContent());
//        List<Comment> commentList = article.getCommentList();
//        if(commentList.isEmpty()){
//			System.out.println("留言:無");
//		}else {
//			for (Comment comment : commentList) {
//				System.out.println("留言: " + comment.getContent());
//			}
//		}
//    }

//	@Test
//	public void user() throws ParseException {
//		UserLogin user = new UserLogin();
//		user.setName(null);
//		user.setPassword("123");
//		String result = userService.login(user);
//		System.out.println(result);
//	}

}
