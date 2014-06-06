package com.tencent.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.tencent.dao.IProjectDAO;
import com.tencent.model.Project;
import com.tencent.model.Team;
import com.tencent.model.User;
import com.tencent.service.IProjectService;

public class ProjectServiceImpl extends ServiceImpl<Project>
        implements IProjectService {
	public static Logger log = Logger.getLogger(ProjectServiceImpl.class);

    @Override
    public Project findByName(String name) {
        return ((IProjectDAO) dao).findByName(name);
    }

    @Override
    public Project newProject(User charger, User consignor, Team team) {
        Project project = new Project();
        project.setCharger(charger);
        project.setConsignor(consignor);
        project.setTeam(team);
        int id = super.dao.save(project);
        return super.dao.findById(Project.class, id);
    }
    
    @Resource(name="projectDao")
    public void setDao(IProjectDAO dao) {
        this.dao = dao;
    }
	
	public IProjectDAO getDao(){
		return (IProjectDAO) this.dao;
	}
}
