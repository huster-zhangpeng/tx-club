package com.tencent.dao;

import java.util.List;

public interface IDao<T> {

    public T findById(Class<T> clazz, int id);

    public int save(T baseBean);

    public void delete(T baseBean);

    public void update(T baseBean);
    
    public int getRowCount(String entityName);

	public List<?> list(String hql);

	public List<?> list(String hql, int firstResult, int maxResults, Object... params);
	
	public T getIndex(String entity, int index);
}
