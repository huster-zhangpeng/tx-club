package com.tencent.action.project;

import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

import com.tencent.action.BaseAction;
import com.tencent.model.Project;
import com.tencent.model.User;
import com.tencent.service.IProjectService;

public class GalledyExpAction extends BaseAction{
	public static Logger log = Logger.getLogger(GalledyExpAction.class);
	private static final long serialVersionUID = 7178523184742974563L;
	private int index;
	private Map<String, String> result;
	private IProjectService projectService;
	
	public String execute()
	{
		Project project = projectService.getIndex("Project", index);
		if(project == null){
			return ERROR;
		}		
		Iterator<User> members = project.getTeam().getMembers().iterator();
		String memberName = null;
		if(members.hasNext())
			memberName = members.next().getUsername();
		while(members.hasNext()){
			memberName = memberName + "," + members.next().getUsername();
		}
		result.put("title",	 project.getName());
		result.put("curIndex", ((Integer)index).toString());
		result.put("members", memberName);
		result.put("defficulty", project.getDefficulty().toString());
		result.put("description", project.getDescription());
		result.put("consigner", project.getConsignor().getUsername());
		return SUCCESS;
	}

	public Map<String, String> getResult() {
		return result;
	}

	public void setResult(Map<String, String> result) {
		this.result = result;
	}
}
