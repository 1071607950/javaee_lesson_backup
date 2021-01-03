package com.city.office.document.Dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.office.document.Dao.INewsDao;
import com.city.office.document.model.NewsModel;
import com.city.office.factory.ConnectionFactory;

public class NewsDaoImpl implements INewsDao{
	public int insert(NewsModel nm) throws Exception{
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement("insert into OA_News (Subject,Content,NewsDate,Author) values(?,?,?,?)");
		ps.setString(1,nm.getSubject());
		ps.setString(2,nm.getContent());
		ps.setString(3,nm.getNewsDate());
		ps.setString(4,nm.getAuthor());
		int rs=ps.executeUpdate();
		ps.close();
		cn.close();
		return rs;
	}
	public int update(NewsModel nm) throws Exception{
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement("update OA_News set Subject=?,Content=?,NewsDate=?,Author=?  where NewsNo=?");
		ps.setString(1,nm.getSubject());
		ps.setString(2,nm.getContent());
		ps.setString(3,nm.getNewsDate());
		ps.setString(4,nm.getAuthor());
		ps.setInt(5,nm.getNewsNo());
		int rs=ps.executeUpdate();
		ps.close();
		cn.close();
		return rs;
	}
	public int delete(NewsModel nm) throws Exception{
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement("Delete from OA_News where NewsNo=?");
		ps.setInt(1,nm.getNewsNo());
		int rs=ps.executeUpdate();
		ps.close();
		cn.close();
		return rs;
	}
	public NewsModel selectByNo(int no) throws Exception{
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement("select * from OA_News where NewsNo=?");
		ps.setInt(1, no);
		ResultSet rs=ps.executeQuery();
		NewsModel nm=new NewsModel();
		nm.setNewsNo(no);
		if(rs.next()){
			nm.setSubject(rs.getString("Subject"));
			nm.setContent(rs.getString("Content"));
			nm.setNewsDate(rs.getString("NewsDate"));
			nm.setAuthor(rs.getString("Author"));
		}
		rs.close();
		ps.close();
		cn.close();
		return nm;
	}
	public List<NewsModel> selectListByAll() throws Exception{
		List<NewsModel> list=new ArrayList<NewsModel>();
		String sql="select * from OA_News";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			NewsModel nm=new NewsModel();
			nm.setNewsNo(rs.getInt("NewsNo"));
			nm.setSubject(rs.getString("Subject"));
			nm.setContent(rs.getString("Content"));
			nm.setNewsDate(rs.getString("NewsDate"));
			nm.setAuthor(rs.getString("Author"));
			list.add(nm);
		}
		rs.close();
		ps.close();
		cn.close();
		return list;
	}
}
