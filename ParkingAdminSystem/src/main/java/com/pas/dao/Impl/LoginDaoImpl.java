package com.pas.dao.Impl;

import com.pas.dao.LoginDao;
import com.pas.domain.Login;
import com.pas.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {
    @Override
    public Login login(Login login) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            String sql="select * from login where username=? and password=?";
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,login.getUsername());
            preparedStatement.setString(2,login.getPassword());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int key = resultSet.getInt("key");
                login.setId(id);
                login.setName(name);
                login.setKey(key);
                return login;
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
    public void register(Login login) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection = JdbcUtil.getConnection();
            String sql="insert into login values ( null , ? , ? , ?, 0)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,login.getUsername());
            preparedStatement.setString(2,login.getPassword());
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

    @Override
    public Login forget(Login login) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            String sql="select * from login where username=? and name=?";
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,login.getUsername());
            preparedStatement.setString(2,login.getName());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int id= resultSet.getInt("id");
                int key = resultSet.getInt("key");
                login.setId(id);
                login.setKey(key);
                return login;
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
    public void findPass(Login login) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "update login set password=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login.getPassword());
            preparedStatement.setInt(2, login.getId());
            preparedStatement.executeUpdate();
            connection.setAutoCommit(false);
        } catch (Exception e) {
            //事物回滚
            try {
                if (connection != null)
                    connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JdbcUtil.getClose(connection, preparedStatement);
        }
    }
}
