package com.tencent.dao;

import com.tencent.model.Team;

public interface ITeamDAO extends IDao<Team> {

    public Team findByName(String name);
}
