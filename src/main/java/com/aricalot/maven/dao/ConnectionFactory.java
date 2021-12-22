package com.aricalot.maven.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection = null;

    private ConnectionFactory() {
    }

    public static Connection getInstance() {
        if (connection == null)
            return connectDatabase();
        return connection;
    }

    private static Connection connectDatabase() {
        final String dbURL = "jdbc:mysql://localhost:3306/student_data";
        final String dbUsername = "root";
        final String dbPassword = "";
        try {
            connection =  DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
