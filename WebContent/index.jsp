<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用商城系统</title>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn1").click(function(){
			alert("用户将退出登录,执行激活操作");
		});
	});

</script>
</head>
<body>
	<c:if test="${user!=null}">欢迎${user.username }登录</c:if>
	<c:if test="${user.state == 0}"><button id="btn1"><a href="${pageContext.request.contextPath }/activateUserServlet?code=${user.code}&email=${user.email}">点击此处激活用户</a></button></c:if>
	<c:if test="${user.state == 1}">用户已成功激活</c:if>
	
	<c:if test="${user == null }">
		<a href="${pageContext.request.contextPath }/register.jsp">注册</a>
		<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
	</c:if>
</body>
</html>