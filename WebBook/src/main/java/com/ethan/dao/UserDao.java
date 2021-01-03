package com.ethan.dao;

import java.sql.SQLException;
import java.util.List;

import com.ethan.model.Usermodel;

public interface UserDao {
    /**
     * user登录
     * @param user
     * @return user
     * @throws SQLException
     */
    public Usermodel login(Usermodel user) throws SQLException;

    /**
     * 修改user信息
     *
     * @param user
     * @return int
     * @throws SQLException
     */
    public int update(Usermodel user) throws SQLException;

    /**
     * 根据条件,显示user
     *
     * @param user
     * @param page
     * @param rows
     * @return user
     * @throws SQLException
     */
    public List<Usermodel> allUser(Usermodel user, int page, int rows) throws SQLException;

    /**
     * 添加user
     *
     * @param user
     * @return int
     * @throws SQLException
     */
    public int addUser(Usermodel user) throws SQLException;


    /**
     * 查询user
     *
     * @param user
     * @return user
     * @throws SQLException
     */
    public List<Usermodel> findUser(Usermodel user) throws SQLException;


    /**
     * 删除ids有的user
     *
     * @param ids
     * @return 删除的个数int
     * @throws SQLException
     */
    public int deleteUser(String ids) throws SQLException;


    /**
     * 根据条件,获取user个数
     *
     * @param user
     * @return user个数int
     * @throws SQLException
     */
    public int userCount(Usermodel user) throws SQLException;

    /**
     * 是否存在account
     *
     * @param user
     * @return
     * @throws SQLException
     */
    public boolean isAccount(Usermodel user) throws SQLException;


}
