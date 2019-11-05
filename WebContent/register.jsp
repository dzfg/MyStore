<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>欢迎使用商城系统</title>
		<link type="text/css" href="css/register.css" rel="stylesheet" />
		<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
		<script type="text/javascript" src="js/js001.js"></script>
	</head>

	<body>
		<h1>欢迎使用商城系统</h1>
		<hr />
		<div class="box0">
			<div class="boxH2">
				<h2>用户注册</h2>
			</div>

			<form action="${pageContext.request.contextPath }/registerServlet" method="post">
				<div class="boxIpt1">
					<input type="text" name="username" id="username" placeholder="请输入您的帐号" required />
				</div>
				<div class="boxError">
					<div class="boxMsg1">
						<span id="usernameMsg"></span>
						<br/>
					</div>
					<div class="boxMsg2">
						<span id="pwdMsg"></span>
						<br/>
					</div>
					<div class="boxMsg3">
						<span id="emailMsg"></span>
					</div>
				</div>
				<br />
				<div class="boxPwd1">
					<input type="password" name="pwd" id="pwd1" placeholder="请输入密码" required />
				</div>
				<br />
				<div class="boxPwd2">
					<input type="password" id="pwd2" placeholder="请再次输入密码" required />
				</div>
				<br />
				<div class="boxEmail">
					<input type="email" name="email" id="email" placeholder="请输入您的邮箱" required  />
				</div>
				<br />
				<div class="boxIpt2">
					<input type="text" id="validate" name="validate" placeholder="请输入您的邮箱验证码" required />
				</div>
				<div class="boxBtn1">
					<input type="button" id="btn1" value="获取验证码" />
				</div>
				<br />
				<div class="boxSub">
					<input type="submit" id="sub1" value="注册" />
				</div>
			</form>
				<a href="${pageContext.request.contextPath }/login.jsp">>>已有账号,去登陆</a>
		</div>
	</body>

</html>