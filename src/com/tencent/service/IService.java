package com.tencent.service;

import java.util.List;

public interface IService<E> {

    public E getById(Class<E> clazz, int id);

    public int save(E instance);

    public void delete(E instance);

    public void modify(E instance);
    
    public int getRowCount(String entityName);

	public List<?> list(String hql);

	public List<?> list(String hql, int firstResult, int maxSize, Object... params);
	
	public E getIndex(String entity, int index);

}
