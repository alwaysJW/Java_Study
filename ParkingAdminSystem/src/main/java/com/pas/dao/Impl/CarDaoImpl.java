package com.pas.dao.Impl;

import com.pas.dao.CarDao;
import com.pas.domain.Car;
import com.pas.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarDaoImpl implements CarDao {
    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int rowCount = 0;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "select count(*) from car where 1 = 1 ";
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
    public List<Car> findByPage(int start, int rows, Map<String, String[]> condition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Car> list = new ArrayList<>();
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
            String sql = "select * from car where 1 = 1 "+ sb +" limit ? , ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, rows);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String carimge = resultSet.getString("carimge");
                Timestamp intime = resultSet.getTimestamp("intime");
                Timestamp outtime = resultSet.getTimestamp("outtime");
                String acar = resultSet.getString("car");
                String tele = resultSet.getString("tele");
                Car car = new Car();
                car.setId(id);
                car.setName(name);
                car.setCarimge(carimge);
                car.setIntime(intime);
                car.setOuttime(outtime);
                car.setCar(acar);
                car.setTele(tele);
                list.add(car);
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
    public void addCar(Car car) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "insert into car values ( null , ? , ? , ? ,? , ? ,?) ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, car.getName());
            preparedStatement.setString(2, car.getCarimge());
            preparedStatement.setTimestamp(3, car.getIntime());
            preparedStatement.setTimestamp(4, car.getOuttime());
            preparedStatement.setString(5, car.getCar());
            preparedStatement.setString(6, car.getTele());

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
    public Car findUserById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Car car = new Car();
        try {
            connection = JdbcUtil.getConnection();
            String sql = "select * from car where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String carimge = resultSet.getString("carimge");
                Timestamp intime = resultSet.getTimestamp("intime");
                String acar = resultSet.getString("car");
                String tele = resultSet.getString("tele");
                car.setId(id);
                car.setName(name);
                car.setCarimge(carimge);
                car.setIntime(intime);
                car.setCar(acar);
                car.setTele(tele);
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
        return car;
    }

    @Override
    public void updateCar(Car car) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "update car set name=?,carimge=?,car=?, tele=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, car.getName());
            preparedStatement.setString(2, car.getCarimge());
            preparedStatement.setString(3, car.getCar());
            preparedStatement.setString(4, car.getTele());
            preparedStatement.setInt(5, car.getId());
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
    public void deleteCar(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "delete from car where id=?";
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

    @Override
    public void deleteCar(int id, Timestamp time) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "update car set outtime=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, time);
            preparedStatement.setInt(2, id);
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
