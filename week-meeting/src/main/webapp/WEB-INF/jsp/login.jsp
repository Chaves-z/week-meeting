<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>周会</title>
		<link type="text/css" rel="stylesheet" href="/css/login.css" />
		<script type="text/javascript" src="/js/jquery-1.6.4.js"></script>
	</head>

	<body>

			<div class="login_box">
				<div class="login_l_img">
					<img src="images/login-img.png" />
				</div>
				<div class="login">
					<div class="login_logo">
						<a href="#"><img src="images/login_logo.png" /></a>
					</div>
					<div class="login_name">
						<p>周会管理系统</p>
					</div>
					<form method="post" action="/login">
						<input name="username" type="text" value="用户名" onfocus="this.value=''" onblur="if(this.value==''){this.value='用户名'}"> 
						<span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();">密码</span>
						<input name="password" type="password" id="password" style="display: none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};" />
						<input value="登录" style="width: 100%;" type="submit">
					</form>
				</div>
				<!--   <div class="copyright">某某有限公司 版权所有©2016-2018 技术支持电话：000-00000000</div> -->
			</div>
	</body>

</html>