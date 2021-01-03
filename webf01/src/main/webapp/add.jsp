<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>增加产品</h1>
<form action="add.do" method="post" enctype="multipart/form-data">
产品编码:<input type="text" name="PCODE" ><br/>
产品名称:<input type="text" name="PNAME" ><br/>
产品单价:<input type="text" name="PRICE" ><br/>
产品照片：<input type="file" name="photo" /><br/>
<input type="submit" value="提交" ><br/>

</form>
</body>
</html>