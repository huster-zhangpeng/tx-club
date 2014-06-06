package com.tencent.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.tencent.dao.IContactUsDAO;
import com.tencent.model.ContactUs;
import com.tencent.service.IContactUsService;

public class ContactUsServiceImpl extends ServiceImpl<ContactUs> implements IContactUsService {
	public static Logger log = Logger.getLogger(ContactUsServiceImpl.class);

    @Override
    public ContactUs findByContent(String content) {
        return ((IContactUsDAO) super.dao).findByContent(content);
    }

    @Override
    public ContactUs add(ContactUs contact) {
        int id = ((IContactUsDAO) super.dao).save(contact);
        return super.dao.findById(ContactUs.class, id);
    }

    @Resource(name="contactUsDao")
    public void setDao(IContactUsDAO dao) {
        this.dao = dao;
    }

}
