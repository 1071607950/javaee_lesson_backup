package com.city.office.document.service;

import java.util.List;

import com.city.office.document.model.NewsModel;

public interface INewsService {
	public void add(NewsModel nm) throws Exception;
	public void modify(NewsModel em) throws Exception;
	public void delete(NewsModel em) throws Exception;
	public boolean validate(String id,String password) throws Exception;
	public void changePassword(String id,String password) throws Exception;
	public List<NewsModel> selectListByAll() throws Exception;
	public NewsModel selectByNo(int no) throws Exception;
}
