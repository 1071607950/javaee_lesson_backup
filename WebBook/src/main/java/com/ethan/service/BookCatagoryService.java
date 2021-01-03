package com.ethan.service;

import java.sql.SQLException;
import java.util.List;

import com.ethan.model.AllEntitymodel;
import com.ethan.model.BookCatagorymodel;

/**
 * Created by zhangwenyu on 2018/12/9.
 */
public interface BookCatagoryService {

    /**
     * Room与catagory级联查询
     *
     * @param page
     * @param rows
     * @return
     * @throws SQLException
     */
    public List<AllEntitymodel> allCatagory(BookCatagorymodel bookCatagory, int page, int rows) throws SQLException;

    /**
     * updateBC 更新BookCatagory
     *
     * @param bookCatagory
     * @return
     * @throws SQLException
     */
    public int updateBC(BookCatagorymodel bookCatagory) throws SQLException;


    /**
     * deleteBC 删除BookCatagory
     *
     * @param ids
     * @return
     * @throws SQLException
     */
    public int deleteBC(String ids) throws SQLException;

    /**
     * addBC 插入BookCatagory
     *
     * @param bookCatagory
     * @return
     * @throws SQLException
     */
    public int addBC(BookCatagorymodel bookCatagory) throws SQLException;
}
