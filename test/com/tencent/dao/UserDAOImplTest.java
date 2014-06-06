package com.tencent.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import com.tencent.model.User;

@ContextConfiguration({"/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = true)
public class UserDAOImplTest {

    public static Logger log = Logger.getLogger(UserDAOImplTest.class);
    private User user = new User("username", "password", "M", "test@qq.com",
            "935789181", "13871398643", "CS", "大二", 0, "description", 1, 1);
    private static IUserDAO userDao;

    @BeforeClass
    public static void setUpClass() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        userDao = (IUserDAO) ctx.getBean("userDao");
    }

    @Before
    public void setUp() {
        userDao.save(user);
    }

    @After
    public void tearDown() {
        User t_user = userDao.findByName("username");
        if (t_user != null) {
            userDao.delete(t_user);
        }
    }

    @Test
    public void testFindByName() {
        User t_user = userDao.findByName("username");
        assertNotNull(t_user);
        assertEquals(t_user.getUsername(), user.getUsername());
    }

    @Test
    public void testFindByProperty() {
        User t_user = userDao.findByProperty("password", "password");
        assertNotNull(t_user);
        assertEquals(t_user.getUsername(), user.getUsername());
    }
}
