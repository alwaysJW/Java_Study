package com.example.dao;

import com.example.bean.User;
import com.example.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User login(User user) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "select * from user where username = ? and password = ?";
             preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return user;
            }else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.getClose(connection,preparedStatement,resultSet);
        }
        return null;
    }

}
