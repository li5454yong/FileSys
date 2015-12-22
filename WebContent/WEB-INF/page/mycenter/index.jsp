<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/tag/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>云数据</title>
<meta name="viewport"
	content="initial-scale=1,maximum-scale=1,user-scalable=no,width=device-width,height=device-height">
<link rel="stylesheet" href="${ctx }/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx }/css/style.css" />
<!--标签云js引入-->
<script type="text/javascript" src="${ctx }/js/script.js"></script>
<!--标签云结束-->
<script type="text/javascript" src="${ctx }/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }/js/json2.js"></script>
<!-- 个人中心页面js -->
<script type="text/javascript" src="${ctx }/js/mycenter.js"></script>
<!-- bootstrap.js -->
<script type="text/javascript" src="${ctx }/js/bootstrap.min.js"></script>

<style>
	.modal-header{
		background:#96C0F2;
		border-top-left-radius:5px;
		color:#fff;
		border-top-right-radius:5px;
	}
</style>

</head>

<body>
	<div class="grzx-head">
		<div class="grzx-head-main">
			<div class="logo">
				<img src="${ctx }/img/logo.png" />
			</div>
			<div class="grzx-head-menu">
				<span class="grzx-head-menu1 active">主页</span> <span
					class="grzx-head-menu1">收藏</span> <span class="grzx-head-menu1">分享</span>
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
					<div class="grzx-left-main-1-head">文件存档</div>
					<div class="grzx-left-main-1-main">
						<div>
							2015年12月<span>(10)</span>
						</div>
						<div>
							2015年11月<span>(10)</span>
						</div>
						<div>
							2015年10月<span>(10)</span>
						</div>
						<div>
							2015年09月<span>(10)</span>
						</div>
						<div>
							2015年08月<span>(10)</span>
						</div>
						<div>
							2015年07月<span>(10)</span>
						</div>
						<div>
							2015年06月<span>(10)</span>
						</div>
						<div>
							2015年05月<span>(10)</span>
						</div>
					</div>
				</div>
				<!--文件分类   标签云-->
				<div class="grzx-left-main-1">
					<div class="grzx-left-main-1-head">文件分类</div>
					<div class="grzx-left-main-1-main">
						<div id="tagbox">
							<a href="#">美女</a> <a class="red" href="#">写真</a> <a href="#">贴图</a>
							<a href="#">灌水</a> <a class="blue" href="#">大片</a> <a href="#">小说</a>
							<a class="red" href="#">欧美</a> <a class="yellow" href="#">日韩</a>
							<a href="#">诱人</a> <a class="red" href="#">搞笑</a> <a href="#">性感</a>
							<a class="blue" href="#">壁纸</a> <a class="blue" href="#">泳装</a> <a
								class="red" href="#">言情</a> <a class="yellow" href="#">浪漫</a> <a
								class="yellow" href="#">耽美</a> <a class="blue" href="#">爆笑</a> <a
								class="yellow" href="#">美眉</a> <a class="blue" href="#">同人</a> <a
								class="blue" href="#">武侠</a> <a class="red" href="#">魔幻</a> <a
								href="#">教案</a> <a href="#">论文</a> <a class="yellow" href="#">妩媚</a>
							<a href="#">诱惑</a> <a class="blue" href="#">科幻</a> <a class="red"
								href="#">恐怖</a> <a class="red" href="#">性感</a> <a class="blue"
								href="#">TXT下载</a> <a href="#">音乐</a> <a class="blue" href="#">游戏</a>
							<a class="blue" href="#">CG资源</a> <a href="#">YunFile</a> <a
								href="#">课件</a> <a href="#">幽默</a> <a href="#">私人照</a> <a
								href="#">名校</a> <a class="red" href="#">赚钱</a> <a class="yellow"
								href="#">千脑</a> <a class="yellow" href="#">清純</a> <a
								class="yellow" href="#">云电脑</a>
						</div>
					</div>
				</div>
				<!--存储空间-->
				<div class="grzx-left-main-1">
					<div class="grzx-left-main-1-head">存储空间</div>
					<div class="jindutiao">
						<div class="progress ">
							<div class="progress-bar" role="progressbar" aria-valuenow="60"
								aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
								40%</div>
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
					<button class="btn" onclick="upload();"  data-toggle="modal" data-target="#myModal">
						<img src="${ctx }/img/shangchuan.png" />上传
					</button>
				</div>
				<div class="grzx-but-xj">
					<button onclick="createWJJ();">新建文件夹</button>
				</div>
			</div>

			<!-- 上传弹出层页面开始 -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header" >
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">上传文件</h4>
						</div>
						<div class="modal-body">
						<%@include file="/WEB-INF/page/file/uploadFile.jsp" %>
						</div>
						
					</div>
				</div>
			</div>
			<!-- 上传弹出层页面结束 -->





			<div class="grzx-but-reaches">
			<c:if test="${pId != 0}">
				<c:set var="length" value="${fn:length(pId) }"/>
				
				<a href="${ctx }/toMycenter?pId=${fn:substring(pId,0,length-2) }&selfId=${fn:substring(pId,0,length-2) }">返回上一级</a>&nbsp;|&nbsp;
			</c:if>
				<a href="${ctx }/toMycenter">全部</a>
			<c:forEach items="${parentList}" var="item">
				&nbsp;>&nbsp;<a href="${ctx }/toMycenter?pId=${item.self_id}&selfId=${item.self_id}">${item.title }</a>
			</c:forEach>
			</div>
			<div class="grzx-right-main">
				<div style="position: relative;">
					<label> <input type="checkbox" onclick="selectAll()"
						name="controlAll" style="" id="controlAll" /> <span
						class="checkboxbg"></span>
					</label>
					<div class="grzx-right-main-title">
						<span class="grzx-right-wjm"> 文件名 </span> <span
							class="grzx-right-dx">大小</span> <span class="grzx-right-time">修改日期</span>
					</div>
				</div>
				<div id="textbox">
					<c:forEach items="${categoryList }" var="item">
						<div class="textbox-1" style="position: relative;">
							<label> <input type="checkbox" name="selected" /> <span
								class="checkboxbg"></span>
								<div class="grzx-right-main-list">
									<span class="grzx-right-wjm"> <img
										src="${ctx }/img/wenjianjia.png" /> <a
										href="javascript:next('${item.self_id }');">${item.title }</a>
									</span> <span class="grzx-right-dx">--</span> <span
										class="grzx-right-time"> <fmt:formatDate
											value="${item.upd_date }" pattern="yyyy-MM-dd HH:mm:ss" />
									</span>
								</div>
							</label>
						</div>
					</c:forEach>
					<c:forEach items="${fileList }" var="item">
						<div class="textbox-1" style="position: relative;">
							<label> <input type="checkbox" name="selected" /> <span
								class="checkboxbg"></span>
								<div class="grzx-right-main-list">
									<span class="grzx-right-wjm"> <img
										src="${ctx }/${item.icon_path}" />${item.filename }
									</span> <span class="grzx-right-dx">${item.filesize }&nbsp;</span> <span
										class="grzx-right-time"> <fmt:formatDate
											value="${item.upd_date }" pattern="yyyy-MM-dd HH:mm:ss" />
									</span>
								</div>
							</label>
						</div>
					</c:forEach>
					<c:if test="${categoryLength == 0 && fileLength == 0}">
						<div class="no-content" >
							<img src="${ctx }/img/no-content.jpg" />
						</div>
					</c:if>
					
				</div>
				<input type="hidden" id="categoryLength" value="${categoryLength }">
				<input type="hidden" id="pId" value="${pId }">
				
				<div id="myMenu">
					<table cellspace="3">
						<tr>
							<td class="btn">下载</td>
						</tr>
						<tr>
							<td class="btn">删除</td>
						</tr>
						<tr>
							<td class="btn">重命名</td>
						</tr>
						<tr>
							<td class="btn" data-toggle="modal" data-target="#myModal2">分享</td>
						</tr>
					</table>
					
					
					<!-- 分享弹出层页面开始 -->
					<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header" >
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">上传文件</h4>
								</div>
								
								
							</div>
						</div>
					</div>
					<!-- 分享弹出层页面结束 -->
					
					
				</div>
				<div id="mask"></div>

			</div>
		</div>

	</div>
</body>
<script type="text/javascript">
	//新建文件夹按钮响应函数
	function createWJJ() {
		var str = '<div id="adds" class="textbox-1" style="position: relative;"><label>'
				+ '<input type="checkbox" name="selected" />'
				+ '<span class="checkboxbg"></span>'
				+ '<div class="grzx-right-main-list">'
				+ '<span class="grzx-right-wjm">'
				+ '<img src="${ctx}/img/wenjianjia.png" /><span id="newName2" style="display:none;"></span>'
				+ '<input id="newName1" type="text" value="新建文件夹" />'
				+ '<button class="queren" onclick="queren();"></button>'
				+ '<button class="quxiao" onclick="quxiao();"></button>'
				+ '</span>'
				+ '<span class="grzx-right-dx">--</span>'
				+ '<span class="grzx-right-time"></span>'
				+ '</div>'
				+ '</label>' + '</div>';
		if('${fileLength}'==0&&'${categoryLength}'==0){
			$("#textbox").html(str);
		}else{
			$("#textbox").append(str);
		}
		
	}

	//新建文件夹 确认按钮事件
	function queren() {
		var newName = $("#newName1").val();
		var p_id = $("#pId").val();
		var categoryLength = $("#categoryLength").val();

		$.ajax({
			url : '${ctx}/addCategory',
			type : 'POST',
			data : {
				'title' : newName,
				'pId' : p_id,
				'length' : categoryLength
			},
			success : function(data) {
				if (data.message != 'false') {
					$("#newName2").html(newName);
					$("#newName1").hide();
					$("#newName2").show();
					$(".queren").hide();
					$(".quxiao").hide();
					window.location.href = "${ctx}/" + data.message + "?pId="
							+ p_id+"&selfId="+p_id;
				} else {
					alert("文件夹已存在");
				}
			}
		});
	}

	// 新建文件夹 取消按钮事件
	function quxiao() {
		$("#adds").remove();
		var str = '<div class="no-content" >'
			+'<img src="${ctx }/img/no-content.jpg" />'
			+'</div>';
		if('${fileLength}'==0&&'${categoryLength}'==0){
			$("#textbox").html(str);
		}
	}

	
	function upload(){
		//alert(1);
	}
	
	//加载文件夹内内容
	function next(selfId) {
		window.location.href = "${ctx}/toMycenter?pId=" + selfId+"&selfId="+selfId;
		/*$.ajax({
			url:'${ctx}/getNextContent',
			type:'POST',
			data:{'selfId':selfId},
			success:function(data){
				
				var str = '';
				$("#pId").val(selfId);
				
				var d = data.message;
				if(d != "toLogin"){
					var jsonObj = d.split("@LXG");
					var jsonObj1 = JSON.parse(jsonObj[0]);
					var jsonObj2 = JSON.parse(jsonObj[1]);
					if(jsonObj1.length == 0 && jsonObj2.length == 0){
						$("#textbox").html("暂无内容");
					}else{
						$.each(jsonObj1,function(i,item){
							str += '<div class="textbox-1" style="position: relative;">'
								+'<label>'
								+'<input type="checkbox" name="selected" />'
								+'<span class="checkboxbg"></span>'
								+'<div class="grzx-right-main-list">'
								+'<span class="grzx-right-wjm">'
								+'<img src="${ctx }/img/wenjianjia.png" />'
								+'<a href="javascript:next('+item.self_id+');">'+item.title+'</a>'
								+'</span>'
								+'<span class="grzx-right-dx">--</span>'
								+'<span class="grzx-right-time">'
								+fromatDate(new Date(item.upd_date))
								+'</span>'
							+'</div>'
							+'</label>'
							+'</div>';
						});
						$("#categoryLength").val(jsonObj1.length);
						$("#textbox").html(str);
					}
					
				}
			}
		});*/
	}
</script>
</html>