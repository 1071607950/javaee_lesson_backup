package com.ethan.dao.impl;

import com.ethan.dao.BorrowCardDao;
import com.ethan.model.AllEntitymodel;
import com.ethan.model.BorrowCardmodel;
import com.ethan.utils.StringUtil;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangwenyu on 2018/12/10.
 */
public class BorrowCardDaoImpl extends BaseDao implements BorrowCardDao {
    @Override
    public List<AllEntitymodel> allBorrowCard(BorrowCardmodel borrowCard, int page, int rows) throws SQLException {
        String sql = "select * from borrowcard,user,borrowlevel where borrowcard.borrowcard_rid = user.user_id and borrowcard.borrowcard_blid = borrowlevel.borrowlevel_id ";
        if (StringUtil.isNotEmpty(borrowCard.getBorrowcard_id())) {
            sql += " and borrowcard.borrowcard_id like '%" + borrowCard.getBorrowcard_id() + "%' ";
        }
        if (borrowCard.getBorrowcard_blid() > 0) {
            sql += " and borrowcard.borrowcard_blid=" + borrowCard.getBorrowcard_blid() + " ";
        }
        if (page > 0 && rows > 0) {
            sql += " limit " + (page - 1) * rows + "," + rows;
        }
        List<AllEntitymodel> book_catagory_rooms = queryRunner.query(sql, new BeanListHandler<AllEntitymodel>(AllEntitymodel.class));
        return book_catagory_rooms;
    }

    @Override
    public int updateBC(BorrowCardmodel borrowCard) throws SQLException {
        String sql = "update borrowcard set borrowcard_blid=? where borrowcard_id=?";
        int code = queryRunner.update(sql, borrowCard.getBorrowcard_blid(), borrowCard.getBorrowcard_id());


        return code;
    }

    @Override
    public int deleteBC(String ids) throws SQLException {
        String sql = "delete from borrowcard where borrowcard_id in(" + ids + ") ";
        int code = queryRunner.execute(sql);
        return code;
    }

    @Override
    public int addBC(BorrowCardmodel borrowCard) throws SQLException {
        String sql = "insert into borrowcard (borrowcard_id,borrowcard_rid,borrowcard_quantity,borrowcard_blid) values(?,?,?,?)";
        int code = queryRunner.update(sql, borrowCard.getBorrowcard_id(), borrowCard.getBorrowcard_rid(), borrowCard.getBorrowcard_quantity(), borrowCard.getBorrowcard_blid());
        return code;
    }

    @Override
    public int borrowbBook(BorrowCardmodel borrowCard, int a) throws SQLException {
        int code = 0;
        if (a == 0) {//还书
            String sql = "update borrowcard set borrowcard_quantity=borrowcard_quantity-1 where borrowcard_id=?";
            code = queryRunner.update(sql, borrowCard.getBorrowcard_id());
        } else {
            String sql = "update borrowcard set borrowcard_quantity=borrowcard_quantity+1 where borrowcard_id=?";
            code = queryRunner.update(sql, borrowCard.getBorrowcard_id());
        }

        return code;
    }

    @Override
    public int bcCount() throws SQLException {

        String sql = "select count(*) from borrowcard";
        long count = queryRunner.query(sql, new ScalarHandler<Long>());

        return (int) count;
    }
}
