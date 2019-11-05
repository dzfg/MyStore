package com.iscc.store.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于验证输入的邮箱验证码是否正确
 */
@WebServlet("/validateEmailServlet")
public class ValidateEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ValidateEmailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 拿到前台传过来的参数
		String validate = request.getParameter("validate");

		// 获取到session中的验证码
		String code = (String) request.getSession().getAttribute("code");

		// 1表示验证码正确
		// 0表示验证码错误
		if (validate.equals(code)) {
			response.getWriter().write("1");
		} else {
			response.getWriter().write("0");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
