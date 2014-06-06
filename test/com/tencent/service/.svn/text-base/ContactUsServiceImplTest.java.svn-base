package com.tencent.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.tencent.model.ContactUs;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = true)
public class ContactUsServiceImplTest {
	public static Logger log = Logger.getLogger(ContactUsServiceImplTest.class);
	
	private static ContactUs contactUs = new ContactUs();
	private IContactUsService contactService;

	@Resource
	public void setContactService(IContactUsService contactService) {
		this.contactService = contactService;
	}
	
	@Before
	public void setUp() throws Exception {
		contactUs.setContent("content");
	}

	@After
	public void tearDown() throws Exception {
		ContactUs t_contactUs = contactService.findByContent("content");
		if(t_contactUs != null){
			contactService.delete(t_contactUs);
		}
	}

	@Test
	public final void testFindByContent() {
		int id = contactService.save(contactUs);
		ContactUs t_contactUs = contactService.findByContent("content");
		assertNotNull(t_contactUs);
		assertEquals(id, t_contactUs.getId());
	}

	@Test
	public final void testAdd() {
		ContactUs t_contactUs = contactService.add(contactUs);
		assertNotNull(t_contactUs);
		assertEquals("content", t_contactUs.getContent());
	}

	@Test
	public final void testGetById() {
		int id = contactService.save(contactUs);
		ContactUs t_contactUs = contactService.getById(ContactUs.class, id);
		assertEquals(id, t_contactUs.getId());
	}

	@Test
	public final void testSava() {
		int id = contactService.save(contactUs);
		ContactUs t_contactUs = contactService.getById(ContactUs.class, id);
		assertEquals(id, t_contactUs.getId());
	}

	@Test
	public final void testDelete() {
		int id = contactService.save(contactUs);
		ContactUs t_contactUs = contactService.getById(ContactUs.class, id);
		contactService.delete(t_contactUs);
		t_contactUs = null;
		t_contactUs = contactService.getById(ContactUs.class, id);
		assertNull(t_contactUs);
	}

	@Test
	public final void testModify() {
		int id = contactService.save(contactUs);
		ContactUs t_contactUs = contactService.getById(ContactUs.class, id);
		t_contactUs.setNickname("test");
		contactService.modify(t_contactUs);
		t_contactUs = null;
		t_contactUs = contactService.getById(ContactUs.class, id);
		assertEquals("test", t_contactUs.getNickname());
	}

	@Test
	public final void testListString() {
		int id = contactService.save(contactUs);
		@SuppressWarnings("unchecked")
		List<ContactUs> list = (List<ContactUs>) contactService.list("from ContactUs");
		assertTrue(!list.isEmpty());
		assertEquals(id, list.get(0).getId());
	}

	@Test
	public final void testListStringIntIntObjectArray() {
		int id = contactService.save(contactUs);
		@SuppressWarnings("unchecked")
		List<ContactUs> list = (List<ContactUs>) contactService.list(
				"from ContactUs as a where a.nickname=? and a.content=?", 0, 1,
				"匿名","content");
		assertTrue(!list.isEmpty());
		assertTrue(list.size() == 1);
		assertEquals(id, list.get(0).getId());
	}

}
