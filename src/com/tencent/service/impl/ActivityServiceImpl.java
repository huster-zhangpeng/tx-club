package com.tencent.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.tencent.dao.IActivityDAO;
import com.tencent.model.Activity;
import com.tencent.model.Team;
import com.tencent.service.IActivityService;

public class ActivityServiceImpl extends ServiceImpl<Activity> implements
		IActivityService {

	@Override
	public Activity findByName(String name) {
		return ((IActivityDAO) dao).findByName(name);
	}

	@Override
	public List<Activity> findByLocation(String location) {
		return ((IActivityDAO) dao).findByLocation(location);
	}

	@Override
	public void joinActivity(Team team, Activity activity) {
		activity.getTeams().add(team);
		dao.update(activity);
	}

	@Resource(name="activityDao")
	public void setDao(IActivityDAO dao) {
		this.dao = dao;
	}

	public IActivityDAO getDao() {
		return (IActivityDAO) this.dao;
	}

}
