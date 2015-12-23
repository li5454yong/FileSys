/**
 * 个人中心页面js
 */

//复选框全选
function selectAll() {
	var checklist = document.getElementsByName("selected");
	if (document.getElementById("controlAll").checked) {
		for (var i = 0; i < checklist.length; i++) {
			checklist[i].checked = 1;
		}
	} else {
		for (var j = 0; j < checklist.length; j++) {
			checklist[j].checked = 0;
		}
	}
}



var windowwidth;
var windowheight;
var checkmenu;
$(window).ready(function() {
	$('#myMenu').hide();
	$('#textbox').bind("contextmenu", function(e) {
		windowwidth = $(window).width();
		windowheight = $(window).height();
		checkmenu = 1;
		$('#mask').css({
			'height': windowheight-60,
			'width': windowwidth
		});
		$('#myMenu').show(0);
		$('#myMenu').css({
			'top': e.pageY-61 + 'px',
			'left': e.pageX-75 + 'px'
		});
		return false;
	});
	$('#mask').click(function() {
		$(this).height(0);
		$(this).width(0);
		$('#myMenu').hide(0);
		checkmenu = 0;
		return false;
	});
	$('#mask').bind("contextmenu", function() {
		$(this).height(0);
		$(this).width(0);
		$('#myMenu').hide(0);
		checkmenu = 0;
		return false;
	});
	$(window).resize(function() {
		if (checkmenu == 1) {
			windowwidth = $(window).width();
			windowheight = $(window).height();
			$('#mask').css({
				'height': windowheight,
				'width': windowwidth,
			});
		}
	});
	
	
	$(".textbox-1").mousedown(function(e){
		var checklist = $("input[name=selected]");
		if(e.button == 2){
			alert("2");
		}
		alert($(this).attr("fileId"));
		for (var i = 0; i < checklist.length; i++) {
			alert(checklist[i].checked == 1);
		}
	});
});

function hideMenu(){
	$('#myMenu').hide();
	
}


function fromatDate(date){
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	var hour = date.getHours();
	var minutes = date.getMinutes();
	var seconds = date.getSeconds();
	return year+"-"+month+"-"+day+" "+hour+":"+minutes+":"+seconds;
}