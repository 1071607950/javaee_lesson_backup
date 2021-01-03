package com.ethan.dao;

import java.sql.SQLException;
import java.util.List;

import com.ethan.model.AllEntitymodel;
import com.ethan.model.BorrowCardmodel;

/**
 * Created by zhangwenyu on 2018/12/10.
 */
public interface BorrowCardDao {
    public List<AllEntitymodel> allBorrowCard(BorrowCardmodel borrowCard, int page, int rows) throws SQLException;

    public int updateBC(BorrowCardmodel borrowCard) throws SQLException;

    public int deleteBC(String ids) throws SQLException;

    public int addBC(BorrowCardmodel borrowCard) throws SQLException;

    public int borrowbBook(BorrowCardmodel borrowCard, int a) throws SQLException;

    public int bcCount() throws SQLException;
}
