package com.ethan.service.impl;

import com.ethan.dao.BookRoomDao;
import com.ethan.factory.DaoFactory;
import com.ethan.model.BookRoommodel;
import com.ethan.service.BookRoomService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangwenyu on 2018/12/9.
 */
public class BookRoomServiceImpl implements BookRoomService {
    BookRoomDao bookRoomDao = DaoFactory.getBookRoomDaoInstance();

    @Override
    public List<BookRoommodel> allBookRoom(BookRoommodel bookRoom, int page, int rows) throws SQLException {
        List<BookRoommodel> bookRooms = null;
        bookRooms = bookRoomDao.allBookRoom(bookRoom, page, rows);

        return bookRooms;
    }

    @Override
    public int updateBR(BookRoommodel bookRoom) throws SQLException {
        int code = 0;
        code = bookRoomDao.updateBR(bookRoom);
        return code;
    }

    @Override
    public int addBR(BookRoommodel bookRoom) throws SQLException {
        int code = 0;
        code = bookRoomDao.addBR(bookRoom);
        return code;

    }

    @Override
    public int deleteBR(BookRoommodel bookRoom) throws SQLException {

        int code = 0;
        code = bookRoomDao.deleteBR(bookRoom);
        return code;
    }
}
