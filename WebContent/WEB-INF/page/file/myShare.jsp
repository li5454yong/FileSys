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
<script type="text/javascript" src="${ctx }/js/jquery-1.9.1.min.js"></script>

<!-- 剪切板js -->
<script type="text/javascript" src="${ctx }/js/jquery.zclip.min.js"></script>

<script type="text/javascript" src="${ctx }/js/json2.js"></script>
<!-- 个人中心页面js -->
<script type="text/javascript" src="${ctx }/js/mycenter.js"></script>
<!-- bootstrap.js -->
<script type="text/javascript" src="${ctx }/js/bootstrap.min.js"></script>

<!--瀑布流引入css以及js开始-->
<link rel="stylesheet" type="text/css" href="${ctx }/css/pbl/base.css">
<link rel="stylesheet" type="text/css" href="${ctx }/css/pbl/index.css">
<!--[if lt IE 9]>
<script src="js/css3-mediaqueries.js"></script>
<![endif]-->
<!--<script type="text/javascript" src="js/pbl/jquery-1.8.3.min.js"></script>-->
<!--这个插件是瀑布流主插件函数必须-->
<script type="text/javascript" src="${ctx }/js/pbl/jquery.masonry.min.js"></script>

<script type="text/javascript">

	$(function() {
		/*瀑布流开始*/
		var container = $('.waterfull ul');
		var loading = $('#imloading');
		// 初始化loading状态
		loading.data("on", true);
		/*判断瀑布流最大布局宽度，最大为1280*/
		function tores() {
			var tmpWid = $(window).width();
			if (tmpWid > 1000) {
				tmpWid = 1000;
			} else {
				var column = Math.floor(tmpWid / 320);
				tmpWid = column * 320;
			}
			$('.waterfull').width(tmpWid);
		}
		tores();
		$(window).resize(function() {
			tores();
		});
		container.imagesLoaded(function() {
			container.masonry({
				columnWidth: 320,
				itemSelector: '.item',
				isFitWidth: true, //是否根据浏览器窗口大小自动适应默认false
				isAnimated: true, //是否采用jquery动画进行重拍版
				isRTL: false, //设置布局的排列方式，即：定位砖块时，是从左向右排列还是从右向左排列。默认值为false，即从左向右
				isResizable: true, //是否自动布局默认true
				animationOptions: {
					duration: 800,
					easing: 'easeInOutBack', //如果你引用了jQeasing这里就可以添加对应的动态动画效果，如果没引用删除这行，默认是匀速变化
					queue: false //是否队列，从一点填充瀑布流
				}
			});
		});
		});

</script>
<!--瀑布流引入css以及js结束-->

<style>
	.modal-header{
		background:#96C0F2;
		border-top-left-radius:5px;
		color:#fff;
		border-top-right-radius:5px;
	}
	/* a:nth-child(2n+1){
		color:#f00;
	} */
	.a-color:nth-child(2n+1){
		color:#F64949
	}
	.a-color:nth-child(3n+1){
		color:#96C0F2;
	}
	.a-color:nth-child(4n+1){
		color:#A21039;
	}
	.a-color:nth-child(5n+1){
		color:#37972B
	}
	.a-color:nth-child(6n+1){
		color:#3281DE;
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
				<span class="grzx-head-menu1" onclick="toMycenter();">主页</span> 
				<!-- <span class="grzx-head-menu1">收藏</span>  -->
				<span class="grzx-head-menu1 active">分享</span>
				<!-- <span class="grzx-head-menu1">上传</span> -->
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
					<c:forEach items="${filingList }" var="item">
						<div>
							${item.year } 年 ${item.month }月<span>(${item.num })</span>
						</div>
					</c:forEach>
					</div>
				</div>
				<!--文件分类   标签云-->
				<div class="grzx-left-main-1">
					<div class="grzx-left-main-1-head">文件分类</div>
					<div class="grzx-left-main-1-main">
						<div id="tagbox">
							<c:forEach items="${tagCloud}" var="item">
								<a class="a-color" href="javascript:next('${item.self_id }');">${item.title }</a>
							</c:forEach>
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

		<!--页面主体内容开始-->
			<div class="grzx-right">
				<div class="content" style="margin: 10px 0 0 0;">
					<!-- 瀑布流样式开始 -->
					<div class="waterfull clearfloat" id="waterfull">
						<ul>
						  <c:forEach items="${list }" var="item">
							<li class="item">
								<%-- <div class="item-title"><img src="${ctx }/img/wenjianjia.png"/>大标题</div> --%>
								<div class="item-sub-title">
									<c:forEach items="${item.categoryList }" var="item1">
										<p><img src="${ctx }/img/wenjianjia.png">${item1.title}</p>
									</c:forEach>
									<c:forEach items="${item.fileList }" var="item2">
										<p><img src="${ctx }/${item2.icon_path}">${item2.filename}</p>
									</c:forEach>
								</div>
								
								<div class="item-group">
									<span class="item-group1"><a href="${item.url }">打开链接</a></span>
									<!-- <span class="item-group1">分享日期</span> -->
									<span class="item-group1" style="margin-left: 50px;">
									<fmt:formatDate value="${item.init_date }" pattern="yyyy-MM-dd HH:mm:ss"/>    </span>
								</div>
							</li>
							</c:forEach>
						</ul>
					</div>
				</div>

			</div>
			<!--页面主体内容结束-->

		</div>
	<script>
		function toMycenter(){
			window.location.href='${ctx}/toMycenter';
		}
	</script>
</body>
</html>
