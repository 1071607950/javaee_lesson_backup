package com.city.office.document.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.city.office.document.Dao.INewsDao;
import com.city.office.document.factory.DaoFactory;
import com.city.office.document.model.NewsModel;

public class test {
	public static void main(String[] args) {
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		INewsDao IND=DaoFactory.createNewsDao();
		
		NewsModel nm=new NewsModel();
		nm.setSubject("这里是标题1");
		nm.setContent("这里是内容1");
		nm.setNewsDate(dateFormat.format(new Date()));
		nm.setAuthor("张三");
		NewsModel nm1=new NewsModel();
		nm1.setSubject("这里是标题2");
		nm1.setContent("这里是内容2");
		nm1.setNewsDate(dateFormat.format(new Date()));
		nm1.setAuthor("李四");
		try {
			if(IND.insert(nm)>0) {
				System.out.println("1插入成功");
			}else {
				System.out.println("1插入失败");
			}
			if(IND.insert(nm1)>0) {
				System.out.println("2插入成功");
			}else {
				System.out.println("2插入失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//查询全部
		try {
			List<NewsModel> list=IND.selectListByAll();
			System.out.println("查询所有信息");
	        for (int i = 0; i < list.size(); i++) {
	            System.out.print("	编号:"+list.get(i).getNewsNo());
	            System.out.print("	标题:"+list.get(i).getSubject());
	            System.out.print("	内容:"+list.get(i).getContent());
	            System.out.print("	发布日期:"+list.get(i).getNewsDate());
	            System.out.print("	起草人:"+list.get(i).getAuthor());
	            System.out.println();
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		//查询ID
		try {
			NewsModel nmno=IND.selectByNo(1);
			System.out.println("查询编号1的信息");
		    System.out.print("	编号:"+nmno.getNewsNo());
            System.out.print("	标题:"+nmno.getSubject());
            System.out.print("	内容:"+nmno.getContent());
            System.out.print("	发布日期:"+nmno.getNewsDate());
            System.out.print("	起草人:"+nmno.getAuthor());
            System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//改编号1的信息
		try {
			NewsModel nmno=IND.selectByNo(1);
			nmno.setSubject("这是新标题");
			nmno.setContent("这是新内容");
			nmno.setNewsDate(dateFormat.format(new Date()));
			nmno.setAuthor("王五");
			if(IND.update(nmno)>0) {
				System.out.println("修改成功");
			}else {
				System.out.println("修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//查询全部
		try {
			List<NewsModel> list=IND.selectListByAll();
			System.out.println("查询所有信息");
	        for (int i = 0; i < list.size(); i++) {
	            System.out.print("	编号:"+list.get(i).getNewsNo());
	            System.out.print("	标题:"+list.get(i).getSubject());
	            System.out.print("	内容:"+list.get(i).getContent());
	            System.out.print("	发布日期:"+list.get(i).getNewsDate());
	            System.out.print("	起草人:"+list.get(i).getAuthor());
	            System.out.println();
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		//删除编号1
		try {
			NewsModel nmno=IND.selectByNo(1);
			if(IND.delete(nmno)>0) {
				System.out.println("删除成功");
			}else {
				System.out.println("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//查询全部
		try {
			List<NewsModel> list=IND.selectListByAll();
			System.out.println("查询所有信息");
	        for (int i = 0; i < list.size(); i++) {
	            System.out.print("	编号:"+list.get(i).getNewsNo());
	            System.out.print("	标题:"+list.get(i).getSubject());
	            System.out.print("	内容:"+list.get(i).getContent());
	            System.out.print("	发布日期:"+list.get(i).getNewsDate());
	            System.out.print("	起草人:"+list.get(i).getAuthor());
	            System.out.println();
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
