package com.tencent.dao.impl;

import java.util.List;

import com.tencent.dao.IProjectDAO;
import com.tencent.model.Project;

public class ProjectDAOImpl extends DAOImpl<Project> implements IProjectDAO {

    @SuppressWarnings("unchecked")
    @Override
    public Project findByName(String name) {
        List<Project> list = this.getHibernateTemplate().find("from Project p where p.name=?", name);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
