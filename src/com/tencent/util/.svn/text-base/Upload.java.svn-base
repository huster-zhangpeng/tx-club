package com.tencent.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

/*
 * upload picture
 */
public class Upload {
	public static Logger log = Logger.getLogger(Upload.class);
	private static final long serialVersionUID = 5160317652408817053L;

	private File picture;
	private String uploadPath;
	private String pictureFileName;
	
	public Upload(File picture, String uploadPath, String pictureFileName) {
		this.picture = picture;
		this.uploadPath = uploadPath;
		this.pictureFileName = pictureFileName;
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public String getPictureFileName() {
		return pictureFileName;
	}

	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

	public void upload() throws Exception {
		/*File saved = new File(ServletActionContext.getServletContext()
				.getRealPath(uploadPath), pictureFileName);  
		OutputStream outs = null;
		try{
			ins = new FileInputStream(picture);
			outs = new FileOutputStream(saved);
			byte[] b = new byte[1024];
			int len = 0;
			while((len = ins.read(b)) != -1) {
				outs.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(outs != null)outs.close();
			if(ins != null)ins.close();
		}*/
	}
}
