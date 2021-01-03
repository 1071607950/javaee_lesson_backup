package com.ethan.service.impl;

import com.ethan.dao.BorrowDao;
import com.ethan.factory.DaoFactory;
import com.ethan.model.AllEntitymodel;
import com.ethan.model.Borrowmodel;
import com.ethan.service.BorrowService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangwenyu on 2018/12/10.
 */
public class BorrowServiceImpl implements BorrowService {
    BorrowDao borrowDao = DaoFactory.getBorrowDaoInstance();

    @Override
    public List<AllEntitymodel> allBorrow(Borrowmodel borrow, int page, int rows) throws SQLException {
        List<AllEntitymodel> borrows = null;
        borrows = borrowDao.allBorrow(borrow, page, rows);

        return borrows;
    }

    @Override
    public List<AllEntitymodel> notDueBorrow(Borrowmodel borrow, int page, int rows) throws SQLException {
        List<AllEntitymodel> borrows = null;
        borrows = borrowDao.notDueBorrow(borrow, page, rows);

        return borrows;
    }

    @Override
    public int deleteBorrow(String ids) throws SQLException {
        int code = 0;
        code = borrowDao.deleteBorrow(ids);
        return code;
    }

    @Override
    public int updateBorrow(Borrowmodel borrow) throws SQLException {
        int code = 0;
        code = borrowDao.updateBorrow(borrow);
        return code;
    }

    @Override
    public int addBorrow(Borrowmodel borrow) throws SQLException {
        int code = 0;
        code = borrowDao.addBorrow(borrow);
        return code;
    }

    @Override
    public Borrowmodel findBorrow(Borrowmodel borrow) throws SQLException {
        Borrowmodel borrowResult = null;
        borrowResult = borrowDao.findBorrow(borrow);

        return borrowResult;
    }

    @Override
    public int dueBorrow(Borrowmodel borrow) throws SQLException {
        int code = 0;
        code = borrowDao.dueBorrow(borrow);

        return code;
    }

    @Override
    public AllEntitymodel findUserBorrow(Borrowmodel borrow) throws SQLException {
        AllEntitymodel allEntity = null;
        allEntity = borrowDao.findUserBorrow(borrow);

        return allEntity;
    }

    @Override
    public AllEntitymodel findUserDueBorrow(Borrowmodel borrow) throws SQLException {
        AllEntitymodel allEntity = null;
        allEntity = borrowDao.findUserDueBorrow(borrow);

        return allEntity;
    }

}
