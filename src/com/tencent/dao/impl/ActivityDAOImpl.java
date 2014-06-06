package com.tencent.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.tencent.dao.IActivityDAO;
import com.tencent.model.Activity;

public class ActivityDAOImpl extends DAOImpl<Activity> implements IActivityDAO {
	public static Logger log = Logger.getLogger(ActivityDAOImpl.class);

    @SuppressWarnings("unchecked")
    public Activity findByName(String name) {
        List<Activity> list = this.getHibernateTemplate().find("from Activity as a where a.name=?", name);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Activity> findByLocation(String location) {
        List<Activity> list = this.getHibernateTemplate().find("from Activity as a where a.location=?", location);
        return list;
    }
}
