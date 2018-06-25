package com.john.javademo.dao;

import com.john.javademo.impl.IDBHelper;

import java.sql.*;

public class MySqlHelper implements IDBHelper {
    private static final String DRIVER="com.mysql.jdbc.Driver";
    private String URL="http://1982.168.0.8";
    private Integer PORT=3306;
    private String DB_NAME="test";
    private String USER="root";
    private String PWD="root";

    /**
     * 初始化数据库访问
     * @param url
     * @param port
     * @param db_name
     * @param user
     * @param pwd
     */
    public  MySqlHelper(String url,Integer port,String db_name,String user,String pwd)
    {
        this.URL=url;
        this.PORT=port;
        this.DB_NAME=db_name;
        this.USER=user;
        this.PWD=pwd;
    }

    /**
     *
     * @param sql sql语句
     */
    @Override
    public int ExecuteNonQuery(String sql)
    {
        return 0;
    }
    @Override
    public void Query(String sql) {

    }
}
