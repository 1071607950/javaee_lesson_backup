package com.city.office.document.Dao;
import java.util.*;

import com.city.office.document.model.NewsModel;

//新闻的ORM实现类
public interface INewsDao {
	public int insert(NewsModel nm) throws Exception;
	public int update(NewsModel nm) throws Exception;
	public int delete(NewsModel nm) throws Exception;
	public NewsModel selectByNo(int no) throws Exception;
	public List<NewsModel> selectListByAll() throws Exception;


}
