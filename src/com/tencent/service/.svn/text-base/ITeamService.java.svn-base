package com.tencent.service;

import com.tencent.model.Team;
import com.tencent.model.User;

public interface ITeamService extends IService<Team> {

    public String toStingMembers(Team team);  //not call TeamDAO

    public Team joinTeam(User user, Team team);

    public Team buildTeam(User creator); //creator create a new Team

	public Team findByName(String name);
}
