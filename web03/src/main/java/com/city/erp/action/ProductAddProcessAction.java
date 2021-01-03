package com.city.erp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductAddProcessAction
 */
@WebServlet({ "/ProductAddProcessAction", "/product/add.do" })
public class ProductAddProcessAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection cn=null;
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
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/CITYERP?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=UTC","root","12345");
			
		}
		catch(Exception e){
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
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out=response.getWriter();
				
				String sql="insert into Product (PCODE,PNAME,STANDARD,USAGES,PRICE) values (?,?,?,?,?)";
				try{
					//取得请求行方法
					String url=request.getRequestURL().toString();
					String uri=request.getRequestURI();
					out.println("URL="+url+"<br/>");
					out.println("URI="+uri+"<br/>");
					//取得请求头方法
					String btype=request.getHeader("User-Agent");
					out.println("浏览器类型="+btype+"<br/>");
					String ip=request.getHeader("Host");
					out.println("IP="+ip+"<br/>");
					
					//取得请求体数据方法
					String PCODE=request.getParameter("PCODE");
					String PNAME=request.getParameter("PNAME");
					String STANDARD=request.getParameter("STANDARD");
					String[] USAGES=request.getParameterValues("USAGES");
					String PRICE=request.getParameter("PRICE");
					String USAGESS="";
					for(int i=0;i<USAGES.length-1;i++)
					{
						USAGESS=USAGESS+USAGES[i]+";";
					}
					USAGESS=USAGESS+USAGES[USAGES.length-1];
					//执行增加员工方法			
					PreparedStatement ps=cn.prepareStatement(sql);
					ps.setString(1, new String(PCODE.getBytes("ISO-8859-1"),"utf-8"));
					ps.setString(2,new String(PNAME.getBytes("ISO-8859-1"),"utf-8"));
					ps.setString(3,new String(STANDARD.getBytes("ISO-8859-1"),"utf-8"));
					ps.setString(4,new String(USAGESS.getBytes("ISO-8859-1"),"utf-8"));
					ps.setString(5, new String(PRICE.getBytes("ISO-8859-1"),"utf-8"));
					ps.executeUpdate();
					ps.close();
					out.print("<h2>增加员工成功！！");
				}
				catch(Exception e){
					e.printStackTrace();
					out.print("<h2>增加员工失败。原因:"+e.getMessage());
				}
				out.flush();
				out.close();
	}

}
