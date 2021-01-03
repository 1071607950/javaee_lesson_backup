<%@ page import="java.util.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id=(String)session.getAttribute("id");
	out.println("<h1>OA 系统主页</h1>");
	out.println("<hr/>");
	out.println("登录账号："+id+"<br/>");
	out.println("当前用户ID列表：");
	List<String> userlist=(List<String>)application.getAttribute("userlist");	
	for(String user:userlist){
		out.println(user);
	}
	out.println("<hr/>");
	
%>
<a href="./loginout.jsp"></a>
</body>
</html>