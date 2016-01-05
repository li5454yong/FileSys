<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/page/tag/tag.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>登录</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">

		<!-- CSS -->
		<link rel="stylesheet" href="${ctx }/assets/css/reset.css">
		<link rel="stylesheet" href="${ctx }/assets/css/supersized.css">
		<link rel="stylesheet" href="${ctx }/assets/css/style.css">

		<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
	<script type="text/javascript" src="${ctx }/js/jquery-1.9.1.min.js"></script>
	</head>

	<body>
		<div class="login-logo">
			<img src="${ctx }/img/logo.png" />
		</div>
		<div class="page-container-div">
			<div class="page-container">
				<h1>登录</h1>
				<form action="" method="post">
					<input type="text" name="username" class="username" placeholder="用户名">
					<input type="password" name="password" class="password" placeholder="密码">
					<button type="button" id="loginDo" onclick="login();">登录</button>
					
					<div class="error"><span>+</span></div>
				</form>
				<a href="${ctx }/toReg"><button>免费注册</button></a>

			</div>
		</div>

		<!-- Javascript -->
		<script src="${ctx }/assets/js/jquery-1.8.2.min.js"></script>
		<script src="${ctx }/assets/js/supersized.3.2.7.min.js"></script>
		<script src="${ctx }/assets/js/supersized-init.js"></script>
		<script src="${ctx }/assets/js/scripts.js"></script>

	</body>
<script type="text/javascript">

function login(){
	var username = $("input[name=username]").val();
	var password = $("input[name=password]").val();
	$.ajax({
		url:'${ctx}/login',
		type:'POST',
		//ansyc:false,
		data:{'username':username,'password':password},
		success:function(data){
			if(data == 1){
				alert("用户不存在");
			}else if(data == 2){
				alert("密码错误");
			}else if(data == 0){
				window.location.href="${ctx}/toMycenter";
			}
		}
	});
}

$(function(){
	document.onkeydown = function(e){
	var ev = document.all ? window.event : e;
	if(ev.keyCode==13) {
		login();
	}
	}
});

</script>
</html>