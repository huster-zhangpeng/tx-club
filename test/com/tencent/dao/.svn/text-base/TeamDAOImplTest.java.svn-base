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
import com.tencent.model.Team;
import com.tencent.model.User;

@ContextConfiguration({"/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = true)
public class TeamDAOImplTest {

    public static Logger log = Logger.getLogger(TeamDAOImplTest.class);
    private static ITeamDAO teamDao;
    private static IUserDAO userDao;
    private static User user = new User("username", "password", "M", "test@qq.com",
			"935789181", "13871398643", "CS", "大二", 0, "description", 1, 1);
    private Team team = new Team("teamname", 1, "description", null, 1);

    @BeforeClass
    public static void setUpClass() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        teamDao = (ITeamDAO) ctx.getBean("teamDao");
        userDao = (IUserDAO) ctx.getBean("userDao");
        int id = userDao.save(user);
        user = userDao.findById(User.class, id);
    }

    @Before
    public void setUp() {
    	team.setMaster(user);
        teamDao.save(team);
    }

    @After
    public void tearDown() {
        Team t_team = teamDao.findByName("teamname");
        if (t_team != null) {
            teamDao.delete(t_team);
        }
    }

    @Test
    public void testFindByName() {
        Team t_team=teamDao.findByName("teamname");
        assertNotNull(t_team);
        assertEquals(t_team.getName(),team.getName());
    }
}
