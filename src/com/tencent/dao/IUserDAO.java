package com.tencent.dao;

import com.tencent.model.User;

public interface IUserDAO extends IDao<User> {

    public User findByName(String name);

    public User findByProperty(String property, Object value);
}
