<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/page/tag/tag.jsp" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>注册</title>
		<meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no,width=device-width,height=device-height">
		<link rel="stylesheet" href="${ctx }/css/style.css" />
		<style>
			body {
				background: #EEF8FE;
			}
		</style>
		<style type="text/css">

		</style>
	</head>

	<body>
		<div class="reg-title">
			<div class="reg-title-main">
				<img src="${ctx }/img/logo.png" />
			</div>
		</div>
		<div class="reg-main">
			<div class="reg-main-title">
				欢迎注册云数据
			</div>
			<div class="reg-main-con">
				<div class="contact">
					<form name="form1" action="${ctx }/reg" method="post">
						<ul>
							<li>
								<label>用户名：</label>
								<input type="text" name="yourname" placeholder="请输入用户名" onblur="checkna()" required/>
								<span class="tips" id="divname">&nbsp;&nbsp;请输入您的手机号</span>
							</li>
							<li>
								<label>密码：</label>
								<input type="password" name="yourpass" placeholder="请输入你的密码" onBlur="checkpsd1()" required/>
								<span class="tips" id="divpassword1">密码必须由字母和数字组成</span>
							</li>
							<li>
								<label>确认密码：</label>
								<input type="password" name="yourpass2" placeholder="请再次输入你的密码" onBlur="checkpsd2()" required/>
								<span class="tips" id="divpassword2">两次密码需要相同</span>
							</li>
							<li>
								<label>电子邮箱：</label>
								<input type="text" name="youremail" placeholder="请输入你的邮箱" onBlur="checkmail()" required/>
								<span class="tips" id="divmail"></span>
							</li>
						</ul>
						<b class="btn"><input type="submit" value="提交"/>
										<input type="reset" value="取消"/></b>
					</form>
				</div>
			</div>

		</div>
		<!--验证表单的js代码开始-->
		<script type="text/javascript">
			function checkna() {
				//验证用户名
				na = form1.yourname.value;
				/*if( na.length <1 || na.length >12) */
				if (na.length != 11) {
					divname.innerHTML = '<font class="tips_false">请输入正确的手机号</font>';
				} else {
					divname.innerHTML = '<font class="tips_true">输入正确</font>';
				}
			}
			//验证密码 
			function  checkpsd1() {    
				psd1 = form1.yourpass.value;  
				var  flagZM = false ;
				var  flagSZ = false ; 
				var  flagQT = false ;
				if (psd1.length < 6 || psd1.length > 12) {   
					divpassword1.innerHTML = '<font class="tips_false">请输入6~12位字符长度</font>';
				} else { 
					for (i = 0; i  <  psd1.length; i++)    {    
						if ((psd1.charAt(i)  >=  'A'  &&  psd1.charAt(i) <= 'Z')  ||  (psd1.charAt(i) >= 'a'  &&  psd1.charAt(i) <= 'z'))  {   
							flagZM = true;
						} else  if (psd1.charAt(i) >= '0'  &&  psd1.charAt(i) <= '9')     { 
							flagSZ = true;
						} else     { 
							flagQT = true;
						}   
					}   
					if (!flagZM || !flagSZ || flagQT) {
						divpassword1.innerHTML = '<font class="tips_false">密码必须是字母数字的组合</font>';  
					} else {
						divpassword1.innerHTML = '<font class="tips_true">输入正确</font>'; 
					}   
				}
			}
			//验证确认密码 
			function  checkpsd2() { 
				if (form1.yourpass.value != form1.yourpass2.value)  {   
					divpassword2.innerHTML = '<font class="tips_false">您两次输入的密码不一样</font>';
				} 
				else  {  
					divpassword2.innerHTML = '<font class="tips_true">输入正确</font>';
				}
			}
			//验证邮箱
			function checkmail() {
				apos = form1.youremail.value.indexOf("@");
				dotpos = form1.youremail.value.lastIndexOf(".");
				if (apos < 1 || dotpos - apos < 2) {
					divmail.innerHTML = '<font class="tips_false">输入错误</font>' ;
				} else {
					divmail.innerHTML = '<font class="tips_true">输入正确</font>' ;
				}
			}
		</script>
		<!--验证表单的js代码结束-->

	</body>

</html>