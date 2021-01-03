package com.city.erp.servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductShowServlet
 */
@WebServlet("/product/show.do")
public class ProductShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	private Connection cn=null;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://210.30.108.30:3312/cityerp","cityerp","cityerp");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try{
			cn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String PCODE=request.getParameter("PCODE");
			String sql="select * from Product where PCODE=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, PCODE);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<h1>SAP ERP 管理系统<h1>");
				out.println("<h2>查看产品<h2>");
				out.println("产品名称:"+rs.getString("PNAME")+"<br/>");
				out.println("产品单价:"+rs.getDouble("PRICE")+"<br/>");
				out.println("生产日期:"+rs.getDate("PDATE")+"<br/>");
				
				out.println("产品图片:<img src='showphoto.do?PCODE="+PCODE+"'  ><br/>");
				out.flush();
				out.close();
			
			}
			rs.close();
			ps.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
