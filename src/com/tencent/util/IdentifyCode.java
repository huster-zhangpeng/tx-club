package com.tencent.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import com.tencent.action.BaseAction;

/**
 * @Aauthor fancy2110
 * @version 1.0
 * create identifyCode image,and remember this session.
 * */
public class IdentifyCode extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ByteArrayInputStream inputStream;
	private String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private int width =150;
	private int height = 40;
	public String execute()throws Exception{
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random random =new Random();
		
		g.setColor(getRandColor(200,250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Time New Roman",Font.PLAIN,18));
		
		g.setColor(getRandColor(160,200));
		
		for(int i=0;i<100;i++){
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1= random.nextInt(width);
			int y1= random.nextInt(height);
			
			g.setColor(getRandColor(160,200));
			
			g.drawLine(x,y,x1,y1);
		}
		
		
		String code = "";
		for(int i=0;i<6;i++){
			int index =random.nextInt(chars.length());
			char rand =chars.charAt(index);
			code += rand;
		}
		
		for(int i=0;i<code.length();i++)
		{
			g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));   
			g.drawString(code.charAt(i)+"",i*13+16,16+i);   
		}
		session.put("identify", code);
		
		g.dispose();
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ImageOutputStream imageOut =ImageIO.createImageOutputStream(output);
		ImageIO.write(image, "JPEG", imageOut);
		imageOut.close();
		ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
		
		setInputStream(input);
		return SUCCESS;
	}
	private Color getRandColor(int fc, int bc) {
		Random random = new Random();   
		if(fc>255) fc=255;   
		if(bc>255) bc=255;   
		int r=fc+random.nextInt(bc-fc);   
		int g=fc+random.nextInt(bc-fc);   
		int b=fc+random.nextInt(bc-fc);   
		return new Color(r,g,b);   
	}
	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}
}
