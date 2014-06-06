package com.tencent.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tencent.dao.ITaskDAO;
import com.tencent.model.Task;
import com.tencent.model.User;
import com.tencent.service.ITaskService;

public class TaskServiceImpl extends ServiceImpl<Task> implements ITaskService {

    @Override
    public Task findByContent(String content) {
        return ((ITaskDAO) dao).findByContent(content);
    }

    @Override
    public Task buildTask(User user) {
        Task task = new Task();
        task.setBuilder(user);
        int id = super.dao.save(task);
        return super.dao.findById(Task.class, id);
    }

    @Override
    public void doneTask(Task task) {
        
    }
    
    public void setDao(ITaskDAO dao) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.dao = (ITaskDAO) ctx.getBean("taskDao");
    }
	
	public ITaskDAO getDao(){
		return (ITaskDAO) this.dao;
	}
}
