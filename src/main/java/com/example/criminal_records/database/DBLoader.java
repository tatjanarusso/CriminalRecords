package com.example.criminal_records.database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBLoader {
    Connection con = null;

    public Connection connectDB() {
        try {
            //importing driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //TODO: if changing device, information may needs to be changed
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/criminal_records",
                    "root", "root");
            return con;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return null;
    }
}
