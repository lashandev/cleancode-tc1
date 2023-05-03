package com.epic.techtalk.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    private static ThreadLocal<Connection> connection = new ThreadLocal<>();

    private static Connection setupConncetion() throws SQLException,ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        /**
         * Staging Server
         */
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/mixfruit?useSSL=false", "root", "Password@123");

        return con;
    }

    public static void iud(String sql) throws Exception {
        getConnectionInstance().createStatement().executeUpdate(sql);
    }

    public static ResultSet search(String sql) throws Exception {
        return getConnectionInstance().createStatement().executeQuery(sql);

    }

    public static Connection getConnectionInstance() throws SQLException,ClassNotFoundException {
        if (connection.get() == null || connection.get().isClosed()) {
            connection.set(setupConncetion());
        }
        return connection.get();
    }
}
