package com.iscc.store.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于验证前天验证码输入是否正确
 */
@WebServlet("/validateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ValidateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charst=utf-8");

		String validate = request.getParameter("validate");

		// 需要强制转换session的类型
		String validateCode = (String) request.getSession().getAttribute("validateCode");

		//1:表示正确
		//0:表示错误
		//00:表示验证码时效
		if (validateCode != null) {
			if (validate.equals(validateCode)) {
				response.getWriter().write("1");
			} else {
				response.getWriter().write("0");
			}
		}else {
			response.getWriter().write("2");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
