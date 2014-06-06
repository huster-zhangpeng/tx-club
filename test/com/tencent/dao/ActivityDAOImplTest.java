package com.tencent.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.tencent.model.Activity;
import com.tencent.model.User;

@ContextConfiguration({ "/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = true)
public class ActivityDAOImplTest {
	public static Logger log = Logger.getLogger(ActivityDAOImplTest.class);

	private static Activity activity;
	private static User user;
	private static IActivityDAO activityDao;
	private static IUserDAO userDao;

	@BeforeClass
	public static void init() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		activityDao = (IActivityDAO) ctx.getBean("activityDao");
		userDao = (IUserDAO) ctx.getBean("userDao");

		user = new User("username", "password", "M", "test@qq.com",
				"935789181", "13871398643", "CS", "大二", 0, "description", 1, 1);
		int id = userDao.save(user);
		user = userDao.findById(User.class, id);
		activity = new Activity("activity", "location", "description", 1,
				1);
		activity.setCreator(user);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		User t_user = userDao.findByName("username");
		if(t_user != null){
			userDao.delete(t_user);
		}
	}

	@After
	public void tearDown() throws Exception {
		Activity t_activity = activityDao.findByName("activity");
		if (t_activity != null) {
			activityDao.delete(t_activity);
		}
	}

	@Test
	public final void testFindByName() {
		activityDao.save(activity);
		Activity t_activity = activityDao.findByName("activity");
		assertEquals("activity", t_activity.getName());
	}

	@Test
	public final void testFindByLocation() {
		activityDao.save(activity);
		List<Activity> list = activityDao.findByLocation("location");
		assertFalse(list.isEmpty());
		assertEquals("location", list.get(0).getLocation());
	}

	@Test
	public final void testFindById() {
		int id = activityDao.save(activity);
		Activity t_activity = activityDao.findById(Activity.class, id);
		assertTrue(id == t_activity.getId());
	}

	@Test
	public final void testSave() {
		int id = activityDao.save(activity);
		Activity t_activity = activityDao.findById(Activity.class, id);
		assertNotNull(t_activity);
		assertTrue(id == t_activity.getId());
	}

	@Test
	public final void testDelete() {
		int id = activityDao.save(activity);
		activityDao.delete(activity);
		Activity t_activity = activityDao.findById(Activity.class, id);
		assertNull(t_activity);
	}

	@Test
	public final void testUpdate() {
		int id = activityDao.save(activity);
		Activity t_activity = activityDao.findById(Activity.class, id);
		t_activity.setLocation("沁苑");
		activityDao.update(t_activity);
		t_activity = null;
		t_activity = activityDao.findById(Activity.class, id);
		assertEquals("沁苑", t_activity.getLocation());
	}

	@SuppressWarnings("unchecked")
	@Test
	public final void testList() {
		int id = activityDao.save(activity);
		List<Activity> list = (List<Activity>) activityDao.list("from Activity");
		assertTrue(!list.isEmpty());
		assertEquals(id, list.get(0).getId());
	}

	@Test
	public final void testList1() {
		int id = activityDao.save(activity);
		@SuppressWarnings("unchecked")
		List<Activity> list = (List<Activity>) activityDao.list(
				"from Activity as a where a.name=? and a.location=?", 0, 1,
				"activity","location");
		assertTrue(!list.isEmpty());
		assertTrue(list.size() == 1);
		assertEquals(id, list.get(0).getId());
	}

}
