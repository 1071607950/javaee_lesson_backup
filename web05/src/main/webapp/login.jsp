<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>用户登录</h1>
<form action="login.do" method="post">
账号:<input type="text" name="userid"><br/>
密码:<input type="password" name="password"><br/>
账号保存: <input type="radio" name="time" value="1" >一天
<input type="radio" name="time" value="2" >两天
<input type="radio" name="time" value="3" >三天
<br/>
<input type="submit" value="提交"><br/>
</form>
</body>
</html>