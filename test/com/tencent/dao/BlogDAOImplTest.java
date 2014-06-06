package com.tencent.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.tencent.model.Blog;
import com.tencent.model.User;

@ContextConfiguration({ "/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = true)
public class BlogDAOImplTest {
	public static Logger log = Logger.getLogger("BlogDAOImplTest.class");

	private Blog blog = new Blog("title", "content", 1);
	private User user = new User("username", "password", "M", "test@qq.com",
			"935789181", "13871398643", "CS", "大二", 0, "description", 1, 1);
	private User t_user;
	private static IBlogDAO blogDao;
	private static IUserDAO userDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		blogDao = (IBlogDAO) ctx.getBean("blogDao");
		userDao = (IUserDAO) ctx.getBean("userDao");
	}
	

	@Before
	public void setup() throws Exception {
		t_user = userDao.findByName("username");
		if(t_user == null){
			int id = userDao.save(user);
			t_user = userDao.findById(User.class, id);
		}
		blog.setAuthor(t_user);
	}

	@After
	public void tearDown() throws Exception {
		Blog t_blog = blogDao.findByTitle("title");
		if (t_blog != null) {
			blogDao.delete(t_blog);
		}
		t_user = userDao.findByName("name");
		if(t_user != null){
			userDao.delete(t_user);
		}
	}

	@Test
	@Rollback(true)
	public final void testFindByTitle() {
		int id = blogDao.save(blog);
		Blog t_blog = blogDao.findByTitle("title");
		assertEquals("title", t_blog.getTitle());
		assertEquals(id, t_blog.getId());
	}

	@Test
	@Rollback(true)
	public final void testFindById() {
		int id = blogDao.save(blog);
		Blog t_blog = blogDao.findById(Blog.class, id);
		assertEquals(id, t_blog.getId());
	}

	@Test
	public final void testSave() {
		int id = blogDao.save(blog);
		Blog t_blog = blogDao.findById(Blog.class, id);
		assertEquals(id, t_blog.getId());
	}

	@Test
	public final void testDelete() {
		int id = blogDao.save(blog);
		Blog t_blog = blogDao.findById(Blog.class, id);
		blogDao.delete(t_blog);
		t_blog = null;
		t_blog = blogDao.findById(Blog.class, id);
		assertNull(t_blog);
	}

	@Test
	public final void testUpdate() {
		int id = blogDao.save(blog);
		Blog t_blog = blogDao.findById(Blog.class, id);
		t_blog.setContent("test");
		blogDao.update(t_blog);
		t_blog = null;
		t_blog = blogDao.findById(Blog.class, id);
		assertEquals("test", t_blog.getContent());
	}

	@SuppressWarnings("unchecked")
	@Test
	public final void testListString() {
		int id = blogDao.save(blog);
		List<Blog> list = (List<Blog>) blogDao.list("from Blog");
		assertTrue(!list.isEmpty());
		assertEquals(id, list.get(0).getId());
	}


	@SuppressWarnings("unchecked")
	@Test
	public final void testListStringIntIntObjectArray() {
		blogDao.save(blog);
		List<Object[]> list = (List<Object[]>) blogDao.list(
				"select b.title,b.content from Blog b where b.title=? and b.content=?", 0, 1, "title",
				"content");
		assertTrue(!list.isEmpty());
		assertEquals("title",(String)list.get(0)[0]);
	}

}
