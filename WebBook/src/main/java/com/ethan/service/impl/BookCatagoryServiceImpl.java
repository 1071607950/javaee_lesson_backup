package com.ethan.service.impl;

import com.ethan.dao.BookCatagoryDao;
import com.ethan.factory.DaoFactory;
import com.ethan.model.AllEntitymodel;
import com.ethan.model.BookCatagorymodel;
import com.ethan.service.BookCatagoryService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangwenyu on 2018/12/9.
 */
public class BookCatagoryServiceImpl implements BookCatagoryService {
    BookCatagoryDao bookCatagoryDao = DaoFactory.getBookCatagoryDaoInstance();


    @Override
    public List<AllEntitymodel> allCatagory(BookCatagorymodel bookCatagory, int page, int rows) throws SQLException {
        List<AllEntitymodel> acr = null;
        acr = bookCatagoryDao.allCatagory(bookCatagory, page, rows);

        return acr;
    }

    @Override
    public int updateBC(BookCatagorymodel bookCatagory) throws SQLException {
        int code = 0;
        code = bookCatagoryDao.updateBC(bookCatagory);
        return code;
    }

    @Override
    public int deleteBC(String ids) throws SQLException {
        int code = 0;
        code = bookCatagoryDao.deleteBC(ids);
        return code;
    }

    @Override
    public int addBC(BookCatagorymodel bookCatagory) throws SQLException {
        int code = 0;
        code = bookCatagoryDao.addBC(bookCatagory);
        return code;
    }
}
