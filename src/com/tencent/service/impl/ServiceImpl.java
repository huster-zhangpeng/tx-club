package com.tencent.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.tencent.dao.IDao;
import com.tencent.model.BaseBean;
import com.tencent.service.IService;

public class ServiceImpl<E extends BaseBean> implements IService<E> {
	public static Logger log = Logger.getLogger(ServiceImpl.class);

    protected IDao<E> dao;

    @Override
    public E getById(Class<E> clazz, int id) {
        return (E) dao.findById(clazz, id);
    }

    @Override
    public int save(E instance) {
        return dao.save(instance);
    }

    @Override
    public void delete(E instance) {
        dao.delete(instance);
    }

    @Override
    public void modify(E instance) {
        dao.update(instance);
    }
    
    public int getRowCount(String entityName){
    	return dao.getRowCount(entityName);
    }

	@Override
    public List<?> list(String hql) {
        return dao.list(hql);
    }

	@Override
    public List<?> list(String hql, int firstResult, int maxSize,
            Object... params) {
        return dao.list(hql, firstResult, maxSize, params);
    }
	
	public E getIndex(String entity, int index){
		return dao.getIndex(entity, index);
	}
}
