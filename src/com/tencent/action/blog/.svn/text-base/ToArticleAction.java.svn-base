package com.tencent.action.blog;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ModelDriven;
import com.tencent.action.BaseAction;
import com.tencent.model.Blog;
import com.tencent.service.IBlogService;

public class ToArticleAction extends BaseAction implements ModelDriven<Blog> {
	public static Logger log = Logger.getLogger(ToArticleAction.class);
	private static final long serialVersionUID = 3976447407588001673L;
	private Blog blog;
	private int id;
	@Resource
	private IBlogService blogService;
	
	public void setBlogService(IBlogService blogService) {
		this.blogService = blogService;
	}
	
	public Blog getModel(){
		return this.blog;
	}
	
	public String execute() {
		this.blog = blogService.getById(Blog.class, this.id);
		if(this.blog != null)
			return SUCCESS;
		else {
			super.tip = "文章不存在或被移除！";
			return ERROR;
		}
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
