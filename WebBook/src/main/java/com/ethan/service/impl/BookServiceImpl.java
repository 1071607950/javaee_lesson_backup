package com.ethan.service.impl;

import com.ethan.dao.BookDao;
import com.ethan.factory.DaoFactory;
import com.ethan.model.AllEntitymodel;
import com.ethan.model.Bookmodel;
import com.ethan.service.BookService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangwenyu on 2018/12/6.
 */
public class BookServiceImpl implements BookService {
    BookDao bookDao = DaoFactory.getBookDaoInstance();

    public List<AllEntitymodel> allBook(Bookmodel book, int page, int rows) throws SQLException {
        List<AllEntitymodel> books = null;
        books = bookDao.allBook(book, page, rows);
        return books;
    }

    @Override
    public int addBook(Bookmodel book) throws SQLException {
        int code = 0;
        code = bookDao.addBook(book);

        return code;
    }

    @Override
    public List<Bookmodel> findBook(Bookmodel book) throws SQLException {
        List<Bookmodel> books = null;
        books = bookDao.findBook(book);
        return books;

    }

    @Override
    public int bookCount(Bookmodel book) throws SQLException {
        int code = 0;
        code = bookDao.bookCount(book);


        return code;
    }

    @Override
    public int update(Bookmodel book) throws SQLException {
        int code = 0;
        code = bookDao.update(book);

        return code;
    }

    @Override
    public int deleteBook(String ids) throws SQLException {
        int code = 0;
        code = bookDao.deleteBook(ids);

        return code;
    }

    @Override
    public int borrowbBook(Bookmodel book, int a) throws SQLException {
        int code = 0;
        code = bookDao.borrowbBook(book, a);
        return code;
    }
}
