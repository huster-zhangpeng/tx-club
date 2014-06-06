package com.tencent.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.tencent.dao.ITeamDAO;
import com.tencent.model.Team;

public class TeamDAOImpl extends DAOImpl<Team> implements ITeamDAO {
	public static Logger log = Logger.getLogger(TeamDAOImpl.class);

    @SuppressWarnings("unchecked")
    @Override
    public Team findByName(String name) {
        List<Team> list = this.getHibernateTemplate().find("from Team t where t.name=?", name);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
