<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/page/tag/tag.jsp"%>
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
		
		<style>
			body{
				background: #EEF8FE;
			}
		</style>
	</head>

	<body>
		<!--头部内容开始-->
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
		<!--头部内容结束-->
		<!--主体内容开始-->
		<div class="down-content">
			<div class="down-content-title">
				<span class="down-wjm"><img src="${ctx }/img/rar.png" />文件名.rar</span>
				<span class="down-sc">
					<button><img src="${ctx }/img/shoucang.png" /> 收藏</button>
					<button>举报</button>
				</span>
			</div>
			<div class="down-content-sub-title">
				<ul>
					<li><img src="${ctx }/img/zan.png" /> 赞</li>
					<li>评论</li>
					<li>分享至</li>
					
				</ul>
				<div style="clear: both;"></div>
			</div>
			<div class="down-content-main">
				<img src="${ctx }/img/rar.png" />
				<p>文件大小：300B</p>
				<button>下载(300B)</button>
			</div>
			<p class="share-time">分享时间：2015-12-10</p>
			<div class="down-pinglun">
				<div class="down-pinglun-xiangqing">
					<img src="${ctx }/img/pinglun.png" />评论详情
				</div>
				<textarea >我来评两句~</textarea>
				<button class="pinglun-but">评论</button>
				<div style="clear: both;"></div>
			</div>
			<div class="down-pinglun-list">
				<p>刘真：我来评两句~</p>
				<span class="down-pinglun-huifu">回复</span>
				<div style="clear: both;"></div>
			</div>
			<div class="down-pinglun-list">
				<p>刘真：我来评两句~</p>
				<span class="down-pinglun-huifu">回复</span>
				<div style="clear: both;"></div>
			</div>
			
		</div>
		<!--主体内容结束-->
		<!--页面左侧-->
		


	</body>

</html>