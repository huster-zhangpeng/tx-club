package com.tencent.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.tencent.dao.IContactUsDAO;
import com.tencent.model.ContactUs;

public class ContactUsDAOImpl extends DAOImpl<ContactUs> implements
		IContactUsDAO {
	public static Logger log = Logger.getLogger(ContactUsDAOImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public ContactUs findByContent(String content) {
		List<ContactUs> list = this.getHibernateTemplate().find(
				"from ContactUs as c where c.content=?", content);
		if (list.iterator().hasNext()) {
			return list.get(0);
		}
		return null;
	}
}
