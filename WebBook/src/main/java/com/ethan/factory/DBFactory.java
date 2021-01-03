package com.ethan.factory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

//import com.mchange.v2.c3p0.ComboPooledDataSource;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBFactory {
    /*//不需要传参，会找c3p0配置文件中<default-config>默认配置
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
*/
	
	 /**
     * getDataSource 获取数据源
     * @return dataSource
     */
	
    public static DataSource getDataSource(){
    	Context ctx;
		try {
			ctx = new InitialContext();
			return (DataSource)ctx.lookup("java:comp/env/WebBookdbcp");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    /**
     * getConnection 获取连接
     * @return dataSource.getConnection
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException{
    	Context ctx = null;
		 DataSource ds = null;
		 try {
			 ctx = new InitialContext();
			 ds=(DataSource)ctx.lookup("java:comp/env/WebBookdbcp");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return ds.getConnection();
    }

    /**
     * 关闭连接
     * @param conn
     */
    public static void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
