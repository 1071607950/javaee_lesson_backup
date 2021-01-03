package com.ethan.service;

import java.sql.SQLException;
import java.util.List;

import com.ethan.model.AllEntitymodel;
import com.ethan.model.Bookmodel;

/**
 * Created by zhangwenyu on 2018/12/6.
 */
public interface BookService {
    /**
     * @param page
     * @param rows
     * @return
     * @throws SQLException
     */
    public List<AllEntitymodel> allBook(Bookmodel book, int page, int rows) throws SQLException;

    /**
     * @param book
     * @return
     * @throws SQLException
     */
    public int addBook(Bookmodel book) throws SQLException;


    /**
     * @param book
     * @return
     * @throws SQLException
     */
    public List<Bookmodel> findBook(Bookmodel book) throws SQLException;

    /**
     * @param book
     * @return
     * @throws SQLException
     */
    public int bookCount(Bookmodel book) throws SQLException;

    /**
     * 更新
     *
     * @param book
     * @return
     * @throws SQLException
     */
    public int update(Bookmodel book) throws SQLException;


    /**
     * 删除
     * @return
     * @throws SQLException
     */
    public int deleteBook(String ids) throws SQLException;

    public int borrowbBook(Bookmodel book, int a) throws SQLException;
}
