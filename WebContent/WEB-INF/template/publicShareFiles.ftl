<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>云数据</title>
		<meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no,width=device-width,height=device-height">
		<link rel="stylesheet" href="../css/bootstrap.min.css" />
		<link rel="stylesheet" href="../css/style.css" />
		<!--标签云js引入-->
		<script type="text/javascript" src="../js/script.js"></script>
		<!--标签云结束-->
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		
		<style>
			body{
				background: #EEF8FE;
			}
			.grzx-right-main{
				margin:20px;
			}
			.grzx-right-main-title{
				width:938px;
			}
			.grzx-right-main-list{
				width:938px;
			}
			.share-time{
				margin-right:20px
			}
		</style>
	</head>

	<body>
		<!--头部内容开始-->
		<div class="grzx-head">    
			<div class="grzx-head-main">
				<div class="logo">
					<img src="../img/logo.png" />
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
				<span class="down-sc">
					<button><img src="../img/shoucang.png" /> 收藏</button>
					<button>举报</button>
				</span>
				<div style="clear:both"></div>
			</div>
			<div class="down-content-sub-title">
				<ul>
					<li><img src="../img/zan.png" /> 赞</li>
					<li>评论</li>
					<li>分享至</li>
					
				</ul>
				<div style="clear: both;"></div>
			</div>
			<div class="grzx-right-main" >
				<div style="position: relative;" id="titleBar">
					<label> <input type="checkbox" onclick="selectAll()"
						name="controlAll" style="" id="controlAll" /> <span
						class="checkboxbg"></span>
					</label>
					<div class="grzx-right-main-title">
						<span class="grzx-right-wjm"> 文件名 </span> <span
							class="grzx-right-dx">大小</span> <span class="grzx-right-time">修改日期</span>
					</div>
				</div>
				<div id="textbox" >
					<#list categoryList as item>
						<div class="textbox-1" style="position: relative;" >
							<label> <input type="checkbox" name="selected" fType="category" fId="${item.id }"/> 
							<span class="checkboxbg"></span>
								<div class="grzx-right-main-list">
									<span class="grzx-right-wjm"> 
									<img src="../img/wenjianjia.png" /> 
									<a href="javascript:next('${item.self_id }');">${item.title }</a>
									</span> <span class="grzx-right-dx">--</span> 
									<span class="grzx-right-time"> 
										${item.upd_date?string("yyyy-MM-dd HH:mm:ss") }
									</span>
								</div>
							</label>
						</div>
					</#list>
					<#list fileList as item>
						<div class="textbox-1" style="position: relative;">
							<label> <input type="checkbox" name="selected" ftype="file" fId="${item.id }"/> 
							<span class="checkboxbg"></span>
								<div class="grzx-right-main-list">
									<span class="grzx-right-wjm"> 
									<img src="../${item.icon_path}" />${item.filename }
									</span> 
									<span class="grzx-right-dx">${item.filesize }&nbsp;</span> 
									<span class="grzx-right-time"> 
									${item.upd_date?string("yyyy-MM-dd HH:mm:ss") }
									</span>
								</div>
							</label>
						</div>
					</#list>
				</div>
			</div>
			<p class="share-time">分享时间：2015-12-10</p>
			<div class="down-pinglun">
				<div class="down-pinglun-xiangqing">
					<img src="../img/pinglun.png" />评论详情
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
	<script>
		function next(selfId) {
		window.location.href = "${ctx}/toMycenter?pId=" 
				+ selfId+"&selfId="+selfId;
		}
	
	</script>
</html>