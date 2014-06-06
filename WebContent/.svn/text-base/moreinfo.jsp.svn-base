<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>华中科技大学腾讯创新俱乐部——最新动态</title>
<link href="css/reset.css" type="text/css" rel="stylesheet" media="screen"/>
<link href="css/share.css" type="text/css" rel="stylesheet" media="screen"/>
<link href="css/news.css" type="text/css" rel="stylesheet" media="screen"/>
</head>

<body>
   <div id="container">
      <div id="left"></div>
      <div id="right"> </div>
      <div id="middle">
   		<div id="header">
          <div id="tabs">
                <div class="nav">
                  <ul>
                    <li class="title_home"><a href="index"></a></li>
                    <li class="title_view"><a href="summary.html"></a></li>
                    <li class="title_galledy"><a href="galledy"></a></li>
                    <li class="title_department"><a href="department"></a></li>
                    <li class="title_contact"><a href="showContact"></a></li>
                  </ul>
                </div>
                <!-- end of nav -->
          </div>
          <!-- end of tabs -->
          <div id="illustrat"></div>
          </div>
            <!-- end of header -->
        <div id="content1">       	
            <a href="#"><img id="changebj" src="images/changebj.png"/></a>
            <img id="bj" src="images/news_acts/bj.jpg"/>
        </div><!-- end of content1 --> 
        <div id="content2">
                <div id="patch1">
                	<s:if test="type==1">
                	<img class="title_pic" src="images/news_acts/news.jpg"/>
                	</s:if>
                	<s:else>
                	<img class="title_pic" src="images/news_acts/acts.jpg"/>
                	</s:else>
                    <img  class="b_left" src="images/department/border_department.jpg"/>
                    <img  class="b_right" src="images/department/border_department.jpg"/>             
               	    <a href="index"><span class="link">返回首页</span></a>
               	    <s:if test="type == 1">
               	    <a href="moreinfo?type=0"><span class="link">精彩活动</span></a>
               	    </s:if>
               	    <s:else>
               	    <a href="moreinfo?type=1"><span class="link">最新动态</span></a>
					</s:else>
                    <div id="boxlist">
                      <ol>
                        <s:iterator value="pager.resultList" id="object">
                        <li>
                        	<s:url id="url" >
                        		<s:param name="id" value="#object[0]" />
							</s:url>
                        	<a href="%{url}">
								<span><s:date name="#object[2]" format="dd-MM-yyyy" /></span>
								<s:property value="#object[1]"/>
							</a>
						</li>
                        </s:iterator>
                      </ol>
                      <!--将需要有浮动的span放到左边，可以解决ie下span换行-->
                    </div> 
                    <div id="menu1">
                	<ul>		                    	
                    <li class="back"><span>
                    	<s:if test="pageNo > 1">                    		       
                    		<s:url id="url_pre" value="moreinfo">
                    			<s:param name="pageNo" value="pageNo-1"/>
                    			<s:param name="type" value="type"/>
                    		</s:url>
                    		<s:a href="%{url_pre}"/>                   		
                    	</s:if>
                    </span></li>                	
                    <s:iterator value="pager.arrayPage" id="key">                      	
                        <s:url id="url" value="moreinfo">
                        	<s:param name="pageNo" value="key"/>
                        	<s:param name="type" value="type"/>
                        </s:url>
                        <s:if test="pageNo == key ">
                        <li class="block" style="background:yellow;">
                        	<s:a href="%{url}">
                        		<s:property/>
                        	</s:a>
                       	 </li>
                       	 </s:if>
                       	 <s:else>
                       	 <li class="block">
                        	<s:a href="%{url}">
                        		<s:property/>
                        	</s:a>
                       	 </li>
                       	 </s:else>
                    </s:iterator>
                 	<li class="forward"><span>
                        <s:if test="pageNo < pager.pageCount">
                        	<s:url id="url_forword" value="moreinfo">
                        		<s:param name="pageNo" value="pageNo + 1"/>
                        		<s:param name="type" value="type"/>
                        	</s:url>
                        	<s:a href="%{url_forword}"></s:a>
                        </s:if>
                    </span></li>
                </ul>   		
        	</div> 
                </div><!-- end of patch1 -->                               
        </div><!-- end of content2 -->
        <div id="footer"><span>copyright © 2009-2010 huazhongkejidaxue.tengxunjulebu.cn.all rights reserved support by gumeipost.com</span	> </div>
  </div>
  <!-- end of middle -->
</div>
</body>
</html>
