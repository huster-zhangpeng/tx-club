package com.tencent.action.user;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.tencent.action.BaseAction;
import com.tencent.model.User;
import com.tencent.service.IUserService;
import com.tencent.util.Pager;

public class DepartmentAction extends BaseAction {
	public static Logger log = Logger.getLogger(DepartmentAction.class);
	private static final long serialVersionUID = 4363955412635589076L;
	private IUserService userService;
	private Pager pager = null;
	private int pageNo = 1;

	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@SuppressWarnings("unchecked")
	public String execute() {
		int rowCount = userService.getRowCount("User");
		int pageSize = 10;
		int pageCount = (rowCount % pageSize == 0) ? (rowCount / pageSize)
				: (rowCount / pageSize + 1);
		if (pageNo <= pageCount || pageCount == 0) {
			int startIndex = (pageNo-1) * pageSize;
			int endIndex = pageNo * pageSize - 1;
			List<User> result = (List<User>) userService.list(
					"from User", startIndex, pageSize);
			this.pager = new Pager(pageSize, pageNo, rowCount,
					pageCount, startIndex, endIndex, result);
			return SUCCESS;
		} else {
			tip = "对不起，你不能跳过指定超链接界面使页面越界";
			return ERROR;
		}
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}
