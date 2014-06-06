package com.tencent.action.index;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.tencent.action.BaseAction;
import com.tencent.model.User;
import com.tencent.service.IBlogService;
import com.tencent.service.IUserService;

public class ToIndexAction extends BaseAction {
	private static final long serialVersionUID = -7117568218063539690L;
	public static Logger log = Logger.getLogger(ToIndexAction.class);
	private List<Object[]> listLatest;
	private List<Object[]> listExciting;
	private List<User> listUsers;

	@Resource
	private IBlogService blogService;
	@Resource
	private IUserService userService;

	@SuppressWarnings("unchecked")
	public String execute() {
		listLatest = (List<Object[]>) blogService
				.list("select b.title, b.publishDate, b.id from Blog as b order by b.publishDate desc",1,5);
		listExciting = (List<Object[]>) blogService
				.list("select b.title, b.publishDate, b.id from Blog as b order by b.count desc",1,5);
		listUsers = (List<User>) userService.list("from User",1,2);
		if(listLatest.isEmpty()){
			Object[] e = new Object[2];
			e[0] = (Object)"暂无动态！";
			Timestamp time = new Timestamp(System.currentTimeMillis());
			e[1] = (Object)time;
			listLatest.add(e);
		}
		if(listExciting.isEmpty()){
			Object[] e = new Object[2];
			e[0] = (Object)"暂无精彩活动！";
			Timestamp date = new Timestamp(System.currentTimeMillis());
			e[1] = date;
			listExciting.add(e);
		}
		return SUCCESS;
	}

	public List<Object[]> getListLatest() {
		return listLatest;
	}

	public void setListLatest(List<Object[]> listLatest) {
		this.listLatest = listLatest;
	}

	public List<Object[]> getListExciting() {
		return listExciting;
	}

	public void setListExciting(List<Object[]> listExciting) {
		this.listExciting = listExciting;
	}

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}

	public IBlogService getBlogService() {
		return this.blogService;
	}

	@Resource
	public void setBlogService(IBlogService blogService) {
		this.blogService = blogService;
	}

	public IUserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
