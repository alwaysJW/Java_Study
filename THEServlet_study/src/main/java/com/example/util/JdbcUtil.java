package com.example.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    private static String url;
    private static String username;
    private static String password;
    private static String driver;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("E:\\JavaStudyForWork\\THEServlet_study\\src\\main\\java\\jdbc.properties"));
            url=properties.getProperty("url");
            username=properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void getClose(Connection connection, PreparedStatement statement, ResultSet resultSet){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getClose(Connection connection, PreparedStatement statement){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
