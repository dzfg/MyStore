
package com.iscc.store.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 根据邮箱来查找用户
 */
@WebServlet("/FindUserByEmail")
public class FindUserByEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindUserByEmail() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		String email = request.getParameter("email");
//		
//		Service service = new IUserService();
		
		
		//1表示存在
		//0表示不存在
//		if(user!=null) {
//			response.getWriter().write("1");
//		}else {
//			response.getWriter().write("0");
//		}
		
		
		
		
		
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
