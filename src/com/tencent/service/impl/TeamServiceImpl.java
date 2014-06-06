package com.tencent.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import com.tencent.dao.ITeamDAO;
import com.tencent.model.Team;
import com.tencent.model.User;
import com.tencent.service.ITeamService;

public class TeamServiceImpl extends ServiceImpl<Team> implements ITeamService {

    @Override
    public Team findByName(String name) {
        return ((ITeamDAO) dao).findByName(name);
    }

    @Override
    public String toStingMembers(Team team) {
        Set<User> members = team.getMembers();
        String membernames = null;
        for (User u : members) {
            membernames = membernames + u.getUsername();
        }
        return membernames;
    }

    @Override
    public Team joinTeam(User user, Team team) {
        user.getTeams().add(team);
        team.getMembers().add(user);
        super.dao.update(team);
        return team;
    }

    @Override
    public Team buildTeam(User creator) {//creator must be master
        Team team = new Team();
        team.setMaster(creator);
        int id = super.dao.save(team);
        return super.dao.findById(Team.class, id);
    }

    @Resource(name="teamDao")
    public void setDao(ITeamDAO dao) {
        this.dao = dao;
    }
	
	public ITeamDAO getDao(){
		return (ITeamDAO) this.dao;
	}
}
