package com.ethan.service.impl;

import com.ethan.dao.TicketDao;
import com.ethan.factory.DaoFactory;
import com.ethan.model.Ticketmodel;
import com.ethan.service.TicketService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangwenyu on 2018/12/10.
 */
public class TicketServiceImpl implements TicketService {
    TicketDao ticketDao = DaoFactory.getTicketDaoInstance();

    @Override
    public List<Ticketmodel> allTicket(Ticketmodel ticket, int page, int rows) throws SQLException {
        List<Ticketmodel> alltickets = null;
        alltickets = ticketDao.allTicket(ticket, page, rows);
        return alltickets;
    }

    @Override
    public int deleteTicket(String ids) throws SQLException {
        int code = 0;
        code = ticketDao.deleteTicket(ids);
        return code;
    }

    @Override
    public int updateTicket(Ticketmodel ticket) throws SQLException {
        int code = 0;
        code = ticketDao.updateTicket(ticket);
        return code;
    }

    @Override
    public int addTicket(Ticketmodel ticket) throws SQLException {
        int code = 0;
        code = ticketDao.addTicket(ticket);
        return code;
    }
}
