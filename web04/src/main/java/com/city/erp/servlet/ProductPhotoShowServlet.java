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
 * Servlet implementation class ProductPhotoShowServlet
 */
@WebServlet("/product/showphoto.do")
public class ProductPhotoShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
	 * 
	 */
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ProductPhotoShowServlet() {
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
			String id=request.getParameter("PCODE");
			String sql="select PHOTOContentType,PHOTO from Product where PCODE=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String contenttype=rs.getString("PhotoContentType");
				response.setContentType(contenttype);
				OutputStream out=response.getOutputStream();
				InputStream in=rs.getBinaryStream("PHOTO");
				int data=0;
				while( (data=in.read())!=-1){
					out.write(data);
				}
				out.flush();
				out.close();
				in.close();
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
		doGet(request, response);
	}


}
