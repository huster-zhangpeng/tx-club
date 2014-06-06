package com.tencent.service.impl;

import org.apache.log4j.Logger;

import com.tencent.dao.IBlogDAO;
import com.tencent.dao.impl.BlogDAOImpl;
import com.tencent.model.Blog;
import com.tencent.model.User;
import com.tencent.service.IBlogService;

public class BlogServiceImpl extends ServiceImpl<Blog> implements IBlogService {
	public static Logger log = Logger.getLogger(BlogServiceImpl.class);

    @Override
    public Blog publishBlog(User user, String title, String content) {
        Blog blog = new Blog();
        blog.setAuthor(user);
        blog.setTitle(title);
        user.getBlogs().add(blog);
        blog.setContent(content);
        int id = ((BlogDAOImpl) super.dao).save(blog);
        return super.dao.findById(Blog.class, id);
    }

    @Override
    public Blog findByTitle(String title) {
        return ((IBlogDAO) super.dao).findByTitle(title);
    }

    public void setDao(IBlogDAO dao) {
        this.dao = dao;
    }

}
