<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/reset.css" type="text/css" rel="stylesheet" media="screen"/>
<link href="css/share.css" type="text/css" rel="stylesheet" media="screen"/>
<link href="css/index.css" type="text/css" rel="stylesheet" media="screen"/>
<title>华中科技大学腾讯创新俱乐部首页</title>
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
      <embed width="880" height="330" align="middle" type="application/x-shockwave-flash" salign="" allowscriptaccess="sameDomain" allowfullscreen="false" menu="true" name="picroll" bgcolor="#ffffff" devicefont="false" wmode="transparent" scale="showall" loop="true" play="true" pluginspage="http://www.adobe.com/go/getflashplayer_cn" quality="high" src="flash/picroll.swf"/> 
    </div>
    <!-- end of content1 -->
    <div id="content2">
      <div id="patch1">
        <div class="border_t"> </div>
        <div class="border_l"> </div>
        <div class="border_r"> </div>
        <div class="ban1"><img src="images/properties.jpg"/>
          <p>华中科技大学腾讯创新俱乐部是由华中科技大学和腾讯科技（深圳）有限公司合作 创办的以技术为核心的创新实践型高校学生社团，由华中科技大学计算机学院直接领导。</p>
        </div>
        <!-- end of ban1 -->
        <div class="ban1"><img src="images/purpose.jpg"/>
          <p>以培养技术扎实、视野宽阔、具有良好团队合作精神的人才为目标，以新颖的创意和专业的技术创造价值、服务社会。</p>
        </div>
        <!-- end of ban1 -->
        <div class="ban2"><img src="images/welcome.jpg"/>
          <p>我们热忱的欢迎你的加入，加入俱乐部这个大家庭。我们是有着同样梦想能与你一同并肩奋战的团队。</p>
        </div>
        <!-- end of ban2 -->
      </div>
      <!-- end of patch1 -->
    </div>
    <!-- end of content2 -->
    <div id="content3">
      <div id="patch_a"> <img  class="b_lift" src="images/news_left.jpg"/> <img  class="b_right" src="images/b_right2.jpg"/><img  class="b_right" src="images/news.jpg"/>
      <a href="moreinfo?type=1"><h3>more</h3></a>
        <div id="boxlist">
          <ol>
            <!-- 最新动态 -->
          	<s:iterator value="listLatest" id="object">
            		<li><a href="article"><span><s:date name="#object[1]" format="dd-MM-yyyy"/></span><s:property value="#object[0]"/></a></li>
            	</s:iterator>
          </ol>
          <!--将需要有浮动的span放到左边，可以解决ie下span换行-->
        </div> 
      </div>
      <!-- end of patch2 -->
      <div id="patch_b"> <img  class="b_lift" src="images/activities_left.jpg"/> <img  class="b_right" src="images/b_right2.jpg"/><img  class="b_right" src="images/activities.jpg"/>
      	<a href="moreinfo?type=0"><h3>more</h3></a>
        <div id="boxlist">
          <ol>
                        <!-- 精彩活动 -->
            <s:iterator value="listExciting" id="object">
            	<li><a href="airticle"><span><s:date name="#object[1]" format="dd-MM-yyyy"/></span><s:property value="#object[0]"/></a></li>
            </s:iterator>
          </ol>
        </div>
      </div>
      <!-- end of patch2 -->
    </div>
    <!-- end of container3 -->
    <div id="content4">
      <div id="patch3">
        <div class="ban3"> <a href="department"><img  class="ban3_header" src="images/members.jpg"/></a>
          <div id="boxtest">
            <s:iterator value="listUsers">
	        <a href="department"><img src="images/show1.jpg"/></a>             
            <div class="show_mem">
              <h4><s:property value="username"/></h4>
              <p><s:property value="description"/><span><a href="#">[详细]</a></span></p>
            </div> 
            </s:iterator>    
            <a href="#"><img id="showpic" src="images/show.jpg"/></a>
            <div id="show2"> <a href="#"><img src="images/works/web/01.jpg" width="200px" height="140px"/></a></div>
          </div>
          <!-- end of boxtest3 -->
        </div>
        <!-- end of ban -->
      </div>
      <!-- end of patch3 -->
    </div>
    <!-- end of content4 -->
    <div id="content5">
      <div id="show3"> <span>相关链接：</span> <a href="#"><img src="images/link1.jpg"/></a> <a href="#"><img src="images/link2.jpg"/></a> <a href="#"><img src="images/link3.jpg"/></a> </div>
    </div>
    <div id="footer"><span>copyright © 2009-2010 huazhongkejidaxue.tengxunjulebu.cn.all rights reserved support by gumeipost.com</span	> </div>
  </div>
  <!-- end of middle -->
</div>
</body>
</html>
