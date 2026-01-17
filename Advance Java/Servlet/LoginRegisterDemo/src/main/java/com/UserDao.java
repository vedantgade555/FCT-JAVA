package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserDao {
	public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/crudtestdb",
                "root",
                "vedant@555"
            );
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
	
	
}
