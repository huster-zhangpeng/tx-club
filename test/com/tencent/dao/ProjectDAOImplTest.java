package com.tencent.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.tencent.model.Project;
import com.tencent.model.User;

@ContextConfiguration({ "/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = true)
public class ProjectDAOImplTest {
	public static Logger log = Logger.getLogger("ProjectDAOImplTest.class");

	private Project project = new Project("name", 0, "description", 1);
	private User user = new User("username", "password", "M", "test@qq.com",
			"935789181", "13871398643", "CS", "大二", 0, "description", 1, 1);
	private User t_user;
	private static IProjectDAO projectDao;
	private static IUserDAO userDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		projectDao = (IProjectDAO) ctx.getBean("projectDao");
		userDao = (IUserDAO) ctx.getBean("userDao");
	}

	@Before
	public void setUp() throws Exception {
		int id = userDao.save(user);
		t_user = userDao.findById(User.class, id);
		project.setCharger(t_user);
		project.setConsignor(t_user);
	}

	@After
	public void tearDown() throws Exception {
		Project t_project = projectDao.findByName("name");
		if (t_project != null) {
			projectDao.delete(t_project);
		}
		t_user = userDao.findByName("username");
		if(t_user != null){
			userDao.delete(t_user);
		}
	}

	@Test
	public final void testFindByName() {
		projectDao.save(project);
		Project t_project = projectDao.findByName("name");
		assertEquals("name", t_project.getName());
	}

	@Test
	public final void testFindById() {
		int id = projectDao.save(project);
		Project t_project = projectDao.findById(Project.class, id);
		assertNotNull(t_project);
		assertEquals(id, t_project.getId());
	}

	@Test
	public final void testSave() {
		int id = projectDao.save(project);
		Project t_project = projectDao.findById(Project.class, id);
		assertNotNull(t_project);
		assertEquals(id, t_project.getId());
	}

	@Test
	public final void testDelete() {
		int id = projectDao.save(project);
		Project t_project = projectDao.findById(Project.class, id);
		projectDao.delete(t_project);
		t_project = projectDao.findById(Project.class, id);
		assertNull(t_project);
	}

	@Test
	public final void testUpdate() {
		int id = projectDao.save(project);
		Project t_project = projectDao.findById(Project.class, id);
		t_project.setDescription("test");
		t_project.setState(2);
		projectDao.update(t_project);
		t_project = null;
		t_project = projectDao.findById(Project.class, id);
		assertEquals("test", t_project.getDescription());
		assertEquals(2, t_project.getState());
	}

	@SuppressWarnings("unchecked")
	@Test
	public final void testListString() {
		int id = projectDao.save(project);
		List<Project> list = (List<Project>) projectDao.list("from Project");
		assertTrue(!list.isEmpty());
		assertEquals(1, list.size());
		assertEquals(id, list.get(0).getId());
	}

	@Test
	public final void testListStringIntIntObjectArray() {
		int id = projectDao.save(project);
		@SuppressWarnings("unchecked")
		List<Project> list = (List<Project>) projectDao.list(
				"from Project p where p.name=? and p.state=?", 0, 1, "name", 1);
		assertTrue(!list.isEmpty());
		assertEquals(1, list.size());
		assertEquals("name", list.get(0).getName());
		assertEquals(id, list.get(0).getId());
	}

}
