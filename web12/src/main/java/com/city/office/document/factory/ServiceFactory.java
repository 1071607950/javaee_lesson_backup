package com.city.office.document.factory;

import com.city.office.document.service.INewsService;
import com.city.office.document.service.impl.NewsServiceImpl;

public class ServiceFactory {
	public static INewsService createNewsService(){
		 return new NewsServiceImpl();
	}
}
