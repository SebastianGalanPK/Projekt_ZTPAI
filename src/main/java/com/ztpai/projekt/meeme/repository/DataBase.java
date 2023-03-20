package com.ztpai.projekt.meeme.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static DataBase _instance;

    private final String HOST = "localhost";
    private final String DATABASE = "ztpai-projekt";
    private final int PORT = 5432;
    private final String USER = "postgres";
    private final String PASSWORD = "123qwe";

    private String url = "jdbc:postgresql://%s:%d/%s";

    public Connection con;

    private DataBase(){
        connect();
    }

    private void connect() {
        this.url = String.format(this.url, this.HOST, this.PORT, this.DATABASE);

        try{
            con = DriverManager.getConnection(url, USER, PASSWORD);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static DataBase getInstance(){
        if(_instance==null){
            _instance = new DataBase();
        }

        return _instance;
    }
}
