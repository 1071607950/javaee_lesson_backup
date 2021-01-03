package com.city.office.document.service.impl;

import java.util.List;

import com.city.office.document.Dao.impl.NewsDaoImpl;
import com.city.office.document.model.NewsModel;
import com.city.office.document.service.INewsService;

public class NewsServiceImpl implements INewsService{
	public void add(NewsModel nm) throws Exception{
		
	}
	public void modify(NewsModel em) throws Exception{
		
	}
	public void delete(NewsModel em) throws Exception{
		
	}
	public boolean validate(String id,String password) throws Exception{
		return false;
		
	}
	public void changePassword(String id,String password) throws Exception{
		
	}
	public List<NewsModel> selectListByAll() throws Exception{
		return new NewsDaoImpl().selectListByAll();
	}
	public NewsModel selectByNo(int no) throws Exception{
		return new NewsDaoImpl().selectByNo(no);
	}
}
