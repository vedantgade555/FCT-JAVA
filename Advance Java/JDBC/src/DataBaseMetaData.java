import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class DataBaseMetaData {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            // step1: Register Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step2: Create Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","vedant@555");

            // Step3: Create Query

            DatabaseMetaData dbmd = con.getMetaData();

            // step4



            System.out.println(" Driver Name "+dbmd.getDriverName());
            System.out.println("DriverVersion"+dbmd.getDriverVersion());
            // left side indicate major version and right show minor versuin
            System.out.println("DataBase Name "+dbmd.getDatabaseProductName());

            // step:5

            con.close();



        }catch(Exception e) {

            System.out.println(e);

        }
    }

}
