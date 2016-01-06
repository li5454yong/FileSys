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
$(window).ready(function() { //鼠标右键菜单
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
	
	/**
	 * 为 textbox-1添加鼠标点击监听事件
	 */
	$(".textbox-1").mousedown(function(e){
		
		if(e.button == 2){
			var checked = $(this).find("input[name=selected]").prop("checked");
			if(checked){
				$(this).find("input[name=selected]").prop("checked",false);
			}else{
				$(this).find("input[name=selected]").prop("checked",true);
			}
		}
		
	});
	
	/**
	 * 监听选择框选中事件，根据选中数量改变工具栏
	 */
	$("input[name=selected]").change(function(e){
		var list = $(".textbox-1").find("input[name=selected]");
		var length = 0;
		for(var i=0;i<list.length;i++){
			var c = list[i];
			isChecked = $(c).prop("checked");
			if(isChecked){
				length++;
			}
		}
		if(length>0){
			$("#toolBar").show(2);
			$("#selectedNum").text(length);
			$("#titleBar").hide(2);
		}else{
			$("#toolBar").hide(2);
			$("#titleBar").show(2);
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