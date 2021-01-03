package com.city.erp.action;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ProductAddProcessAction
 */
@WebServlet("/add.do")
@MultipartConfig
public class ProductAddProcessAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection cn=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAddProcessAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cityerp?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=UTC","root","12345");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("PCODE");
		String name=request.getParameter("PNAME");
		String price=request.getParameter("PRICE");
		Part part = request.getPart("photo");
		String contentType=part.getContentType(); 
		String fileName=part.getSubmittedFileName(); 
		try {
			PreparedStatement ps=cn.prepareStatement("insert into Products (PCODE,PNAME,PRICE,PHOTO,PHOTOTYPE,PhotoFileName) values(?,?,?,?,?,?)");
			InputStream in=part.getInputStream(); 
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setString(3,price);
			ps.setBinaryStream(4,in, in.available());
			ps.setString(5,contentType);
			ps.setString(6,fileName);
			ps.executeUpdate();
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();
			out.println("插入成功");
		} catch (SQLException e) {
				// TODO Auto-generated catch block
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
