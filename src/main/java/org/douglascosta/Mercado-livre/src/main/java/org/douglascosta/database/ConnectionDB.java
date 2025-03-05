package org.douglascosta.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public Connection getConnection() {
        Connection  connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DB final",
                    "postgres", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}


