<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>增加员工</h1>
<form action="add.do" method="post">
产品编码:<input type="text" name="PCODE" ><br/>
产品名称:<input type="text" name="PNAME" ><br/>
产品标准:<input type="radio" name="STANDARD" value="国标" >国标
    	<input type="radio" name="STANDARD" value="美标" >美标<br/>
产品用途:
<input type="checkbox" name="USAGES" value="食品" >食品
<input type="checkbox" name="USAGES" value="化工" >化工
<input type="checkbox" name="USAGES" value="机械" >机械
<input type="checkbox" name="USAGES" value="电子" >电子
<input type="checkbox" name="USAGES" value="材料" >材料
<br/>
产品单价:<input type="text" name="PRICE" ><br/>
<input type="submit" value="提交" ><br/>

</form>
</body>
</html>