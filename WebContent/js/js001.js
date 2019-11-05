$(function() {
		$("#username").blur(function() {
			if(!$("#username").val()==" "){
			$.post("/myStore/findUserByUsernameServlet", {
				"username": $("#username").val()
			}, function(responseText) {
				if(responseText == 0) {
					$("#usernameMsg").html("<font color='green'>这个帅气的名字归您了...</font>");
					$("#username").css("border","");
					$("#sub1").attr("disabled",false);
				} else {
					$("#usernameMsg").html("<font color='red'>该用户名已被注册了哦...</font>");
					$("#username").css("border","2px red solid");
					$("#sub1").attr("disabled",true);
				}
			}, "text");
		}else{
			$("#usernameMsg").html("<font color='red'>请输入用户名...</font>");
			$("#username").css("border","2px red solid");
			$("#sub1").attr("disabled",true);
		}	
	});
		
		$("#username").click(function(){
			$("#username").css("border","");
			$("#usernameMsg").html("<font color='cornflowerblue'>请填写6~10个字符</font>");
		});
		
		$("#pwd1").click(function(){
			$("#pwd1").css("border","");
		});
		
		$("#pwd2").click(function(){
			$("#pwd2").css("border","");
		});
		
		$("#email").click(function(){
			$("#email").css("border","");
		});
		
		$("#validate").click(function(){
			$("#validate").css("border","");
		});
		
		$("#pwd2").blur(function(){
			
			if(!$("#pwd1").val()==" "&&!$("#pwd2").val()==" "){
				if($("#pwd1").val()!= $("#pwd2").val()){
					$("#pwdMsg").html("<font color='red'>两次密码输入不一致哦...</font>");
					$("#pwd1").css("border","2px red solid");
					$("#pwd2").css("border","2px red solid");
					$("#sub1").attr("disabled",true);
				}else{
					$("#pwdMsg").html("<font color='green'>√</font>");
					$("#pwd1").css("border","");
					$("#pwd2").css("border","");
					$("#sub1").attr("disabled",false);
				}
			}else{
				$("#pwdMsg").html("<font color='red'>请输入密码...</font>");
				$("#pwd1").css("border","2px red solid");
				$("#pwd2").css("border","2px red solid");
				$("#sub1").attr("disabled",true);
			}
		});
		
		$("#email").blur(function(){
			//采用正则表示验证邮箱
			var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
			var flag = reg.test($("#email").val());
			
			if(flag){
				$("#btn1").attr("disabled",false);
				$("#emailMsg").html("<font color='green'>√</font>");
				$("#email").css("border","");
			}else{
				$("#btn1").attr("disabled",true);
				$("#email").css("border","2px red solid");
				$("#emailMsg").html("<font color='red'>邮箱格式输入不正确哦...</font>");
			}
		});
		
		$("#btn1").click(function(){
				var num = 60;
				$("#btn1").attr("disabled",true);
				$.post("/myStore/sendEmailServlet",{
					"email":$("#email").val()
				});
				var countdown = setInterval(function() {
					if(num > 0) {
						num--;
						$("#btn1").val("已发送"+"("+num+")") ;
					} else {
						//倒计时结束,则释放控件
						$("#btn1").attr("disabled",false);
						$("#btn1").val("获取验证码");
						clearInterval(countdown);
					}
				}, 1000);
		});
		
		$("#validate").blur(function(){
			$.post("/myStore/validateEmailServlet",{
				"validate":$("#validate").val()
			},function(responseText){
				if(responseText==1){
					$("#sub1").attr("disabled",false);
					$("#emailMsg").html("<font color='green'>√</font>");
					$("#validate").css("border","");
				}else{
					$("#validate").css("border","2px red solid");
					$("#emailMsg").html("<font color='red'>邮箱验证码输入不正确哦...</font>");
					$("#sub1").attr("disabled",true);
				}
			},"text");
		});
		
});