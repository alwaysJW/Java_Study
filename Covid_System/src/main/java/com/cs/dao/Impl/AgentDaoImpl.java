package com.cs.dao.Impl;

import com.cs.dao.AgentDao;
import com.cs.domain.Agent;
import com.cs.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 待办事项AgentDao接口的实现类
 */
public class AgentDaoImpl implements AgentDao {
    /**
     * 添加待办事项
     * @param agent Agent类型的参数
     */
    @Override
    public void addAgent(Agent agent) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "insert into agent values ( null , ? , ? , ? , ? ,?) ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, agent.getName());
            preparedStatement.setString(2, agent.getThings());
            preparedStatement.setString(3, agent.getNeighbor());
            preparedStatement.setTimestamp(4, agent.getTime());
            preparedStatement.setString(5, agent.getTele());

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
     * 获取总记录数
     * @param condition 查询条件
     * @return rowCount 总记录数
     */
    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int rowCount = 0;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "select count(*) from agent where 1 = 1 ";
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
     * 分页查找待办事项
     * @param start 开始页码
     * @param rows 每页的记录数
     * @param condition 查询条件
     * @return List Agent类型的List集合
     */
    @Override
    public List<Agent> findByPage(int start, int rows, Map<String, String[]> condition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Agent> list = new ArrayList<>();
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
            String sql = "select * from agent where 1 = 1 "+ sb +" limit ? , ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, rows);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String things = resultSet.getString("things");
                String neighbor = resultSet.getString("neighbor");
                Timestamp time = resultSet.getTimestamp("time");
                String tele = resultSet.getString("tele");
                Agent agent=new Agent();
                agent.setId(id);
                agent.setName(name);
                agent.setThings(things);
                agent.setNeighbor(neighbor);
                agent.setTime(time);
                agent.setTele(tele);
                list.add(agent);
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
     *删除待办事项
     * @param id 代办事件的id
     */
    @Override
    public void deleteAgent(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "delete from agent where id=?";
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
