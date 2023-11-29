package com.codegym.casestudy.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBRepository {
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        String url = "jdbc://mysql://localhost:3306/case_study_2";
        String username = "root";
        String password = "123456";
        connection = DriverManager.getConnection(url,username,password);
        return connection;
    }
}