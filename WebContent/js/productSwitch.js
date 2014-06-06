//data:2010.5.7
//copyright deserved by hustic tencent club
var mobile = document.getElementById("mobile_works");
var web = document.getElementById("web_works");
var mobileDiv=mobile.getElementsByTagName("div");
var webDiv=web.getElementsByTagName("div");

var content = null;
var img = null;
var _top = 0;

var height = -169;
var width = 218;  //一次滚动的宽度
var upSpeed = 5;
var levelSpeed = 5;
var downSpeed = 10;

var  i=0;
var flag = 0;

function imgUp(func)
{

	if(_top > height)
	{
		_top-=5;
		for(var i=0;i<img.length;++i)
		{
			img[i].style.top =_top+"px";
		}
		setTimeout("imgUp("+func+")",upSpeed)
	}
	else
	{
		func();
	}
}
function leftOut()
{
	if(i <= width)
	{
		if(content.scrollLeft == 0 )
		{
		   if(flag==1)
		   { 
i=0;
flag=2;
imgDown();
return;
			}
			if(flag==0)
			{
flag =1;
			   content.scrollLeft = content.scrollWidth -width
			}
			if(flag==2)
		   { 
flag =1;
			   content.scrollLeft = content.scrollWidth -width
			}
		}
		i+=2;
		content.scrollLeft-=2;		
		setTimeout(leftOut,levelSpeed);
	}
	else
	{
		i=0;
		imgDown();
	}
	
}
function rightOut()
{
	if(i <= width)
	{
		if(content.scrollLeft >= content.scrollWidth-width-20)
		{
			content.scrollLeft=0;
			i=0;
			flag =0;
			imgDown();
			return;
		}
		i+=2;
		content.scrollLeft+=2;		
		setTimeout(rightOut,levelSpeed);
	}
	else
	{
		i=0;
		imgDown();
	}
	
}
function imgDown()
{
	if(_top < 0)
	{
		_top+=5;
		for(var i=0;i<img.length;++i)
		{
			img[i].style.top =_top+"px";
		}
		setTimeout(imgDown,downSpeed)
	}
}


var dnodes =0;

//手机部分
mobileDiv[0].onclick = function(){
		content = mobileDiv[1];
		img = content.getElementsByTagName("img");
		for(var i=0;i<img.length;++i)
		{
			img[i].style.top ="0px";
		}
		for(var i=0;i<content.getElementsByTagName("ul")[0].childNodes.length;++i)
		{
			if(content.getElementsByTagName("ul")[0].childNodes[i].nodeType==1)
dnodes++;
		}
		
		content.getElementsByTagName("ul")[0].style.width =  (dnodes*width+width)+"px";
		dnodes =0;
		imgUp(rightOut);
	};
mobileDiv[2].onclick = function(){
		content = mobileDiv[1];
		img = content.getElementsByTagName("img");
		for(var i=0;i<img.length;++i)
		{
			img[i].style.top ="0px";
		}
		for(var i=0;i<content.getElementsByTagName("ul")[0].childNodes.length;++i)
		{
			if(content.getElementsByTagName("ul")[0].childNodes[i].nodeType==1)
dnodes++;
		}
		
		content.getElementsByTagName("ul")[0].style.width =  (dnodes*width+width)+"px";
		dnodes =0;
		imgUp(leftOut);
		};
		
		
//网站部分
webDiv[0].onclick = function(){
		content = webDiv[1];
		img = content.getElementsByTagName("img");
		for(var i=0;i<img.length;++i)
		{
			img[i].style.top ="0px";
		}
		for(var i=0;i<content.getElementsByTagName("ul")[0].childNodes.length;++i)
		{
			if(content.getElementsByTagName("ul")[0].childNodes[i].nodeType==1)
dnodes++;
		}
		
		content.getElementsByTagName("ul")[0].style.width =  (dnodes*width+width)+"px";
		dnodes =0;
		imgUp(rightOut);
	};
webDiv[2].onclick = function(){
		content = webDiv[1];
		img = content.getElementsByTagName("img");
		for(var i=0;i<img.length;++i)
		{
			img[i].style.top ="0px";
		}
		for(var i=0;i<content.getElementsByTagName("ul")[0].childNodes.length;++i)
		{
			if(content.getElementsByTagName("ul")[0].childNodes[i].nodeType==1)
dnodes++;
		}
		
		content.getElementsByTagName("ul")[0].style.width =  (dnodes*width+width)+"px";
		dnodes =0;
		imgUp(leftOut);
		};

