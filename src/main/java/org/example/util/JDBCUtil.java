package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/set_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection(){
        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
