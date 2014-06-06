package com.tencent.action.project;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ModelDriven;
import com.tencent.action.BaseAction;
import com.tencent.model.Project;
import com.tencent.model.User;
import com.tencent.service.IProjectService;
import com.tencent.service.IUserService;

public class CreateProjectAction extends BaseAction implements ModelDriven<Project> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7704623289323828061L;
	
	private Project project = new Project();
	@Resource private IProjectService projectService;
	@Resource private IUserService userService;
 
	public Project getModel() {
		return project;
	}
	
	public String execute() {
		Project tempProject = projectService.findByName(project.getName());
		if(tempProject != null){
			tip = "项目已经存在，请重新创建！";
			return ERROR;
		}
		userService.save(new User("name", "password", "M", "test@qq.com",
	            "935789181", "13871398643", "CS", "大二", 0, "description", 1, 1));
		project.setCharger(userService.findByName("name"));
		project.setConsignor(userService.findByName("name"));
		projectService.save(project);
		tip = "恭喜你，项目建立成功!";
		/*tip = "projectName : " + project.getName() + "\n" +
		"projectType : " + project.getType() + "\n" +
		"projectDescription :" + project.getDescription() + "\n" +
		"projectState :" + project.getState() + "\n" + 
		"projectStartDate :" + project.getStartDate();*/
		return SUCCESS;
	}

}
