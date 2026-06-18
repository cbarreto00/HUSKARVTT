package org.example.database;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:database.db";

    public static ConnectionSource getConnectionSource() {
        try {
            return new JdbcConnectionSource(URL);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar o banco de dados.", e);
        }
    }
}

