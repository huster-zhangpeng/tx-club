package com.tencent.dao.impl;

import com.tencent.dao.IResourceDAO;
import com.tencent.model.Resource;
import java.util.List;

import org.apache.log4j.Logger;

public class ResourceDAOImpl extends DAOImpl<Resource> implements IResourceDAO {
	public static Logger log = Logger.getLogger(ResourceDAOImpl.class);

    @SuppressWarnings("unchecked")
    @Override
    public Resource findByTitle(String title) {
        List<Resource> list = this.getHibernateTemplate().find("from Resource r where r.title=?", title);
        if(list.isEmpty()){
        	return null;
        }
        return list.get(0);
    }
}
