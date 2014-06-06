package com.tencent.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.tencent.model.Resource;

@ContextConfiguration({ "/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = true)
public class ResourceDAOImplTest {
	public static Logger log = Logger.getLogger(ResourceDAOImplTest.class);

	private static com.tencent.model.Resource resource;
	private static IResourceDAO resourceDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		resourceDao = (IResourceDAO) ctx.getBean("resourceDao");
		resource = new com.tencent.model.Resource("title", 1, 1, "cause",
				"content");
	}

	@After
	public void tearDown() throws Exception {
		com.tencent.model.Resource t_resource = resourceDao
				.findByTitle("title");
		if (t_resource != null) {
			resourceDao.delete(t_resource);
		}
	}

	@Test
	public final void testFindBytitle() {
		int id = resourceDao.save(resource);
		com.tencent.model.Resource t_resource = resourceDao
				.findByTitle("title");
		assertEquals(id, t_resource.getId());
	}

	@Test
	public final void testFindById() {
		int id = resourceDao.save(resource);
		com.tencent.model.Resource t_resource = resourceDao.findById(
				com.tencent.model.Resource.class, id);
		assertNotNull(t_resource);
		assertEquals(id, t_resource.getId());
	}

	@Test
	public final void testSave() {
		int id = resourceDao.save(resource);
		com.tencent.model.Resource t_resource = resourceDao.findById(
				com.tencent.model.Resource.class, id);
		assertEquals(id, t_resource.getId());
	}

	@Test
	public final void testDelete() {
		int id = resourceDao.save(resource);
		com.tencent.model.Resource t_resource = resourceDao.findById(
				com.tencent.model.Resource.class, id);
		resourceDao.delete(t_resource);
		t_resource = resourceDao.findById(com.tencent.model.Resource.class, id);
		assertNull(t_resource);
	}

	@Test
	public final void testUpdate() {
		int id = resourceDao.save(resource);
		com.tencent.model.Resource t_resource = resourceDao.findById(
				com.tencent.model.Resource.class, id);
		t_resource.setCause("test");
		t_resource.setInput(100);
		resourceDao.update(t_resource);
		t_resource = null;
		t_resource = resourceDao.findById(com.tencent.model.Resource.class, id);
		assertEquals("test", t_resource.getCause());
		assertEquals(100, t_resource.getInput());
	}

	@SuppressWarnings("unchecked")
	@Test
	public final void testListString() {
		int id = resourceDao.save(resource);
		List<com.tencent.model.Resource> list = (List<Resource>) resourceDao
				.list("from Resource");
		assertTrue(!list.isEmpty());
		assertEquals(1, list.size());
		assertEquals(id, list.get(0).getId());
	}

	@Test
	public final void testListStringIntIntObjectArray() {
		int id = resourceDao.save(resource);
		@SuppressWarnings("unchecked")
		List<com.tencent.model.Resource> list = (List<Resource>) resourceDao.list(
				"from Resource r where r.content=? and r.status=?", 0, 1,
				"content", 1);
		assertTrue(!list.isEmpty());
		assertEquals(1, list.size());
		assertEquals(id, list.get(0).getId());
	}

}
