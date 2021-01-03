<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.sql.*,com.city.oa.hr.dao.EmployeeDao,com.city.oa.hr.model.EmployeeModel"%>
<html>
<jsp:include page="../include/head.jsp"/>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
<jsp:include page="../include/header.jsp"/>
  
  <!-- Left side column. contains the logo and sidebar -->
  <jsp:include page="../include/aside.jsp"/>

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
                  <th>ID</th>
                  <th>姓名</th>
                  <th>性别</th>
                  <th>年龄</th>
                  <th>工资</th>
                </tr>
                </thead>
                <tbody>
                <%
                List<EmployeeModel> list=(List<EmployeeModel>)request.getAttribute("emplist");
                for(EmployeeModel em:list){
                %>
                <tr>
                	<td><%=em.getId() %></td>
                	<td><%=em.getName() %></td>
                	<td><%=em.getSex() %></td>
                	<td><%=em.getAge() %></td>
                	<td><%=em.getSalary() %></td>
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
  <jsp:include page="../include/footer.jsp"/>

  <!-- Control Sidebar -->
  <jsp:include page="../include/aside-2.jsp"/>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
<jsp:include page="../include/script.jsp"/>
</body>
</html>
