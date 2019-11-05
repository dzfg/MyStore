<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>欢迎使用商城系统</title>
		<link type="text/css" href="css/login.css" rel="stylesheet" />
		<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
		<script type="text/javascript">
			function changeImg() {
				var validateImg = document.getElementById("validateImg");
				validateImg.src = "${pageContext.request.contextPath }/validateImgServlet?time=" + new Date();
			}
			
			$(function(){
				
				$("#validateImg").click(function(){
					$(this).attr("src","${pageContext.request.contextPath }/validateImgServlet?time=" + new Date());
					//清空错误信息
					$("#validateSpan").html("");
				});
				
				
				$("#validate").blur(function(){
					$.post("/myStore/validateServlet",{
						"validate":$("#validate").val()
					},function(responseText){
						if(responseText==0){
							$("#validateSpan").html("<font color='red'>验证码输入错误噢</font>");
							$("#sub1").attr("disabled",true);
						}else if(responseText==1){
							$("#validateSpan").html("<font color='green'>√</font>");
							$("#sub1").attr("disabled",false);
						}else{
							$("#validateSpan").html("<font color='red'>验证码失效了,请刷新验证码</font>");
							$("#sub1").attr("disabled",true);
						}
					},"text");
				});				
			});
			
		</script>
	</head>

	<body>
		<h1>欢迎使用商城系统</h1>
		<hr />
		<div class="box0">
			<div class="boxH2">
				<h2>用户登录</h2>
			</div>

			<form action="${pageContext.request.contextPath }/loginServlet" method="post">
				<div class="boxIpt1">
					<input type="text" name="username" id="username" placeholder="请输入您的帐号" required value="${username}"/>
				</div>
				<div class="boxError">
					<div class="boxMsg1">
						<span id="usernameMsg" style="color:red;">${usernameMsg}</span>
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
				<div class="boxIpt2">
					<input type="text" name="validate" id="validate" placeholder="请输入验证码" required />
				</div>
				<div class="boxImg">
					<img alt="验证码" src="${pageContext.request.contextPath }/validateImgServlet" id="validateImg"/>
					<br/>
					<span id="validateSpan"></span>
				</div>
				<br />
				<div class="boxSub">
					<input type="submit" id="sub1" value="登录" />
				</div>
			</form>
			<a href="${pageContext.request.contextPath }/register.jsp">>>没有账号,去注册</a>
		</div>
	</body>
</html>