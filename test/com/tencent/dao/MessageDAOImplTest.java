package com.tencent.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Blob;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.tencent.model.Message;
import com.tencent.model.User;

@ContextConfiguration({ "/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = true)
public class MessageDAOImplTest {
	public static Logger log = Logger.getLogger(MessageDAOImplTest.class);

	private Message message = new Message("topic", false, 1);
	private User user = new User("username", "password", "M", "test@qq.com",
			"935789181", "13871398643", "CS", "大二", 0, "description", 1, 1);
	private static IMessageDAO messageDao;
	private static IUserDAO userDao;
	private User t_user;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		messageDao = (IMessageDAO) ctx.getBean("messageDao");
		userDao = (IUserDAO) ctx.getBean("userDao");
	}

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		int id = userDao.save(user);
		t_user = userDao.findById(User.class, id);
		message.setSender(t_user);
		Blob blob = (Blob) Hibernate.createBlob("content".getBytes());
		message.setContent(blob);
	}

	@After
	public void tearDown() throws Exception {
		Message t_message = messageDao.findByTopic("topic");
		if(t_message != null){
			messageDao.delete(t_message);
		}
		t_user = userDao.findByName("username");
		if(t_user != null){
			userDao.delete(t_user);
		}
		
	}

	@Test
	public final void testListOutDateUserBoolean() {
		int id = messageDao.save(message);
		List<Message> list = messageDao.listOutDate(t_user, false);
		assertTrue(!list.isEmpty());
		assertEquals(id, list.get(0).getId());
	}

	@Test
	public final void testListOutDateUserBooleanIntInt() {
		int id = messageDao.save(message);
		List<Message> list = messageDao.listOutDate(t_user, false, 0, 1);
		assertTrue(!list.isEmpty());
		assertEquals(id, list.get(0).getId());
	}

	@Test
	public final void testFindById() {
		int id = messageDao.save(message);
		Message t_message = messageDao.findById(Message.class, id);
		assertEquals(id, t_message.getId());
	}

	@Test
	public final void testSave() {
		int id = messageDao.save(message);
		Message t_message = messageDao.findById(Message.class, id);
		assertNotNull(t_message);
		assertEquals(id, t_message.getId());
	}

	@Test
	public final void testDelete() {
		int id = messageDao.save(message);
		Message t_message = messageDao.findById(Message.class, id);
		messageDao.delete(t_message);
		t_message = messageDao.findById(Message.class, id);
		assertNull(t_message);
	}

	@Test
	public final void testUpdate() {
		int id = messageDao.save(message);
		Message t_message = messageDao.findById(Message.class, id);
		t_message.setOutdate(true);
		t_message.setType(2);
		messageDao.update(t_message);
		t_message = null;
		t_message = messageDao.findById(Message.class, id);
		assertEquals(true, t_message.getOutdate());
		assertEquals(2, t_message.getType());
	}

	@SuppressWarnings("unchecked")
	@Test
	public final void testListString() {
		int id = messageDao.save(message);
		List<Message> list = (List<Message>) messageDao.list("from Message");
		assertTrue(!list.isEmpty());
		assertEquals(id,list.get(0).getId());
	}

	@Test
	public final void testListStringIntIntObjectArray() {
		int id = messageDao.save(message);
		@SuppressWarnings("unchecked")
		List<Message> list = (List<Message>) messageDao.list("from Message m where m.topic=? and m.outdate=?", 0, 1, "topic",false);
		assertTrue(!list.isEmpty());
		assertEquals(id, list.get(0).getId());
	}

}
