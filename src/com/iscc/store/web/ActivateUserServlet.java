package com.iscc.store.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iscc.store.util.SendEmail;

@WebServlet("/activateUserServlet")
public class ActivateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ActivateUserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 获取到前台的激活码
		String code = request.getParameter("code");
		String email = request.getParameter("email");

		// 直接调用发送邮件功能,发送激活链接
		SendEmail.send(email, code, 2);
		// 清空session中的数据
		request.getSession().invalidate();
		// 然后重定向到主页面
		response.sendRedirect("/myStore/index.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
