<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<%@include file="head.jsp" %>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
<%@include file="header.jsp" %>
  
  <!-- Left side column. contains the logo and sidebar -->
  <%@include file="aside.jsp" %>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Data Tables
        <small>advanced tables</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Tables</a></li>
        <li class="active">Data tables</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">信息列表</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example2" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>学号</th>
                  <th>姓名</th>
                  <th>性别</th>
                  <th>民族</th>
                  <th>血型</th>
                  <th>出生日期</th>
                </tr>
                </thead>
                <tbody>
                <%
                String url="jdbc:mysql://localhost:3306/java?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=UTC";
            	String root="root";
             	String rootpass="12345";
                Class.forName("com.mysql.jdbc.Driver");
     			Connection conn=DriverManager.getConnection(url,root,rootpass);
     			PreparedStatement ps=conn.prepareStatement("select * from students");                        
     			ResultSet rs=ps.executeQuery();
     			while(rs.next()){
     			%>
                <tr>
                  <td><%=rs.getString("number") %></td>
                  <td><%=rs.getString("name") %></td>
                  <td><%=rs.getString("gender") %></td>
                  <td><%=rs.getString("nation") %></td>
                  <td><%=rs.getString("bloodtype") %></td>
                  <td><%=rs.getString("birthday") %></td>
                </tr>
                <%} %>
                </tfoot>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->

          
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <%@include file="footer.jsp" %>

  <!-- Control Sidebar -->
  <%@include file="aside-2.jsp" %>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<%@include file="script.jsp" %>
<!-- page script -->

</body>
</html>
