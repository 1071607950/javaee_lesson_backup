package com.ethan.service.impl;

import com.ethan.dao.BorrowCardDao;
import com.ethan.factory.DaoFactory;
import com.ethan.model.AllEntitymodel;
import com.ethan.model.BorrowCardmodel;
import com.ethan.service.BorrowCardService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangwenyu on 2018/12/10.
 */
public class BorrowCardServiceImpl implements BorrowCardService {
    BorrowCardDao borrowCardDao = DaoFactory.getBorrowCardDaoInstance();

    @Override
    public List<AllEntitymodel> allBorrowCard(BorrowCardmodel borrowCard, int page, int rows) throws SQLException {
        List<AllEntitymodel> book_catagory_rooms = null;
        book_catagory_rooms = borrowCardDao.allBorrowCard(borrowCard, page, rows);
        return book_catagory_rooms;
    }

    @Override
    public int updateBC(BorrowCardmodel borrowCard) throws SQLException {
        int code = 0;
        code = borrowCardDao.updateBC(borrowCard);
        return code;
    }

    @Override
    public int deleteBC(String ids) throws SQLException {
        int code = 0;
        code = borrowCardDao.deleteBC(ids);
        return code;
    }

    @Override
    public int addBC(BorrowCardmodel borrowCard) throws SQLException {
        int code = 0;
        code = borrowCardDao.addBC(borrowCard);
        return code;
    }

    @Override
    public int borrowbBook(BorrowCardmodel borrowCard, int a) throws SQLException {
        int code = 0;
        code = borrowCardDao.borrowbBook(borrowCard, a);
        return code;
    }

    @Override
    public int bcCount() throws SQLException {
        int code = 0;
        code = borrowCardDao.bcCount();
        return code;
    }
}
