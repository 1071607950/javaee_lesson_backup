package com.ethan.factory;

import com.ethan.dao.*;
import com.ethan.dao.impl.*;
import com.ethan.model.*;
import com.ethan.service.*;
import com.ethan.service.impl.*;
import org.apache.commons.dbutils.QueryRunner;

public class DaoFactory {
    /**
     * 获取一个QueryRunner实例
     * @return QueryRunner
     */
    public static QueryRunner getQueryRunnerInstance() {
        return new QueryRunner(DBFactory.getDataSource());
    }

    /**
     * 获取一个User实例
     *
     * @return user
     */
    public static Usermodel getUser() {
        return new Usermodel();
    }
    /**
     * 获取一个UserDaoImpl实例
     * @return UserDaoImpl
     */
    public static UserDao getUserDaoInstance() {
        return new UserDaoImpl();
    }


    /**
     * 获取一个UserServiceImpl实例
     * @return UserServiceImpl
     */
    public static UserServiceImpl getUserServiceInstance() {
        return new UserServiceImpl();
    }

    /**
     * 获取一个BookDaoImpl实例
     *
     * @return BookDaoImpl
     */
    public static BookDao getBookDaoInstance() {
        return new BookDaoImpl();
    }
    /**
     * 获取一个BookServiceImpl实例
     *
     * @return BookServiceImpl
     */
    public static BookServiceImpl getBookServiceInstance() {
        return new BookServiceImpl();
    }

    public static Bookmodel getBook() {
        return new Bookmodel();
    }


    public static BookRoommodel getBookRoomInstance() {
        return new BookRoommodel();
    }

    public static BookRoomDao getBookRoomDaoInstance() {
        return new BookRoomDaoImpl();
    }

    public static BookRoomServiceImpl getBookRoomServiceInstance() {
        return new BookRoomServiceImpl();
    }


    public static BookCatagorymodel getBookCatagoryInstance() {
        return new BookCatagorymodel();
    }

    public static BookCatagoryDao getBookCatagoryDaoInstance() {
        return new BookCatagoryDaoImpl();
    }

    public static BookCatagoryService getBookCatagoryServiceInstance() {
        return new BookCatagoryServiceImpl();
    }


    public static BorrowCardmodel getBorrowCardInstance() {
        return new BorrowCardmodel();
    }

    public static BorrowCardDao getBorrowCardDaoInstance() {
        return new BorrowCardDaoImpl();
    }

    public static BorrowCardService getBorrowCardServiceInstance() {
        return new BorrowCardServiceImpl();
    }


    public static BorrowLevelmodel getBorrowLevelInstance() {
        return new BorrowLevelmodel();
    }

    public static BorrowLevelDao getBorrowLevelDaoInstance() {
        return new BorrowLevelDaoImpl();
    }

    public static BorrowLevelService getBorrowLevelServiceInstance() {
        return new BorrowLevelServiceImpl();
    }


    public static Borrowmodel getBorrowInstance() {
        return new Borrowmodel();
    }

    public static BorrowDao getBorrowDaoInstance() {
        return new BorrowDaoImpl();
    }

    public static BorrowService getBorrowServiceInstance() {
        return new BorrowServiceImpl();
    }


    public static Ticketmodel getTicketInstance() {
        return new Ticketmodel();
    }

    public static TicketDao getTicketDaoInstance() {
        return new TicketDaoImpl();
    }

    public static TicketService getTicketServiceInstance() {
        return new TicketServiceImpl();
    }
}
