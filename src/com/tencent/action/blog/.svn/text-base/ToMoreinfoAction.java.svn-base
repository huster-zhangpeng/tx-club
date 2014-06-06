package com.tencent.action.blog;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.tencent.action.BaseAction;
import com.tencent.service.IBlogService;
import com.tencent.util.Pager;

public class ToMoreinfoAction extends BaseAction {
	public static Logger log = Logger.getLogger(ToMoreinfoAction.class);
	private static final long serialVersionUID = 5570080503494050679L;

	private Pager pager;
	private int pageNo = 1;
	/**
	 * if type == 1 return latest news if type == 0 return exciting news
	 */
	private int type;
	@Resource
	private IBlogService blogService;

	public void setBlogService(IBlogService blogService) {
		this.blogService = blogService;
	}

	@SuppressWarnings("unchecked")
	public String execute() {
		int rowCount = blogService.getRowCount("Blog");
		int pageSize = 17;
		int pageCount = (rowCount % pageSize == 0) ? (rowCount / pageSize)
				: (rowCount / pageSize + 1);
		if (pageNo <= pageCount || pageCount == 0) {
			int startIndex = (pageNo - 1) * pageSize;
			int endIndex = rowCount - startIndex;
			List<Object[]> result = null;
			if (this.type == 1)
				result = (List<Object[]>) blogService
						.list("select b.id, b.title, b.publishDate from Blog as b order by b.publishDate desc",
								startIndex, pageSize);
			if (this.type == 0)
				result = (List<Object[]>) blogService
						.list("select b.id, b.title, b.publishDate from Blog as b order by b.count desc",
								startIndex, pageSize);
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
