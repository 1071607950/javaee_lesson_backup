package com.neusoft.erp.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录处理Servlet
 */
@WebServlet("/login.do")
public class UserLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection cn=null;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://210.30.108.30:3312/cityoa","cityoa","cityoa");
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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String id=request.getParameter("userid");
		String password=request.getParameter("password");
		String time=request.getParameter("time");
		if(id==null|| id.trim().equals("")){
			response.sendRedirect("login.jsp");
		}
		else if(password==null|| password.trim().equals("")){
			response.sendRedirect("login.jsp");
		}
		else{
			String userid=request.getParameter("userid");
			String userpassword=request.getParameter("password");
			String sql="select * from oa_employee where EMPID=? and EMPPassword=?";
			try {
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setString(1, userid);
				ps.setString(2, userpassword);
				ResultSet rs=ps.executeQuery();
				if(!rs.next()){
					response.sendRedirect("login.jsp");
				}else {
					//使用Cookie保存登录ID
					//创建Cookie对象
					Cookie userCookie=new Cookie("userid",id);
					Cookie passwordCookie=new Cookie("password",password);
					//设置Cookie对象的生存周期
					if(time=="1"){
						userCookie.setMaxAge(1*24*60*60);
					}else if(time =="2") {
						userCookie.setMaxAge(2*24*60*60);
					}else if(time=="3") {
						userCookie.setMaxAge(3*24*60*60);
					}
					//发送给客户端
					response.addCookie(userCookie);
					response.addCookie(passwordCookie);
					//******************
					//使用Session实现会话跟踪
					//*******************
					HttpSession session=request.getSession();
					session.setMaxInactiveInterval(600);
					session.setAttribute("userid", id);
					session.setAttribute("usertime", time);
					
					response.sendRedirect("homemain.do");
				}
				rs.close();
				ps.close();
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
