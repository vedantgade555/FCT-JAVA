package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

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
            e.printStackTrace();
        }
        return con;
    }

    // ✅ Pagination method
    public static List<Emp> getRecords(int start, int pageLimit) {
        List<Emp> list = new ArrayList<>();

        try {
            Connection con = getConnection();

            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM usertable LIMIT ?, ?");

            ps.setInt(1, start);
            ps.setInt(2, pageLimit);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Emp e = new Emp();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setPassword(rs.getString("password"));
                e.setEmail(rs.getString("email"));
                e.setCountry(rs.getString("country"));

                list.add(e);
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
