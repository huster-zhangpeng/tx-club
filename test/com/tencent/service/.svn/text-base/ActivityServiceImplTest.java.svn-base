package com.tencent.service;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.tencent.model.Activity;
import com.tencent.model.Team;
import com.tencent.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = true)
public class ActivityServiceImplTest {
	public static Logger log = Logger.getLogger(ActivityServiceImplTest.class);

	private User user = new User("username", "password", "M", "test@qq.com",
			"935789181", "13871398643", "CS", "大二", 0, "description", 1, 1);
	private Team team = new Team("team", 1, "description", null, 1);
	private Activity activity = new Activity("activity", "location",
			"description", 1, 1);
	private IUserService userService;
	private ITeamService teamService;
	private IActivityService activityService;

	@Resource(name="userService")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Resource(name="teamService")
	public void setTeamService(ITeamService teamService) {
		this.teamService = teamService;
	}

	@Resource(name="activityService")
	public void setActivityService(IActivityService activityService) {
		this.activityService = activityService;
	}

	@Before
	public void setUp() throws Exception {
		userService.save(user);
		User t_user = userService.findByName("username");
		team.setMaster(t_user);
		activity.setCreator(t_user);
	}

	@After
	public void tearDown() throws Exception {
		Activity t_activity = activityService.findByName("activity");
		if(t_activity != null){
			activityService.delete(t_activity);
		}
		Team t_team = teamService.findByName("team");
		if(t_team != null){
			teamService.delete(t_team);
		}
		User t_user = userService.findByName("username");
		if(t_user != null){
			userService.delete(t_user);
		}
	}

	@Test
	public final void testFindByName() {
		int id = activityService.save(activity);
		Activity t_activity = activityService.findByName("activity");
		assertEquals(id, t_activity.getId());
	}

	@Test
	public final void testFindByLocation() {
		int id = activityService.save(activity);
		List<Activity> list = activityService.findByLocation("location");
		assertEquals(1, list.size());
		assertEquals(id, list.get(0).getId());
	}

	@Test
	public final void testJoinActivity() {
		int id = teamService.save(team);
		Team t_team = teamService.getById(Team.class, id);
		id = activityService.save(activity);
		Activity t_activity = activityService.getById(Activity.class, id);
		Hibernate.initialize(t_activity.getTeams());
		activityService.joinActivity(t_team, t_activity);
		Iterator<Team> iTeam = t_activity.getTeams().iterator();
		if(iTeam.hasNext()){
			assertEquals("team", iTeam.next().getName());
		}
		Iterator<Activity> iActivity = t_team.getActivities().iterator();
		if(iActivity.hasNext()){
			assertEquals("activity",iActivity.next().getName());
		}
	}

}
