package com.ethan.dao;

import java.sql.SQLException;
import java.util.List;

import com.ethan.model.AllEntitymodel;
import com.ethan.model.Ticketmodel;

/**
 * Created by zhangwenyu on 2018/12/10.
 */
public interface TicketDao {
    public List<Ticketmodel> allTicket(Ticketmodel ticket, int page, int rows) throws SQLException;

    public int deleteTicket(String ids) throws SQLException;

    public int updateTicket(Ticketmodel ticket) throws SQLException;

    public int addTicket(Ticketmodel ticket) throws SQLException;
}
