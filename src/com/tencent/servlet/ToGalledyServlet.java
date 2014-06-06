package com.tencent.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tencent.service.IProjectService;
import com.tencent.util.Pager;

public class ToGalledyServlet extends HttpServlet {
	public static Logger log = Logger.getLogger(ToGalledyServlet.class);
	private static final long serialVersionUID = 331735636907892900L;

	@Resource
	private IProjectService projectService;

	public void setProjectService(IProjectService projectService) {
		this.projectService = projectService;
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String type = req.getParameter("type");
			int pageNo = Integer.parseInt(req.getParameter("pageNo"));

			PrintWriter out = resp.getWriter();
			StringBuffer content = new StringBuffer();

			resp.setContentType("text/xml");
			resp.setHeader("Cache-Control", "no-cache");
			content.append("<?xml version=\"1.0\"   encoding=\"UTF-8\" ?>");

			int rowCount = projectService
					.getRowCount("Project j left join j.team t where t.type="
							+ type);
			int pageSize = 12;
			int pageCount = (rowCount % pageSize == 0) ? (rowCount / pageSize)
					: (rowCount / pageSize + 1);
			int firstResult = (pageNo - 1) * pageSize;
			content.append("<pageCount>"+pageCount+"</pageCount>");
			content.append("<pageNo>"+pageNo+"</pageNo>");
			content.append("<firstResult>"+firstResult+"</firstResult>");
			@SuppressWarnings("unchecked")
			List<Object[]> result = (List<Object[]>) projectService
					.list("select b.image,b.name,b.startDate from Blog b where b.type=? order by b.publishDate desc",
							firstResult, 12, type);
			content.append("<member>");
			DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			for (int i = 0; i < result.size(); i++) {
				Object[] object = result.get(i);
				content.append("<image>"+(String)object[0]+"</iamge>");
				content.append("<name>"+(String)object[1]+"</name>");
				content.append("<date>"+format.format((Date)object[2])+"</date>");
			}
			content.append("</member><page>");
			Pager pager = new Pager();
			int[] arrayPage = pager.initArrayPage(pageNo, pageCount);
			for(int i:arrayPage){
				content.append("<param>"+i+"</param>");
			}
			content.append("</page>");
			out.print(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException
	{
		doGet(req, resp);
	}
}
