package com.tencent.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.tencent.model.ContactUs;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = true)
public class ContactUsDAOImplTest {
	public static Logger log = Logger.getLogger(ContactUsDAOImplTest.class);
	
	private ContactUs contactUs = new ContactUs();
	@Resource
	private IContactUsDAO contactUsDao;
	
	public void setDao(IContactUsDAO dao) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.contactUsDao = (IContactUsDAO) ctx.getBean("contactUsDao");
    }
	
	public IContactUsDAO getDao(){
		return (IContactUsDAO) this.contactUsDao;
	}
	
	@Before
	public void setUp() throws Exception {
		contactUs.setContent("content");
	}

	@After
	public void tearDown() throws Exception {
		ContactUs t_contactUs = contactUsDao.findByContent("content");
		if(t_contactUs != null){
			contactUsDao.delete(t_contactUs);
		}
	}

	@Test
	@Transactional
	public final void testFindByContent() {
		contactUsDao.save(contactUs);
		ContactUs t_contactUs = contactUsDao.findByContent("content");
		assertEquals("content", t_contactUs.getContent());
	}

	@Test
	@Transactional
	public final void testFindById() {
		int id = contactUsDao.save(contactUs);
		ContactUs t_contactUs = contactUsDao.findById(ContactUs.class, id);
		assertEquals(id,t_contactUs.getId());
	}

	@Test
	@Transactional
	public final void testSave() {		 		
		int id = contactUsDao.save(contactUs);
		assertTrue(id > 0);
	}

	@Test
	@Transactional
	public final void testDelete() {
		int id = contactUsDao.save(contactUs);
		ContactUs t_contactUs = contactUsDao.findById(ContactUs.class, id);
		contactUsDao.delete(t_contactUs);
		t_contactUs = null;
		t_contactUs = contactUsDao.findById(ContactUs.class, id);
		assertNull(t_contactUs);
	}

	@Test
	@Transactional
	public final void testUpdate() {
		int id = contactUsDao.save(contactUs);
		ContactUs t_contactUs = contactUsDao.findById(ContactUs.class, id);
		t_contactUs.setContent("testUpdate");
		contactUsDao.update(t_contactUs);
		ContactUs resoult = contactUsDao.findById(ContactUs.class, id);
		assertEquals("testUpdate",resoult.getContent());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public final void testList() {
		int id = contactUsDao.save(contactUs);
		List<ContactUs> list = (List<ContactUs>) contactUsDao.list("from ContactUs");
		assertTrue(!list.isEmpty());
		assertEquals(id, list.get(0).getId());
	}

	@Test
	public final void testList1() {
		int id = contactUsDao.save(contactUs);
		@SuppressWarnings("unchecked")
		List<ContactUs> list = (List<ContactUs>) contactUsDao.list(
				"from ContactUs as a where a.nickname=? and a.content=?", 0, 1,
				"匿名","content");
		assertTrue(!list.isEmpty());
		assertTrue(list.size() == 1);
		assertEquals(id, list.get(0).getId());
	}
}
