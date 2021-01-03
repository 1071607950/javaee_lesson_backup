package com.ethan.dao;

import java.sql.SQLException;
import java.util.List;

import com.ethan.model.AllEntitymodel;
import com.ethan.model.Borrowmodel;

/**
 * Created by zhangwenyu on 2018/12/10.
 */
public interface BorrowDao {


    /**
     * @param borrow
     * @param page
     * @param rows
     * @return
     * @throws SQLException
     */
    public List<AllEntitymodel> allBorrow(Borrowmodel borrow, int page, int rows) throws SQLException;

    public List<AllEntitymodel> notDueBorrow(Borrowmodel borrow, int page, int rows) throws SQLException;

    /**
     * @param ids
     * @return
     * @throws SQLException
     */
    public int deleteBorrow(String ids) throws SQLException;

    /**
     * @param borrow
     * @return
     * @throws SQLException
     */
    public int updateBorrow(Borrowmodel borrow) throws SQLException;

    public int addBorrow(Borrowmodel borrow) throws SQLException;

    public int dueBorrow(Borrowmodel borrow) throws SQLException;

    public Borrowmodel findBorrow(Borrowmodel borrow) throws SQLException;

    public AllEntitymodel findUserBorrow(Borrowmodel borrow) throws SQLException;

    public AllEntitymodel findUserDueBorrow(Borrowmodel borrow) throws SQLException;

}
