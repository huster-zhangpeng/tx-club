package com.tencent.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.tencent.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = true)
public class UserServiceImplTest {
	public static Logger log = Logger.getLogger(UserServiceImplTest.class);
	
	private User user = new User("username", "password", "M", "test@qq.com",
            "935789181", "13871398643", "CS", "大二", 0, "description", 1, 1);
	private IUserService userService;

	@Resource(name="userService")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@After
	public void tearDown() throws Exception {
		User t_user = userService.findByName("username");
		if(t_user != null){
			userService.delete(t_user);
		}
	}

	@Test
	public final void testFindByName() {
		int id = userService.save(user);
		User t_user = userService.findByName("username");
		assertEquals(id, t_user.getId());
	}

	@Test
	public final void testFindByProperty() {
		int id = userService.save(user);
		User t_user = userService.findByProperty("username", "username");
		assertEquals(id, t_user.getId());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public final void testList() {
		List<User> list = (List<User>) userService.list("from User");
		for(User user : list){
			System.out.println(user.getUsername());
		}
		System.out.println(System.getProperty("user.dir")); 
		assertTrue(!list.isEmpty());
	}
	
	@Test
	public final void testUpdata() {
		User user = this.userService.findByName("xiayi2491259");
		user.setDescription("Web菜鸟");
		userService.modify(user);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public final void test() {
		int i = 0;
		List<User> users = (List<User>) userService.list("from User");
		//ctx.put("users", users);
		++i;
		if(i < users.size() && i >= 0){
			user = users.get(i);
		}
	}

}
