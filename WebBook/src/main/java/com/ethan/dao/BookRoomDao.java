package com.ethan.dao;

import java.sql.SQLException;
import java.util.List;

import com.ethan.model.BookRoommodel;

/**
 * Created by zhangwenyu on 2018/12/9.
 */
public interface BookRoomDao {
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
