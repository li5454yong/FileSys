<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/page/tag/tag.jsp" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>云数据</title>
		<meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no,width=device-width,height=device-height">
		<link rel="stylesheet" href="${ctx }/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${ctx }/css/style.css" />
		<!--标签云js引入-->
		<script type="text/javascript" src="${ctx }/js/script.js"></script>
		<!--标签云结束-->
		<script type="text/javascript" src="${ctx }/js/jquery.min.js"></script>

	</head>

	<body>
		<div class="grzx-head">
			<div class="grzx-head-main">
				<div class="logo">
					<img src="${ctx }/img/logo.png" />
				</div>
				<div class="grzx-head-menu">
					<span class="grzx-head-menu1 active">主页</span>
					<span class="grzx-head-menu1">收藏</span>
					<span class="grzx-head-menu1">分享</span>
					<span class="grzx-head-menu1">上传</span>
				</div>
			</div>
		</div>
		<!--页面左侧-->
		<div class="grzx-main">
			<div class="grzx-left">
				<div class="grzx-left-main">
					<!--文件存档-->
					<div class="grzx-left-main-1">
						<div class="grzx-left-main-1-head">
							文件存档
						</div>
						<div class="grzx-left-main-1-main">
							<div>2015年12月<span>(10)</span></div>
							<div>2015年11月<span>(10)</span></div>
							<div>2015年10月<span>(10)</span></div>
							<div>2015年09月<span>(10)</span></div>
							<div>2015年08月<span>(10)</span></div>
							<div>2015年07月<span>(10)</span></div>
							<div>2015年06月<span>(10)</span></div>
							<div>2015年05月<span>(10)</span></div>
						</div>
					</div>
					<!--文件分类   标签云-->
					<div class="grzx-left-main-1">
						<div class="grzx-left-main-1-head">
							文件分类
						</div>
						<div class="grzx-left-main-1-main">
							<div id="tagbox">
								<a href="#">美女</a>
								<a class="red" href="#">写真</a>
								<a href="#">贴图</a>
								<a href="#">灌水</a>
								<a class="blue" href="#">大片</a>
								<a href="#">小说</a>
								<a class="red" href="#">欧美</a>
								<a class="yellow" href="#">日韩</a>
								<a href="#">诱人</a>
								<a class="red" href="#">搞笑</a>
								<a href="#">性感</a>
								<a class="blue" href="#">壁纸</a>
								<a class="blue" href="#">泳装</a>
								<a class="red" href="#">言情</a>
								<a class="yellow" href="#">浪漫</a>
								<a class="yellow" href="#">耽美</a>
								<a class="blue" href="#">爆笑</a>
								<a class="yellow" href="#">美眉</a>
								<a class="blue" href="#">同人</a>
								<a class="blue" href="#">武侠</a>
								<a class="red" href="#">魔幻</a>
								<a href="#">教案</a>
								<a href="#">论文</a>
								<a class="yellow" href="#">妩媚</a>
								<a href="#">诱惑</a>
								<a class="blue" href="#">科幻</a>
								<a class="red" href="#">恐怖</a>
								<a class="red" href="#">性感</a>
								<a class="blue" href="#">TXT下载</a>
								<a href="#">音乐</a>
								<a class="blue" href="#">游戏</a>
								<a class="blue" href="#">CG资源</a>
								<a href="#">YunFile</a>
								<a href="#">课件</a>
								<a href="#">幽默</a>
								<a href="#">私人照</a>
								<a href="#">名校</a>
								<a class="red" href="#">赚钱</a>
								<a class="yellow" href="#">千脑</a>
								<a class="yellow" href="#">清純</a>
								<a class="yellow" href="#">云电脑</a>
							</div>
						</div>
					</div>
					<!--存储空间-->
					<div class="grzx-left-main-1">
						<div class="grzx-left-main-1-head">
							存储空间
						</div>
						<div class="jindutiao">
							<div class="progress ">
								<div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
									60%
								</div>
							</div>
							&nbsp;&nbsp;216.63GB/11.51TB
						</div>
					</div>

				</div>
			</div>

			<!--页面主题-->
			<div class="grzx-right">
				<div class="grzx-but-sc-xj">
					<div class="grzx-but-sc">
						<button><img src="${ctx }/img/shangchuan.png" />上传</button>
					</div>
					<div class="grzx-but-xj">
						<button onclick="createWJJ();">新建文件夹</button>
					</div>
				</div>

				<div class="grzx-right-main">
					<div style="position: relative;">
						<label>
							<input type="checkbox" onclick="selectAll()" name="controlAll" style="controlAll" id="controlAll" />
							<span class="checkboxbg"></span>
						</label>
						<div class="grzx-right-main-title">
							<span class="grzx-right-wjm">
								文件名
							</span>
							<span class="grzx-right-dx">大小</span>
							<span class="grzx-right-time">修改日期</span>
						</div>
					</div>
					<div id="textbox">
						<div class="textbox-1" style="position: relative;">
							<label>
								<input type="checkbox" name="selected" />
								<span class="checkboxbg"></span>
								<div class="grzx-right-main-list">
									<span class="grzx-right-wjm">
									<img src="img/wenjianjia.png" />新建文件夹
								</span>
									<span class="grzx-right-dx">大小</span>
									<span class="grzx-right-time">修改日期</span>
								</div>
							</label>
						</div>
						<div class="textbox-1" style="position: relative;">
							<label>
								<input type="checkbox" name="selected" />
								<span class="checkboxbg"></span>
								<div class="grzx-right-main-list">
									<span class="grzx-right-wjm">
									<img src="${ctx }/img/docx_win.png" />新建文件夹
								</span>
									<span class="grzx-right-dx">大小</span>
									<span class="grzx-right-time">修改日期</span>
								</div>
							</label>
						</div>
						<div class="textbox-1" style="position: relative;">
							<label>
								<input type="checkbox" name="selected" />
								<span class="checkboxbg"></span>
								<div class="grzx-right-main-list">
									<span class="grzx-right-wjm">
									<img src="${ctx }/img/pptx_win.png" />新建文件夹
								</span>
									<span class="grzx-right-dx">大小</span>
									<span class="grzx-right-time">修改日期</span>
								</div>
							</label>
						</div>
						<div class="textbox-1" style="position: relative;">
							<label>
								<input type="checkbox" name="selected" />
								<span class="checkboxbg"></span>
								<div class="grzx-right-main-list">
									<span class="grzx-right-wjm">
									<img src="${ctx }/img/rar.png" />新建文件夹
								</span>
									<span class="grzx-right-dx">大小</span>
									<span class="grzx-right-time">修改日期</span>
								</div>
							</label>
						</div>
						<div class="textbox-1" style="position: relative;">
							<label>
								<input type="checkbox" name="selected" />
								<span class="checkboxbg"></span>
								<div class="grzx-right-main-list">
									<span class="grzx-right-wjm">
									<img src="${ctx }/img/text.png" />新建文件夹
								</span>
									<span class="grzx-right-dx">大小</span>
									<span class="grzx-right-time">修改日期</span>
								</div>
							</label>
						</div>
						<div class="textbox-1" style="position: relative;">
							<label>
								<input type="checkbox" name="selected" />
								<span class="checkboxbg"></span>
								<div class="grzx-right-main-list">
									<span class="grzx-right-wjm">
									<img src="${ctx }/img/xlsx_win.png" />新建文件夹
								</span>
									<span class="grzx-right-dx">大小</span>
									<span class="grzx-right-time">修改日期</span>
								</div>
							</label>
						</div>
						<div class="textbox-1" style="position: relative;">
							<label>
								<input type="checkbox" name="selected" />
								<span class="checkboxbg"></span>
								<div class="grzx-right-main-list">
									<span class="grzx-right-wjm">
									<img src="${ctx }/img/zip.png" />新建文件夹
								</span>
									<span class="grzx-right-dx">大小</span>
									<span class="grzx-right-time">修改日期</span>
								</div>
							</label>
						</div>
					</div>
					<div id="myMenu">
						<table cellspace="3">
							<tr><td>下载</td></tr>
							<tr><td>删除</td></tr>
							<tr><td>重命名</td></tr>
							<tr><td>分享</td></tr>
						</table>
					</div>
					<div id="mask"> </div>

				</div>
			</div>

		</div>

<script>
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
			'height': windowheight,
			'width': windowwidth
		});
		$('#myMenu').show(0);
		$('#myMenu').css({
			'top': e.pageY-45 + 'px',
			'left': e.pageX-80 + 'px'
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
});

//新建文件夹按钮响应函数
function createWJJ(){
	var str = '<div id="adds" class="textbox-1" style="position: relative;"><label>'
	+'<input type="checkbox" name="selected" />'
	+'<span class="checkboxbg"></span>'
	+'<div class="grzx-right-main-list">'
	+'<span class="grzx-right-wjm">'
	+'<img src="${ctx}/img/wenjianjia.png" /><span id="newName2" style="display:none;"></span>'
	+'<input id="newName1" type="text" value="新建文件夹" />'
	+'<button class="queren" onclick="queren();"></button>'
	+'<button class="quxiao" onclick="quxiao();"></button>'
	+'</span>'
	+'<span class="grzx-right-dx">大小</span>'
	+'<span class="grzx-right-time">修改日期</span>'
	+'</div>'
	+'</label>'
	+'</div>';
	$("#textbox").append(str);
}

function queren(){
	var newName = $("#newName1").val();
	$("#newName2").html(newName);
	$("#newName1").hide();
	$("#newName2").show();
	$(".queren").hide();
	$(".quxiao").hide();
}

function quxiao(){
	$("#adds").remove();
}
</script>

	</body>

</html>