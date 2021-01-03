package com.ethan.dao.impl;

import com.ethan.dao.BorrowLevelDao;
import com.ethan.model.BorrowLevelmodel;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangwenyu on 2018/12/10.
 */
public class BorrowLevelDaoImpl extends BaseDao implements BorrowLevelDao {


    @Override
    public List<BorrowLevelmodel> allBorroeLevel(BorrowLevelmodel borrowLevel, int page, int rows) throws SQLException {
        String sql = "select * from borrowlevel where 1=1";
        if (page > 0 && rows > 0) {
            sql += " limit " + (page - 1) * rows + "," + rows;
        }
        List<BorrowLevelmodel> book_catagory_rooms = queryRunner.query(sql, new BeanListHandler<BorrowLevelmodel>(BorrowLevelmodel.class));
        return book_catagory_rooms;
    }
}
