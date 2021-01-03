package com.city.oa.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EmployeeListAction
 */
@WebServlet(
		urlPatterns = { "/employee/list.do" }, 
		initParams = { 
				@WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"), 
				@WebInitParam(name = "url", value = "jdbc:mysql://210.30.108.30:3312/cityoa")
		})
public class EmployeeListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	private Connection cn=null;
	
	public void init(ServletConfig config) throws ServletException {
		String driver=config.getInitParameter("driver");
		String url=config.getInitParameter("url");
		try {
			Class.forName(driver);
			cn=DriverManager.getConnection(url,"cityoa","cityoa");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		super.destroy();
		try {
			if(cn!=null&&(!cn.isClosed()))
			{
				cn.close();
				cn=null;
			}
		}catch(Exception e) {
			System.out.println("Destroy Error:"+e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		try {
			String sql="select * from oa_employee";
			PreparedStatement ps=cn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("<td>账号</td><td>姓名</td><td>年龄</td><td>工资</td>");
			out.println("</tr>");
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getString("EMPID")+"</td><td>"+rs.getString("EMPNAME")+"</td><td>"+rs.getString("AGE")+"</td><td>"+rs.getString("SALARY")+"</td><td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}catch(Exception e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
