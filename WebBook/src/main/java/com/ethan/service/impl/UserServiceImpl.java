package com.ethan.service.impl;

import com.ethan.dao.UserDao;
import com.ethan.factory.DaoFactory;
import com.ethan.model.Usermodel;
import com.ethan.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = DaoFactory.getUserDaoInstance();

    @Override
    public Usermodel login(Usermodel user) throws SQLException {
        Usermodel userResult = null;
        userResult = userDao.login(user);
        return userResult;
    }

    @Override
    public int update(Usermodel user) throws SQLException {
        int code = 0;
        code = userDao.update(user);
        return code;
    }

    @Override
    public List<Usermodel> allUser(Usermodel user, int page, int rows) throws SQLException {
        List<Usermodel> users = null;
        users = userDao.allUser(user, page, rows);
        return users;
    }


    public int addUser(Usermodel user) throws SQLException {
        int code = 0;
        code = userDao.addUser(user);
        return code;
    }

    @Override
    public List<Usermodel> findUser(Usermodel user) throws SQLException {
        List<Usermodel> users = null;
        users = userDao.findUser(user);
        return users;
    }

    @Override
    public int deleteUser(String ids) throws SQLException {
        int code = 0;
        code = userDao.deleteUser(ids);
        return code;
    }

    @Override
    public int userCount(Usermodel user) throws SQLException {
        int code = 0;
        code = userDao.userCount(user);
        return code;
    }

    @Override
    public boolean isAccount(Usermodel user) throws SQLException {
        return userDao.isAccount(user);
    }

}
