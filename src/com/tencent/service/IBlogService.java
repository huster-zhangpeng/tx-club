package com.tencent.service;

import com.tencent.model.Blog;
import com.tencent.model.User;

public interface IBlogService extends IService<Blog> {

    public Blog publishBlog(User user, String title, String content);

    Blog findByTitle(String title);
}
