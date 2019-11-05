package com.iscc.store.web;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iscc.store.util.SendEmail;

@WebServlet("/sendEmailServlet")
public class SendEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SendEmailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");

		System.out.println(email);

		// 定义一个字符串来存储验证码
		String code = "";

		// 生成验证码
		String[] arr = { "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "h", "k", "m", "n", "p", "q",
				"r", "s", "t", "u", "v", "w", "x", "y", "A", "B", "C", "D", "E", "F", "G", "H", "K", "L", "M", "N", "O",
				"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		Random ran = new Random();
		for (int i = 0; i < 4; i++) {
			int j = ran.nextInt(51);
			code += arr[j];// 将随机生成的验证码赋值给code
		}
		System.out.println(code);

		// 将验证码存入到session中,用于判断用户输入的验证码和发送给用户的验证码是否一致
		HttpSession session = request.getSession();
		session.setAttribute("code", code);
		// 设置验证码的时效(5min)
		// 设置session的时效的单位为:秒
		session.setMaxInactiveInterval(60 * 5);

		
		SendEmail.send(email, code, 1);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
