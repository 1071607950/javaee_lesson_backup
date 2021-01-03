package com.neusoft.erp.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainPageAction
 */
@WebServlet("/homemain.do")
public class MainPageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		Cookie[] cs=request.getCookies();
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		out.println("<h1>ERP系统主页<h1>");
		String userid=null; //Cookie中
		String userid01=null; //Session中
		String usertime=null;//Session中
		for(Cookie c:cs){
			out.println(c.getName()+"="+c.getValue()+"<br/>");
			if(c.getName().equals("userid")){
				userid=c.getValue();
			}
		}   
		//取得Session中保存的登录账号
		userid01=(String)session.getAttribute("userid");
		usertime=(String)session.getAttribute("usertime");

		
		out.println("Session中的账号:"+userid01+"<br/>");
		out.println("Cookie中的账号:"+userid+"<br/>");
		out.println("Session的保存选项:"+usertime+"天<br/>");
		out.println("<a href=\"logout.do\">注销用户</a><br/>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
