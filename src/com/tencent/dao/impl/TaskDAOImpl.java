package com.tencent.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.tencent.dao.ITaskDAO;
import com.tencent.model.Task;

public class TaskDAOImpl extends DAOImpl<Task> implements ITaskDAO {
	public static Logger log = Logger.getLogger(TaskDAOImpl.class);

    @SuppressWarnings("unchecked")
    @Override
    public Task findByContent(String content) {
        List<Task> list = this.getHibernateTemplate().find("from Task t where t.content=?", content);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
