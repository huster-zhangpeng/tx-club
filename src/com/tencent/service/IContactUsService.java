package com.tencent.service;

import com.tencent.model.ContactUs;

public interface IContactUsService extends IService<ContactUs> {

    public ContactUs add(ContactUs contact);
	public ContactUs findByContent(String content);
}
