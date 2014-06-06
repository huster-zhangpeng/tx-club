package com.tencent.action.project;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.tencent.action.BaseAction;
import com.tencent.model.Project;
import com.tencent.service.IProjectService;
import com.tencent.util.Pager;

public class GalledyAction extends BaseAction {
	public static Logger log = Logger.getLogger(GalledyAction.class);
	private static final long serialVersionUID = -5595715941409259054L;

	private Pager pager;
	private int pageNo;
	private int type;
	@Resource
	private IProjectService projectService;

	public void setProjectService(IProjectService projectService) {
		this.projectService = projectService;
	}

	public String execute() {
		int rowCount = projectService.getRowCount("Project p where p.type=1");
		int pageSize = 12;
		int pageCount = (rowCount % pageSize == 0) ? (rowCount / pageSize)
				: (rowCount / pageSize + 1);
		if (pageNo <= pageCount || pageCount == 0) {
			int startIndex = (pageNo - 1) * pageSize;
			int endIndex = rowCount - startIndex;
			@SuppressWarnings("unchecked")
			List<Project> result = (List<Project>) projectService.list(
					"from Project as p where p.type=" + type
							+ " order by p.startDate desc", startIndex,
					pageSize);
			this.pager = new Pager(pageSize, pageNo, rowCount, pageCount,
					startIndex, endIndex, result);
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
