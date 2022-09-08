package com.pis.dao.Impl;

import com.pis.dao.NewDao;
import com.pis.domain.New;
import com.pis.domain.User;
import com.pis.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewDaoImpl implements NewDao {
    @Override
    public void addNews(New aNew) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "insert into news values ( null , ? , ? , ? , ?) ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, aNew.getTotal());
            preparedStatement.setString(2, aNew.getNews());
            preparedStatement.setString(3, aNew.getTxt());
            preparedStatement.setString(4, aNew.getImgs());
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
    public List<New> findAll() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<New> list = new ArrayList<>();
        try {
            connection = JdbcUtil.getConnection();
            String sql = "select * from news";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String total = resultSet.getString("total");
                String news = resultSet.getString("news");
                String txt = resultSet.getString("txt");
                String imgs = resultSet.getString("imgs");

                New anew = new New();
                anew.setId(id);
                anew.setTotal(total);
                anew.setNews(news);
                anew.setTxt(txt);
                anew.setImgs(imgs);

                list.add(anew);
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
    public New changeById(int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        New aNew = new New();
        try {
            connection = JdbcUtil.getConnection();
            String sql = "select * from news where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String total = resultSet.getString("total");
                String news = resultSet.getString("news");
                String txt = resultSet.getString("txt");
                String imgs = resultSet.getString("imgs");
                aNew.setId(id);
                aNew.setTotal(total);
                aNew.setNews(news);
                aNew.setTxt(txt);
                aNew.setImgs(imgs);
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
    public void update(New aNew) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "update news set total=?,news=?,txt=?,imgs=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, aNew.getTotal());
            preparedStatement.setString(2, aNew.getNews());
            preparedStatement.setString(3, aNew.getTxt());
            preparedStatement.setString(4, aNew.getImgs());
            preparedStatement.setInt(5, aNew.getId());
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
    public void deleteNews(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "delete from news where id=?";
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
