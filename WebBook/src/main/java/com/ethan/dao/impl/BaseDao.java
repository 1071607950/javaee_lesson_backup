package com.ethan.dao.impl;


import com.ethan.factory.DaoFactory;
import org.apache.commons.dbutils.QueryRunner;

public class BaseDao {
    QueryRunner queryRunner;

    BaseDao() {
        queryRunner = DaoFactory.getQueryRunnerInstance();
    }
}
