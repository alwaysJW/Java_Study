package com.sms.dao.Impl;

import com.sms.dao.StudentDao;
import com.sms.domain.Student;
import com.sms.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {
    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int rowCount = 0;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "select count(*) from student where 1 = 1 ";
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
    public List<Student> findByPage(int start, int rows, Map<String, String[]> condition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> list = new ArrayList<>();
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
            String sql = "select * from student where 1 = 1 "+ sb +" limit ? , ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, rows);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String classes = resultSet.getString("classes");
                String college = resultSet.getString("college");
                String profession = resultSet.getString("profession");
                String tele = resultSet.getString("tele");
                Student student=new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                student.setGender(gender);
                student.setClasses(classes);
                student.setCollege(college);
                student.setProfession(profession);
                student.setTele(tele);
                list.add(student);
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
    public Student findById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = new Student();
        try {
            connection = JdbcUtil.getConnection();
            String sql = "select * from student where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String classes = resultSet.getString("classes");
                String college = resultSet.getString("college");
                String profession = resultSet.getString("profession");
                String tele = resultSet.getString("tele");
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                student.setGender(gender);
                student.setClasses(classes);
                student.setCollege(college);
                student.setProfession(profession);
                student.setTele(tele);
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
        return student;
    }

    @Override
    public void updateStu(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "update student set gender=?,age=?,classes=?,college=?,profession=?,tele=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getGender());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getClasses());
            preparedStatement.setString(4, student.getCollege());
            preparedStatement.setString(5, student.getProfession());
            preparedStatement.setString(6, student.getTele());
            preparedStatement.setInt(7, student.getId());
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
    public void addStu(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "insert into student values ( null , ? , ? , ? , ? , ? , ? , ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getGender());
            preparedStatement.setString(4, student.getClasses());
            preparedStatement.setString(5, student.getCollege());
            preparedStatement.setString(6, student.getProfession());
            preparedStatement.setString(7, student.getTele());
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
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "delete from student where id=?";
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
