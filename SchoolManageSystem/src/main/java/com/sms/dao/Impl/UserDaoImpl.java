package com.sms.dao.Impl;

import com.sms.dao.UserDao;
import com.sms.domain.User;
import com.sms.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User findToLogin(User user) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            String sql="select * from user where email=? and password=?";
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getEmail());
            preparedStatement.setString(2,user.getPassword());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String name = resultSet.getString("name");
                user.setName(name);
                return user;
            }
            connection.setAutoCommit(false);
        } catch (Exception e) {
            //事物回滚
            try {
                if (connection!=null)
                    connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JdbcUtil.getClose(connection,preparedStatement,resultSet);
        }
        return null;
    }

    @Override
    public void register(User user) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection = JdbcUtil.getConnection();
            String sql="insert into user values ( null , ? , ? , ? )";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getEmail());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getName());
            preparedStatement.executeUpdate();
            connection.setAutoCommit(false);
        } catch (Exception e) {
            try {
                if (connection!=null)
                    connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JdbcUtil.getClose(connection,preparedStatement);
        }
    }
}
