package com.ethan.service;

import java.sql.SQLException;
import java.util.List;

import com.ethan.model.BorrowLevelmodel;

/**
 * Created by zhangwenyu on 2018/12/10.
 */
public interface BorrowLevelService {
    /**
     * @param borrowLevel
     * @param page
     * @param rows
     * @return
     * @throws SQLException
     */
    public List<BorrowLevelmodel> allBorroeLevel(BorrowLevelmodel borrowLevel, int page, int rows) throws SQLException;
}
