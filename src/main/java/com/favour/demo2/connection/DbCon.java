package com.favour.demo2.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ECommerceDB";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "Amehfavour77";
    private static Connection connection = null;


    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            System.out.println("Connected");
        }
        return connection;
    }
}
