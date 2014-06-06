package com.tencent.action.user;

import javax.annotation.Resource;

import com.tencent.action.BaseAction;
import com.tencent.model.User;
import com.tencent.service.IUserService;

public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 3980018526866518273L;
	private String username;
	private String password;

	@Resource
	private IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String login() {
		User user = userService.findByName(username);
		if (user != null && password.equals(user.getPassword())) {
			tip = "欢迎你," + username;
			super.session.put("username", username);
			return SUCCESS;
		} else {
			tip = "用户名不存在 或密码错误!";
			return ERROR;
		}
	}

	public String logout() {
		session.clear();
		tip = null;
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
