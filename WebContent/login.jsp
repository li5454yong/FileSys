<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/page/tag/tag.jsp" %>
<!DOCTYPE html>
<html lang="en" class="no-js">

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

	</head>

	<body>
		<div class="login-logo">
			<img src="${ctx }/img/logo.png" />
		</div>
		<div class="page-container-div">
			<div class="page-container">
				<h1>登录</h1>
				<form action="${ctx }/login" method="post">
					<input type="text" name="username" class="username" placeholder="用户名">
					<input type="password" name="password" class="password" placeholder="密码">
					<button type="submit">登录</button>
					
					<div class="error"><span>+</span></div>
				</form>
				<a href="reg.html"><button>免费注册</button></a>

			</div>
		</div>

		<!-- Javascript -->
		<script src="${ctx }/assets/js/jquery-1.8.2.min.js"></script>
		<script src="${ctx }/assets/js/supersized.3.2.7.min.js"></script>
		<script src="${ctx }/assets/js/supersized-init.js"></script>
		<script src="${ctx }/assets/js/scripts.js"></script>

	</body>

</html>