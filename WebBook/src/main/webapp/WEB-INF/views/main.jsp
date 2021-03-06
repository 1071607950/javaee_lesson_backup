<%@ page import="com.ethan.model.Usermodel" %>
<%@ page %><%--
  Created by IntelliJ IDEA.
  User: Ethan
  Date: 2018/12/3
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书馆管理系统</title>
    <%
    	// 权限验证
            if(session.getAttribute("currentUser")==null){
                response.sendRedirect("index.jsp");
                return;
            }
            Usermodel currentUser = (Usermodel) session.getAttribute("currentUser");
            if (currentUser.getUser_level().equals("读者")) {
                request.getRequestDispatcher("WEB-INF/views/reader.jsp").forward(request, response);
            }
    %>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/jquery-easyui-1.6.10/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/jquery-easyui-1.6.10/themes/icon.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/jquery-easyui-1.6.10/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/jquery-easyui-1.6.10/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/jquery-easyui-1.6.10/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/default.js"></script>
<script type="text/javascript">
    setInterval("time.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());", 1000);
    function exit() {
        $.messager.confirm("系统提示", "您确认要注销登录吗？", function (r) {
            if (r) {
                location.replace("exit");
            }
        });
    }
</script>
</head>
<body class="easyui-layout">
<div region="north"
     style="height: 90px;background-image: url(${pageContext.request.contextPath}/resources/images/main.png);background-repeat: no-repeat;width: 100%;background-color: #bfc6d8 ">

    <%--<div align="left" style="height: 100%"><img src="resources/images/main.png">-color: #E0EDFF</div>--%>
    <div style=" float: right;padding-right: 20px;">
        <div>当前时间：<span style="color: blue" id="time"></span></div>
        <%--<div id="time">当前时间：</div>--%>
        <p>

        </p>
        <div style="padding-top: 30px" align="right">
            <font color="red">${currentUser.user_name }</font>
            ,欢迎您！
            <a href="/WebBook/tologin.do" style="background-color: white" onclick="exit()"><font color="#0E2D5F">注销</font></a>
        </div>
    </div>
</div>
<div data-options="region: 'center'" >
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
        <div title="首页" >
        <div align="center" style="padding-top: 100px;"><font color="red" size="10">欢迎使用图书馆管理系统</font></div>
        </div>
    </div>
</div>

<div region="west" style="width: 150px;" title="图书馆管理中心" split="true">
    <div id="nav" class="easyui-accordion" fit="true" border="false">

    </div>
</div>
<%--<div region="south" style="height: 25px;" align="center">版权所有<a href="#"></a></div>--%>
</body>
</html>
