package com.ethan.dao.impl;

import com.ethan.dao.BookCatagoryDao;
import com.ethan.model.AllEntitymodel;
import com.ethan.model.BookCatagorymodel;
import com.ethan.utils.StringUtil;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangwenyu on 2018/12/9.
 */
public class BookCatagoryDaoImpl extends BaseDao implements BookCatagoryDao {


    @Override
    public List<AllEntitymodel> allCatagory(BookCatagorymodel bookCatagory, int page, int rows) throws SQLException {
        String sql = "select * from bookcatagory,bookroom where bookcatagory.bookcatagory_brid=bookroom.bookroom_id";

        if (StringUtil.isNotEmpty(bookCatagory.getBookcatagory_name())) {
            sql += " and bookcatagory.bookcatagory_name like '%" + bookCatagory.getBookcatagory_name() + "%'";
        }

        if (page > 0 && rows > 0) {
            sql += " limit " + (page - 1) * rows + "," + rows;
        }

        List<AllEntitymodel> acr = queryRunner.query(sql, new BeanListHandler<AllEntitymodel>(AllEntitymodel.class));

        return acr;
    }

    @Override
    public int updateBC(BookCatagorymodel bookCatagory) throws SQLException {
        String sql = "update bookcatagory set bookcatagory_name=?,bookcatagory_brid=?,bookcatagory_demo=? where bookcatagory_id=?";
        int code = queryRunner.update(sql, bookCatagory.getBookcatagory_name(), bookCatagory.getBookcatagory_brid(), bookCatagory.getBookcatagory_demo(), bookCatagory.getBookcatagory_id());
        return code;
    }

    @Override
    public int deleteBC(String ids) throws SQLException {
        String sql = "delete from bookcatagory where bookcatagory_id in (" + ids + ")";
        int code = queryRunner.execute(sql);
        return code;
    }

    @Override
    public int addBC(BookCatagorymodel bookCatagory) throws SQLException {
        String sql = "insert into bookcatagory (bookcatagory_name,bookcatagory_brid,bookcatagory_demo) values(?,?,?)";
        int code = queryRunner.update(sql, bookCatagory.getBookcatagory_name(), bookCatagory.getBookcatagory_brid(), bookCatagory.getBookcatagory_demo());
        return code;
    }
}
