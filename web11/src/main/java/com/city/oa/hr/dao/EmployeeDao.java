package com.city.oa.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.oa.hr.model.EmployeeModel;


//员工的ORM实现类
public class EmployeeDao {
	
	public void insert(EmployeeModel em) throws Exception{
		
	}
	public void update(EmployeeModel em) throws Exception{
		
	}
	public void delete(EmployeeModel em) throws Exception{
	
	}
	
	public EmployeeModel selectById(String id) throws Exception{
		
		
		
		return null;
	}
	public List<EmployeeModel> selectByAll() throws Exception{
		List<EmployeeModel> list=new ArrayList<EmployeeModel>();
		String sql="select * from oa_employee";
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn=DriverManager.getConnection("jdbc:mysql://210.30.108.30:3312/cityoa","cityoa","cityoa");
		PreparedStatement ps=cn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			EmployeeModel em=new EmployeeModel();
			em.setId(rs.getString("EMPID"));
			em.setName(rs.getString("EMPNAME"));
			em.setSex(rs.getString("EMPSEX"));
			em.setAge(rs.getInt("AGE"));
			em.setSalary(rs.getDouble("SALARY"));
			list.add(em);
		}
		rs.close();
		ps.close();
		cn.close();
		
		
		return list;
	}


}
