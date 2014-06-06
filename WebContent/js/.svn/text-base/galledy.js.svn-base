$(document).ready(function() {
	prePage();
	nextPage();
});
function prePage() {
	var url = "/";
	$("#left_arrow").onlick(function() {
		$.ajax({
			type : 'get',
			url : url,
			data : 'id=' + $("#left_arrow").attr("class"),
			success : function(data) {
				var item = eval("(" + data + ")");
				$("#project_title").html(data.title);
				$("#project_img").attr("src", data.img);
				$("#project_member").html(data.member);
				$("#project_difficulty").html("");
				for ( var i = 0; i < data.difficulty; i++)
					$("#project_difficulty").append("*");
				$("#project_describe").html(data.describe);
				$("#project_source").html(data.source);
				$("#right_arrow").attr("class", data.id + 1);
				$("#left_arrow").attr("class", data.id - 1);
			},
			error : function() {
			}
		});
	});
}

function nextPage() {
	var url = "";
	$("#rigth_arrow").onclick(function() {
		$.ajax({
			type : 'get',
			url : url,
			data : 'id=' + $("#right_arrow").attr("class"),
			before : function() {
			},
			success : function(data) {
				var item = eval("(" + data + ")");
				$("#project_title").html(data.title);
				$("#project_img").attr("src", data.img);
				$("#project_member").html(data.member);
				$("#project_difficulty").html("");
				for ( var i = 0; i < data.difficulty; i++)
					$("#project_difficulty").append("*");
				$("#project_describe").html(data.describe);
				$("#project_source").html(data.source);
				$("#right_arrow").attr("class", data.id + 1);
				$("#left_arrow").attr("class", data.id - 1);
			},
			error : function() {
			}
		});
	});
};
function nextPage() {
	var url = "";
	$("#rigth_arrow").onclick(function() {
		$.ajax({
			type : 'get',
			url : url,
			data : 'index=' + $("#right_arrow").attr("class"),
			before : function() {

			},
			success : function(data) {
				var item = eval("(" + data + ")");
				$("#right_arrow").attr("class", data.index + 1);
				$("#left_arrow").attr("class", data.index - 1);
			},
			error : function() {
			}
		});
	});
}
