package com.tencent.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.tencent.dao.IUserDAO;
import com.tencent.model.User;

public class UserDAOImpl extends DAOImpl<User> implements IUserDAO {
	public static Logger log = Logger.getLogger(UserDAOImpl.class);

    @SuppressWarnings("unchecked")
    @Override
    public User findByName(String name) {
        List<User> list = this.getHibernateTemplate().find("from User u where u.username=?", name);
        if(list.iterator().hasNext()){
        	return list.get(0);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public User findByProperty(String property, Object value) {
        List<User> list = this.getHibernateTemplate().find("from User u where u." + property + "=?", value);
        if(list.isEmpty()){
        	return null;
        }
        return list.get(0);
    }
}
