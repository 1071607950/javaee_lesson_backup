package com.ethan.service.impl;

import com.ethan.dao.BorrowLevelDao;
import com.ethan.factory.DaoFactory;
import com.ethan.model.BorrowLevelmodel;
import com.ethan.service.BorrowLevelService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangwenyu on 2018/12/10.
 */
public class BorrowLevelServiceImpl implements BorrowLevelService {
    BorrowLevelDao borrowLevelDao = DaoFactory.getBorrowLevelDaoInstance();

    @Override
    public List<BorrowLevelmodel> allBorroeLevel(BorrowLevelmodel borrowLevel, int page, int rows) throws SQLException {
        List<BorrowLevelmodel> book_catagory_rooms = null;
        book_catagory_rooms = borrowLevelDao.allBorroeLevel(borrowLevel, page, rows);


        return book_catagory_rooms;
    }
}
