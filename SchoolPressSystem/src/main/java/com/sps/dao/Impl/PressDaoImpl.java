package com.sps.dao.Impl;

import com.sps.dao.PressDao;
import com.sps.domain.Press;
import com.sps.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PressDaoImpl implements PressDao {
    @Override
    public List<Press> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Press> list = new ArrayList<>();
        try {
            connection = JdbcUtil.getConnection();
            String sql = "select * from press";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String total = resultSet.getString("total");
                String content = resultSet.getString("content");
                String url = resultSet.getString("url");
                String img = resultSet.getString("img");
                Press press=new Press();
                press.setId(id);
                press.setTotal(total);
                press.setContent(content);
                press.setUrl(url);
                press.setImg(img);
                list.add(press);
            }
            //提交事务
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
            JdbcUtil.getClose(connection, preparedStatement, resultSet);
        }
        return list;
    }

    @Override
    public void addPress(Press press) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "insert into press values ( null , ? , ? , ? , ? ) ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, press.getTotal());
            preparedStatement.setString(2, press.getContent());
            preparedStatement.setString(3, press.getUrl());
            preparedStatement.setString(4, press.getImg());
            preparedStatement.executeUpdate();
            connection.setAutoCommit(false);
        } catch (Exception e) {
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

    @Override
    public Press changeById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Press aNew = new Press();
        try {
            connection = JdbcUtil.getConnection();
            String sql = "select * from press where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String total = resultSet.getString("total");
                String content = resultSet.getString("content");
                String url = resultSet.getString("url");
                String img = resultSet.getString("img");
                aNew.setId(id);
                aNew.setTotal(total);
                aNew.setContent(content);
                aNew.setUrl(url);
                aNew.setImg(img);
            }
            //提交事务
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
            JdbcUtil.getClose(connection, preparedStatement, resultSet);
        }
        return aNew;
    }

    @Override
    public void updateNews(Press press) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "update press set total=?,content=?,url=?,img=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, press.getTotal());
            preparedStatement.setString(2, press.getContent());
            preparedStatement.setString(3, press.getUrl());
            preparedStatement.setString(4, press.getImg());
            preparedStatement.setInt(5, press.getId());
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

    @Override
    public void deletePress(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "delete from press where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
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
