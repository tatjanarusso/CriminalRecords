package com.example.criminal_records.database;

import java.sql.*;

public class DatabaseCommandExecutor {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public DatabaseCommandExecutor() {
        DBLoader dbLoader = new DBLoader();
        connection = dbLoader.connectDB();
    }

    public ResultSet getTable(String table){
        try{
            //getting data from db
            String sql = "SELECT * FROM " + table +  ";";
            resultSet = executeSql(sql);
            return resultSet;
        }catch(SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public ResultSet getFiltered(String table, String condition){
        try{
            //getting data from db
            String sql = "SELECT * "+ " FROM " + table + " WHERE " + condition +  ";";
            resultSet = executeSql(sql);
            return resultSet;
        }catch(SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    private ResultSet executeSql(String sql) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        ResultSet results = preparedStatement.executeQuery();
        return results;
    }
}
