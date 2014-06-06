package com.tencent.action.user;

import java.io.File;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ModelDriven;
import com.tencent.action.BaseAction;
import com.tencent.model.User;
import com.tencent.service.IUserService;
import com.tencent.util.Upload;

public class RegisterAction extends BaseAction implements ModelDriven<User> {

	private static final long serialVersionUID = 2558952893336630874L;
	private User user = new User();
	private File picture;
	@Resource
	private IUserService userService;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getModel() {
		return this.user;
	}
	
	public String execute() {
		User tUser = userService.findByName(getModel().getUsername());
		if(tUser != null){
			tip = "用户名已经存在，请重新注册！";
			return ERROR;
		}
		int id = userService.save(user);
		Upload upload = new Upload(picture, "userHead", ((Integer)id).toString());
		try {
			upload.upload();
		} catch (Exception e) {
			e.printStackTrace();
			tip = "上传失败!";
			return ERROR;
		}
		user.setMiniPhoto("/userHead/"+((Integer)id).toString()+".jpg");
		userService.modify(user);
		tip = "恭喜你，注册成功!";
		return SUCCESS;
	}
	
	public String checkEmail(){
		
		return SUCCESS;
	}
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
}
