package com.cs.dao.Impl;

import com.cs.dao.UserDao;
import com.cs.domain.User;
import com.cs.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 网格员的数据库操作类
 */
public class UserDaoImpl implements UserDao {
    /**
     * 查询符合确条件的网格员记录数
     * @param condition 条件（模糊查找）
     * @return 总记录数
     */
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

    /**
     * 分页查找网格员信息
     * @param start 开始页码
     * @param rows 行数
     * @param condition 条件（模糊查找）
     * @return User类型的List集合
     */
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
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String tele = resultSet.getString("tele");
                String neighbor = resultSet.getString("neighbor");
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setAge(age);
                user.setGender(gender);
                user.setAddress(address);
                user.setEmail(email);
                user.setTele(tele);
                user.setNeighbor(neighbor);
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

    /**
     * 添加网格员
     * @param user
     */
    @Override
    public void addUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "insert into user values ( null , ? , ? , ? , ? , ? ,?, ?) ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getTele());
            preparedStatement.setString(7, user.getNeighbor());
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

    /**
     * 根据id查找
     * @param id
     * @return
     */
    @Override
    public User findById(int id) {

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
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String tele = resultSet.getString("tele");
                String neighbor = resultSet.getString("neighbor");
                user.setId(id);
                user.setName(name);
                user.setAge(age);
                user.setGender(gender);
                user.setAddress(address);
                user.setEmail(email);
                user.setTele(tele);
                user.setNeighbor(neighbor);
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

    /**
     * 更新
     * @param user
     */
    @Override
    public void update(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "update user set age=?,gender=?,address=?,email=?, tele=?,neighbor=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getAge());
            preparedStatement.setString(2, user.getGender());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getTele());
            preparedStatement.setString(6, user.getNeighbor());
            preparedStatement.setInt(7, user.getId());
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

    /**
     * 删除
     * @param id
     */
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

    /**
     * 查找负责小区
     * @param neighbor 小区
     * @return 返回值为网格员信息User
     */
    @Override
    public User findByNei(String neighbor) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            connection = JdbcUtil.getConnection();
            String sql = "select * from user where neighbor = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, neighbor);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String tele = resultSet.getString("tele");
                user.setId(id);
                user.setName(name);
                user.setAge(age);
                user.setGender(gender);
                user.setAddress(address);
                user.setEmail(email);
                user.setTele(tele);
                user.setNeighbor(neighbor);
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
}
