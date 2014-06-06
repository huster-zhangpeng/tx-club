package com.tencent.service.impl;

import com.tencent.dao.IUserDAO;
import com.tencent.dao.impl.UserDAOImpl;
import com.tencent.model.User;
import com.tencent.service.IUserService;

public class UserServiceImpl extends ServiceImpl<User> implements IUserService {

    @Override
    public User findByName(String name) {
        return ((UserDAOImpl) dao).findByName(name);
    }

    @Override
    public User findByProperty(String property, Object value) {
        return ((IUserDAO)super.dao).findByProperty(property, value);   
    }

    public void setDao(IUserDAO dao) {
        this.dao = dao;
    }
	
	public IUserDAO getDao(){
		return (IUserDAO) this.dao;
	}
}
