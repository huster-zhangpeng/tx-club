package com.tencent.action.team;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ModelDriven;
import com.tencent.action.BaseAction;
import com.tencent.model.Team;
import com.tencent.model.User;
import com.tencent.service.ITeamService;
import com.tencent.service.IUserService;

public class CreateTeamAction extends BaseAction implements ModelDriven<Team> {

	private static final long serialVersionUID = 8445430037395791293L;
	private Team team = new Team();
	@Resource
	private ITeamService teamService;
	@Resource
	private IUserService userService;

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Team getModel() {
		return this.team;
	}
	
	public String execute() {
		Team tempTeam = teamService.findByName(getModel().getName());
		if(tempTeam != null){
			tip = "小组已经存在，请重新创建！";
			return ERROR;
		}
		userService.save(new User("name", "password", "M", "test@qq.com",
	            "935789181", "13871398643", "CS", "大二", 0, "description", 1, 1));
		team.setMaster(userService.findByName("name"));
		teamService.save(team);
		tip = "恭喜你，小组建立成功!";
		/*tip = "teamName : " + team.getName() + "\n" +
				"teamType : " + team.getType() + "\n" +
				"teamDescription :" + team.getDescription() + "\n" +
				"teamLevel :" + team.getLevel() + "\n" + 
				"teamCreate_Date :" + team.getCreateDate() + 
				"teamMaster :" + team.getMaster().getId();*/
		return SUCCESS;
	}
}
