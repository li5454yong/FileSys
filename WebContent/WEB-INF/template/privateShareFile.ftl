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
			
			#mima{
				position:absolute;
				top:0;
				left:0;
				width:100%;
				height:100%;
				background:url(../img/jiami-bg.png) no-repeat;
				background-size:cover;555
			}
			.tiquma{
				background:url(../img/tiquma-bg.png) no-repeat;
				width:390px;
				height:248px;
				margin:300px auto 0 auto;
				position:relative;
				
			}
			.tiquma input{
				position:relative;
				top:93px;
				left:33px;
				height:30px;
				width:185px;
				border:none;
				outline:none;
				padding-left:8px;
				vertical-align:top;
			}
			.tiquma button{
				position:relative;
				top:93px;
				left:43px;
				width:120px;
				height:35px;
				border:none;
				/* opacity:0; */
				background: rgba(0,0,0,0);
			}
			.tiquma button:hover{
				cursor:pointer;
			}
			.file{
				display:none;
			}
		</style>
	</head>

	<body>
		<!--头部内容开始-->
		<div class="grzx-head file">    
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
		<div class="down-content file">
			<div class="down-content-title">
				<span class="down-wjm"><img src="../${file.icon_path}" />${file.filename }</span>
				<span class="down-sc">
					<!--<button><img src="../img/shoucang.png" /> 收藏</button>-->
					<!--<button>举报</button>-->
				</span>
			</div>
			<div class="down-content-sub-title">
				<ul>
					<li><img src="../img/zan.png" /> 赞</li>
					<li>评论</li>
					<li>分享至</li>
					
				</ul>
				<div style="clear: both;"></div>
			</div>
			<div class="down-content-main file">
				<img src="../${file.icon_path}" />
				<p>文件大小：${file.filesize }</p>
				<button onclick="download();">下载(${file.filesize })</button>
			</div>
			<input id="userId" type="hidden" value="${userId}">
			<p class="share-time">分享时间：${shareDate?string("yyyy-MM-dd")}</p>
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
		<div id="mima">
		<div class="tiquma">
			<input type="text" id="passwd" />
			<button onclick="tijiao();"></button>
		</div>
		</div>
	</body>
	<script>
	// 文件下载
	function download(){
		var userId = $("#userId").val();
		var url = window.location.href;
		location.href = '../share/download?url='+url+'&user_id='+userId;
	}
		function tijiao(){
			var passwd = $("#passwd").val();
			var url = window.location.href;
			$.ajax({
				url:'../files/getPrivateShare',
				data:{'url':url,'passwd':passwd},
				type:'POST',
				success:function(data){
				//alert(data.message);
					if(data.message == 0){
						$("#mima").hide();
						$(".file").show();
					}else if(data.message == 1){
						alert("密码错误");
					}
				}
			});
			
		}
	</script>
</html>