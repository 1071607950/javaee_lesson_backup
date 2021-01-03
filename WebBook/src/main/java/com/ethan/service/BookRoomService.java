package com.ethan.service;

import com.ethan.model.BookRoommodel;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangwenyu on 2018/12/9.
 */
public interface BookRoomService {


    /**
     * @param bookRoom
     * @param page
     * @param rows
     * @return
     * @throws SQLException
     */
    public List<BookRoommodel> allBookRoom(BookRoommodel bookRoom, int page, int rows) throws SQLException;

    /**
     * @param bookRoom
     * @return
     * @throws SQLException
     */
    public int updateBR(BookRoommodel bookRoom) throws SQLException;

    /**
     * @param bookRoom
     * @return
     * @throws SQLException
     */
    public int addBR(BookRoommodel bookRoom) throws SQLException;

    /**
     * @param bookRoom
     * @return
     * @throws SQLException
     */
    public int deleteBR(BookRoommodel bookRoom) throws SQLException;
}
