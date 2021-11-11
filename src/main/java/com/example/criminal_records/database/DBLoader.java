package com.example.criminal_records.database;

import java.sql.*;

public class DBLoader {
    Connection con = null;

    public Connection connectDB() {
        try {
            //importing driver
            Class.forName("com.mysql.jdbc.Driver");

            //TODO: adding actual data
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://Url",
                    "root", "password");
            return con;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return null;
    }
}
