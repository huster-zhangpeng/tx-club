package com.tencent.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.tencent.dao.IMessageDAO;
import com.tencent.model.Message;
import com.tencent.model.User;

public class MessageDAOImpl extends DAOImpl<Message> implements IMessageDAO {
	public static Logger log = Logger.getLogger(MessageDAOImpl.class);

    @SuppressWarnings("unchecked")
    @Override
    public List<Message> listOutDate(User user, boolean isOutdate) {
        List<Message> list = this.getHibernateTemplate().find("from Message m where m.sender.id=? and m.outdate=?", user.getId(), isOutdate);
        return list;
    }

    @SuppressWarnings("unchecked")
	@Override
	public Message findByTopic(String topic) {
		List<Message> list = this.getHibernateTemplate().find("from Message m where m.topic=?", topic);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
    @Override
    public List<Message> listOutDate(User user, boolean isOutdate, int firstResult, int maxSize) {
        Query query = this.getSession().createQuery("from Message m where m.sender.id=? and m.outdate=?");
        query.setInteger(0, user.getId()).setBoolean(1, isOutdate);
        query.setFirstResult(firstResult).setMaxResults(maxSize);
        List<Message> list = query.list();
        return list;

    }
}
