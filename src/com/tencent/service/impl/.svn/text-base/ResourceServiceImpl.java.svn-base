package com.tencent.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tencent.dao.IActivityDAO;
import com.tencent.dao.IProjectDAO;
import com.tencent.dao.IResourceDAO;
import com.tencent.dao.impl.ActivityDAOImpl;
import com.tencent.dao.impl.ProjectDAOImpl;
import com.tencent.dao.impl.UserDAOImpl;
import com.tencent.model.Activity;
import com.tencent.model.Project;
import com.tencent.model.User;
import com.tencent.service.IResourceService;

public class ResourceServiceImpl extends ServiceImpl<com.tencent.model.Resource> implements IResourceService {
	public static Logger log = Logger.getLogger(ResourceServiceImpl.class);

    @Override
    public com.tencent.model.Resource implementResource(Activity activity, String title) {
    	com.tencent.model.Resource resource = ((IResourceDAO) dao).findByTitle(title);
        super.dao.update(resource);
        activity.getResoures().add(resource);
        ActivityDAOImpl a = new ActivityDAOImpl();
        a.update(activity);
        return resource;
    }

    @Override
    public com.tencent.model.Resource borrowBooks(User user, String title) {
    	com.tencent.model.Resource resource = ((IResourceDAO) dao).findByTitle(title);
        super.dao.update(resource);
        user.getResources().add(resource);
        UserDAOImpl u = new UserDAOImpl();
        u.update(user);
        return resource;
    }

    @Override
    public com.tencent.model.Resource implementResource(Project project, String title) {
    	com.tencent.model.Resource resource = ((IResourceDAO) dao).findByTitle(title);
        super.dao.update(resource);
        project.getResources().add(resource);
        ProjectDAOImpl p = new ProjectDAOImpl();
        p.update(project);
        return resource;
    }

    @Override
    public void returnResource(User user, com.tencent.model.Resource resource) {
        resource.setStatus(0);
        super.dao.update(resource);
        user.getResources().remove(resource);
        UserDAOImpl u = new UserDAOImpl();
        u.update(user);
    }

    @Override
    public void returnResource(Project project, com.tencent.model.Resource resource) {
        resource.setStatus(0);
        super.dao.update(resource);
        project.getResources().remove(resource);
        IProjectDAO p = new ProjectDAOImpl();
        p.update(project);
    }

    @Override
    public void returnResource(Activity activity, com.tencent.model.Resource resource) {
        resource.setStatus(0);
        super.dao.update(resource);
        activity.getResoures().remove(resource);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext");
        IActivityDAO a = (IActivityDAO) ctx.getBean("activityDao");
        a.update(activity);
    }

    @Override
    public com.tencent.model.Resource findBytitle(String title) {
        return ((IResourceDAO) dao).findByTitle(title);
    }
 
    @Resource(name="resourceDao")
    public void setDao(IResourceDAO dao) {
        this.dao = dao;
    }
	
	public IResourceDAO getDao(){
		return (IResourceDAO) this.dao;
	}
}
