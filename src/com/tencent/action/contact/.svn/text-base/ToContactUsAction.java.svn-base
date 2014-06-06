package com.tencent.action.contact;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ModelDriven;
import com.tencent.action.BaseAction;
import com.tencent.model.ContactUs;
import com.tencent.service.IContactUsService;
import com.tencent.util.Pager;

public class ToContactUsAction extends BaseAction implements
		ModelDriven<ContactUs> {
	public static Logger log = Logger.getLogger(ToContactUsAction.class);
	private static final long serialVersionUID = -5430840552249153009L;
	private ContactUs contactUs = new ContactUs();
	private Pager pager;
	private int pageNo = 1;
	@Resource
	private IContactUsService contactUsService;

	public void setContactUsService(IContactUsService contactUsService) {
		this.contactUsService = contactUsService;
	}

	public ContactUs getModel() {
		return this.contactUs;
	}

	@SuppressWarnings("unchecked")
	public String show() {
		int rowCount = contactUsService.getRowCount("ContactUs");
		int pageSize = 6;
		int pageCount = (rowCount % pageSize == 0) ? (rowCount / pageSize)
				: (rowCount / pageSize + 1);
		if (pageNo <= pageCount || pageCount == 0) {
			int startIndex = (pageNo-1) * pageSize;
			int endIndex = rowCount - startIndex;
			List<ContactUs> result = (List<ContactUs>) contactUsService.list(
					"from ContactUs as c order by c.createDate desc", startIndex, pageSize);
			this.pager = new Pager(pageSize, pageNo, rowCount,
					pageCount, startIndex, endIndex, result);
			return SUCCESS;
		} else {
			tip = "对不起，你不能跳过指定超链接界面使页面越界";
			return ERROR;
		}
	}
	
	public String add(){
		contactUsService.save(contactUs);
		return "add";
	}

	public ContactUs getContactUs() {
		return contactUs;
	}

	public void setContactUs(ContactUs contactUs) {
		this.contactUs = contactUs;
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