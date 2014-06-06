package com.tencent.service;

import java.util.List;

import com.tencent.model.Activity;
import com.tencent.model.Team;

public interface IActivityService extends IService<Activity> {

	public void joinActivity(Team team, Activity activity);

	// if one want to join an activity, he must join a team first

	public Activity findByName(String name);

	public List<Activity> findByLocation(String location);
}
