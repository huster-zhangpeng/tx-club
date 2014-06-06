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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.tencent.model.Task;
import com.tencent.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = true)
public class TaskDAOImplTest {
	public static Logger log = Logger.getLogger(TaskDAOImplTest.class);

	private static User user = new User("username", "password", "M",
			"test@qq.com", "935789181", "13871398643", "CS", "大二", 0,
			"description", 1, 1);
	private User t_user;
	private static Task task = new Task("content", 1, true);

	private ITaskDAO taskDao;
	private IUserDAO userDao;

	public ITaskDAO getTaskDao() {
		return taskDao;
	}

	@Resource(name = "taskDao")
	public void setTaskDao(ITaskDAO taskDao) {
		this.taskDao = taskDao;
	}

	public IUserDAO getUserDao() {
		return userDao;
	}

	@Resource(name = "userDao")
	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	@Before
	public void setUp() throws Exception {
		int id = userDao.save(user);
		user = userDao.findById(User.class, id);
		task.setBuilder(user);
	}

	@After
	public void tearDown() throws Exception {
		Task t_task = taskDao.findByContent("content");
		if (t_task != null) {
			taskDao.delete(t_task);
		}
		t_user = userDao.findByName("username");
		if(t_user != null){
			userDao.delete(t_user);
		}
	}

	@Test
	public final void testFindByContent() {
		int id = taskDao.save(task);
		Task t_task = taskDao.findByContent("content");
		assertEquals(id, t_task.getId());
		assertEquals("content", t_task.getContent());
	}

	@Test
	public final void testFindById() {
		int id = taskDao.save(task);
		Task t_task = taskDao.findById(Task.class, id);
		assertEquals(id, t_task.getId());
	}

	@Test
	public final void testSave() {
		this.testFindById();
	}

	@Test
	public final void testDelete() {
		int id = taskDao.save(task);
		Task t_task = taskDao.findById(Task.class, id);
		taskDao.delete(t_task);
		t_task = taskDao.findByContent("content");
		assertNull(t_task);
	}

	@Test
	public final void testUpdate() {
		int id = taskDao.save(task);
		Task t_task = taskDao.findById(Task.class, id);
		t_task.setType(2);
		taskDao.update(t_task);
		t_task = taskDao.findById(Task.class, id);
		assertEquals(2, t_task.getType());
	}

	@SuppressWarnings("unchecked")
	@Test
	public final void testListString() {
		int id = taskDao.save(task);
		List<Task> list = (List<Task>) taskDao.list("from Task");
		assertTrue(!list.isEmpty());
		assertEquals(id, list.get(0).getId());
	}

	@Test
	public final void testListStringIntIntObjectArray() {
		int id = taskDao.save(task);
		@SuppressWarnings("unchecked")
		List<Task> list = (List<Task>) taskDao.list(
				"from Task t where t.type=? and t.content=?", 0, 1, 1,
				"content");
		assertEquals(1, list.size());
		assertEquals(id, list.get(0).getId());
	}

}
