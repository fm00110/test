package com.ncu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String validateCode = request.getParameter("code");
		HttpSession session = request.getSession();
		String randStr = (String) session.getAttribute("randStr");
		if(randStr.equals(validateCode)){
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("/first.jsp").forward(request, response);
		}
	}

}
