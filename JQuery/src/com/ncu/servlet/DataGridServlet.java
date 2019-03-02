package com.ncu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncu.bean.Produce;

/**
 * Servlet implementation class Login
 */
@WebServlet("/datagrid.do")
public class DataGridServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Produce p1 = new Produce("11","12","13","14","15","16");
		Produce p2 = new Produce("21","22","23","24","25","26");
		Produce p3 = new Produce("31","32","33","34","35","36");
		Produce p4 = new Produce("41","42","43","44","45","46");
		Produce p5 = new Produce("51","52","53","54","55","56");
		List l1 = new ArrayList();
		l1.add(p1);
		l1.add(p2);
		l1.add(p3);
		l1.add(p4);
		l1.add(p5);
		
	}

}
