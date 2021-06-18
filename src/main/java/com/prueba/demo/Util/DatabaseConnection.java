package com.prueba.demo.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

public class DatabaseConnection {

    private Map<?, ?> dbParams;

    public DatabaseConnection(Map<?, ?> dbParams) {

        this.dbParams = dbParams;
    }

    private Connection ConnParam() throws SQLException {

        Properties connectionProps = new Properties();
        connectionProps.put("user", dbParams.get("userName"));
        connectionProps.put("password", dbParams.get("password"));
        Connection conn =  DriverManager.getConnection("jdbc:" + dbParams.get("dbms") + "://" + dbParams.get("serverName")+ ":" + dbParams.get("portNumber") + "/"+ dbParams.get("nameDB"), connectionProps);

        return conn;
    }

    public Statement ConnectionBD () {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = ConnParam();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            //	e1.printStackTrace();
            return stmt;
        }
        try {
            return conn.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return stmt;
    }
}