$(document).ready(function(){
	loadCodeImage();
	buttonAction();
	checkInfo();
});

function loadCodeImage(){
	var rand = new Date().getTime();
	$("#code img").attr("src","/club/resource/load?rand="+rand);
}

function buttonAction(){
	$("input.button").click(function(){
		if($("#email_info").attr("html"))
		var areement_flag = $("#agreement").attr("value");
		alert(flag);
	});
}

function checkInfo(){
	$("#email").blur(function(){
		var flag = $("#email_flag").attr("value");
		var email = $("#email").attr("value");
		if(flag=="false"){
			$.ajax({
				url:"/club/",
				
			});
		}
	});
}