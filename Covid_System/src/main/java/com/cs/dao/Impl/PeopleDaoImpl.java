package com.cs.dao.Impl;

import com.cs.dao.PeopleDao;
import com.cs.domain.People;
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
 * 人员确诊信息
 * PeopleDao接口的实现方法
 */
public class PeopleDaoImpl implements PeopleDao {
    /**
     * 查询符合确诊或无症状感染者条件的记录数
     * @param condition 条件（没用到。。。）
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
            String sql = "select count(*) from people where status='确诊' or status='无症状感染者'";
            preparedStatement = connection.prepareStatement(sql);
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
     * 分页查找确诊信息（确诊或无症状感染者）
     * @param start 开始页码
     * @param rows 行数
     * @param condition 条件（没用到。。。）
     * @return People类型的List集合
     */
    @Override
    public List<People> findByPage(int start, int rows, Map<String, String[]> condition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<People> list = new ArrayList<>();
        try {
            connection = JdbcUtil.getConnection();
            String sql = "select * from people where status='确诊' or status='无症状感染者' limit ? , ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, rows);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String neighbor = resultSet.getString("neighbor");
                String status = resultSet.getString("status");
                People user = new People();
                user.setId(id);
                user.setName(name);
                user.setAge(age);
                user.setGender(gender);
                user.setNeighbor(neighbor);
                user.setStatus(status);
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
     * 添加患者信息
     * @param people People类型的参数
     */
    @Override
    public void addPeople(People people) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "insert into people values ( null ,  ? , ? , ? , ? , ?) ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, people.getName());
            preparedStatement.setInt(2, people.getAge());
            preparedStatement.setString(3, people.getGender());
            preparedStatement.setString(4, people.getNeighbor());
            preparedStatement.setString(5, people.getStatus());
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
     * 根据ID查找患者
     * @param id id
     * @return People类型
     */
    @Override
    public People findPeoById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        People people = new People();
        try {
            connection = JdbcUtil.getConnection();
            String sql = "select * from people where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String neighbor = resultSet.getString("neighbor");
                String status = resultSet.getString("status");
                people.setId(id);
                people.setName(name);
                people.setAge(age);
                people.setGender(gender);
                people.setNeighbor(neighbor);
                people.setStatus(status);
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
        return people;
    }

    /**
     * 修改患者信息
     * @param people People类型的参数
     */
    @Override
    public void updatePeo(People people) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "update people set name=?, age=?,gender=?,neighbor=?,status=?  where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, people.getName());
            preparedStatement.setInt(2, people.getAge());
            preparedStatement.setString(3, people.getGender());
            preparedStatement.setString(4, people.getNeighbor());
            preparedStatement.setString(5, people.getStatus());
            preparedStatement.setInt(6, people.getId());
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
