package com.ethan.dao;

import java.sql.SQLException;
import java.util.List;

import com.ethan.model.AllEntitymodel;
import com.ethan.model.BorrowLevelmodel;

/**
 * Created by zhangwenyu on 2018/12/10.
 */
public interface BorrowLevelDao {

    /**
     * @param borrowLevel
     * @param page
     * @param rows
     * @return
     * @throws SQLException
     */
    public List<BorrowLevelmodel> allBorroeLevel(BorrowLevelmodel borrowLevel, int page, int rows) throws SQLException;

}
