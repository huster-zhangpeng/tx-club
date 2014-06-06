package com.tencent.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tencent.dao.IDao;

public class DAOImpl<T> extends HibernateDaoSupport implements IDao<T> {
	public static Logger log = Logger.getLogger(DAOImpl.class);

	@Override
	public T findById(Class<T> clazz, int id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	@Override
	public int save(T baseBean) {
		return (Integer) this.getHibernateTemplate().save(baseBean);
	}

	@Override
	public void delete(T baseBean) {
		this.getHibernateTemplate().delete(baseBean);
	}

	@Override
	public void update(T baseBean) {
		this.getHibernateTemplate().update(baseBean);
	}

	public int getRowCount(String entityName) {
		String hql = "select count(*) from " + entityName;
		Iterator<?> iterator = this.getHibernateTemplate().iterate(hql);
		if (iterator.hasNext())
			return ((Long) iterator.next()).intValue();
		return 0;
	}

	@Override
	public List<?> list(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public List<?> list(String hql, int firstResult, int maxResults,
			Object... params) {
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<?> list = query.setFirstResult(firstResult)
				.setMaxResults(maxResults).list();
		return list;
	}
	
	public T getIndex(String entity, int index){
		String hql = "select from " + entity;
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) this.list(hql, index, 1);
		return (T) list.get(0);
	}
}
