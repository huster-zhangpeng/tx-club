package com.tencent.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.tencent.model.Blog;
import com.tencent.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = true)
public class BlogServiceImplTest {

    public static Logger log = Logger.getLogger(BlogServiceImplTest.class);
    private static Blog blog = new Blog("title", "content", 1);
    private IBlogService blogService;

    @Resource
    public void setBlogService(IBlogService blogService) {
        this.blogService = blogService;
    }

    @After
    public void tearDown() {
        Blog t_blog = blogService.findByTitle("title");
        if (t_blog != null) {
            blogService.delete(t_blog);
        }
    }

    /**
     * Test of publishBlog method, of class BlogServiceImpl.
     */
    @Test
    public void testPublishBlog() {
        User t_user = new User("username", "password", "M", "test@qq.com",
                "935789181", "13871398643", "CS", "大二", 0, "description", 1, 1);
        Blog t_blog = blogService.publishBlog(t_user, "title", "content");
        Blog t2_blog = blogService.findByTitle("title");
        assertEquals(t_blog.getContent(), t2_blog.getContent());
    }

    /**
     * Test of findByTitle method, of class BlogServiceImpl.
     */
    @Test
    public void testFindByTitle() {
        blogService.save(blog);
        Blog t_blog = blogService.findByTitle("title");
        assertNotNull(t_blog);
        assertEquals(t_blog.getAuthor(), blog.getAuthor());
    }
    
    @Test
    public void testList() {
    	blogService.save(blog);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) blogService.list(
				"select b.title,b.content from Blog b where b.title=? and b.content=?", 0, 1, "title",
				"content");
		assertTrue(!list.isEmpty());
		assertEquals("title",(String)list.get(0)[0]);
    }
}
