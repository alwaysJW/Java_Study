package com.pis.dao.Impl;

import com.pis.dao.UserDao;
import com.pis.domain.User;
import com.pis.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int rowCount = 0;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "select count(*) from user where 1 = 1 ";
            StringBuilder sb=new StringBuilder(sql);
            for (Map.Entry<String, String[]> entry : condition.entrySet()) {
                String key = entry.getKey();
                if ("currentPage".equals(key)||"rows".equals(key)){
                    continue;
                }
                String[] values = entry.getValue();
                String value=values[0];
                if (value!=null&&!"".equals(value)) {
                    sb.append(" and " + key + " like " + "'%"+value+"%'" + " ");
                }
            }
            preparedStatement = connection.prepareStatement(String.valueOf(sb));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                rowCount = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getClose(connection, preparedStatement, resultSet);
        }
        return rowCount;

    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> list = new ArrayList<>();
        try {
            connection = JdbcUtil.getConnection();
            StringBuilder sb=new StringBuilder();
            for (Map.Entry<String, String[]> entry : condition.entrySet()) {
                String key = entry.getKey();
                if ("currentPage".equals(key)||"rows".equals(key)){
                    continue;
                }
                String[] values = entry.getValue();
                String value=values[0];
                if (value!=null&&!"".equals(value)) {
                    sb.append(" and " + key + " like " + "'%"+value+"%'" + " ");
                }
            }
            String sql = "select * from user where 1 = 1 "+ sb +" limit ? , ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, rows);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String kinds = resultSet.getString("kinds");
                String master = resultSet.getString("master");
                String tele = resultSet.getString("tele");
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setAge(age);
                user.setGender(gender);
                user.setKinds(kinds);
                user.setMaster(master);
                user.setTele(tele);
                list.add(user);
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
    public User findUserById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            connection = JdbcUtil.getConnection();
            String sql = "select * from user where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String kinds = resultSet.getString("kinds");
                String master = resultSet.getString("master");
                String tele = resultSet.getString("tele");
                user.setId(id);
                user.setName(name);
                user.setAge(age);
                user.setGender(gender);
                user.setKinds(kinds);
                user.setMaster(master);
                user.setTele(tele);
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
        return user;
    }

    @Override
    public void updateUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "update user set age=?,gender=?,kinds=?,master=?, tele=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getAge());
            preparedStatement.setString(2, user.getGender());
            preparedStatement.setString(3, user.getKinds());
            preparedStatement.setString(4, user.getMaster());
            preparedStatement.setString(5, user.getTele());
            preparedStatement.setInt(6, user.getId());
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
    public void addUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "insert into user values ( null , ? , ? , ? , ? , ? , ?) ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getKinds());
            preparedStatement.setString(5, user.getMaster());
            preparedStatement.setString(6, user.getTele());
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
    public void deleteUser(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "delete from user where id=?";
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
