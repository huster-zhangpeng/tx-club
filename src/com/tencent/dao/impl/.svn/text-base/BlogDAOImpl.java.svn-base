package com.tencent.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.tencent.dao.IBlogDAO;
import com.tencent.model.Blog;

public class BlogDAOImpl extends DAOImpl<Blog> implements IBlogDAO {
	public static Logger log = Logger.getLogger(BlogDAOImpl.class);

    @SuppressWarnings("unchecked")
    @Override
    public Blog findByTitle(String title) {
        List<Blog> list = this.getHibernateTemplate().find("from Blog b where b.title=?", title);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
