package com.city.office.document.factory;

import com.city.office.document.Dao.INewsDao;
import com.city.office.document.Dao.impl.NewsDaoImpl;

public class DaoFactory {
	 public static INewsDao createNewsDao(){
		   return new NewsDaoImpl();
	 }
}
