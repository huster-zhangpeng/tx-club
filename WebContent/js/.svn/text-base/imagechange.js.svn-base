
function getNames(obj,name,tag)
{
	var getlist = getid(obj).getElementsByTagName(tag);	//获取obj对象的标签名，如div
	var retlist = new Array();
	for(i=0;i<getlist.length;++i){
		if(getlist[i].getAttribute("name") == name){		//将各name属性匹配此处属性值的标签赋给新建数组retlist并返回
			retlist[retlist.length] = getlist[i];
		}
	}
	return retlist;
}

function dismode(obj,num,tag,name,class1,class2)			//转换显示模式，通过控制类名的改变结合css来实现图片和文字的切换
{
	var dislist = getNames(obj,name,tag);
	for(i = 0;i<dislist.length;++i){
		if(i == num){
			dislist[i].className = class1;					//注意className的写法，大小写区分明确
		}
		else{
			dislist[i].className = class2;
		}
	}
}

function play(num)
{
	var f = getid('focus');
	var c = getid('caption');
	var i = getid('focimg');								
	try{												//try…catch函数处理错误，因firefox不能识别filters滤镜，故而在catch里另外处理。
		with(i)
		{
			filters[0].Apply();							//Apply用另一个对象替换当前对象
			dismode(i,num,"div","f","dis","undis");		//调用dismode对三个div配合css实现转换效果
			dismode(f,num,"div","f","","f1");
			dismode(c,num,"div","f","dis","undis");
			filters[0].play();							//运行滤镜
		}
	}
	catch(e){
		dismode(i,num,"div","f","dis","undis");			//发生错误时转这里处理，即没有滤镜效果的直接切换
		dismode(f,num,"div","f","","f1");
		dismode(c,num,"div","f","dis","undis");
	}
}

var autoStart = 0;
var n = 0;	
function clearAuto() {clearInterval(autoStart);};
function setAuto(){autoStart=setInterval("auto(n)", 3000)}
function auto()	{
	n++  ;
	if(n>4){
		n = 0;
		clearAuto();
		setAuto();
	 }
	play(n);
}

setAuto();
