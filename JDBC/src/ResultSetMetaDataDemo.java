import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class ResultSetMetaDataDemo {

    public static void main(String[] args) {
        try {
            // step1: Register Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step2: Create Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","vedant@555");

            // Step3: Create Query
            PreparedStatement pst = con.prepareStatement("select * from person");


            // step4
            ResultSet rs = pst.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Total no of Columns: "+rsmd.getColumnCount());
            System.out.println("Name of first column: "+rsmd.getColumnName(1));
            System.out.println("Name of first column: "+rsmd.getColumnType(1));

            // step:5

            con.close();



        }catch(Exception e) {

            System.out.println(e);

        }

    }

}
