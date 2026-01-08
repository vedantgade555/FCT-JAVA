import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;

public class CallableStatementDemo2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            // step1: Register Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step2: Create Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","vedant@555");

            // Step3: Create Query

            CallableStatement stmt = con.prepareCall("{call sq_of_no(?,?)}");

            stmt.setInt(1,5);
            stmt.registerOutParameter(2,Types.DOUBLE);

            // step4

            stmt.execute();
            System.out.println("Square Of a no is "+stmt.getDouble(2));

            // step:5

            con.close();



        }catch(Exception e) {

            System.out.println(e);

        }

    }

}




//mysqlmysql> create procedure sq_of_no(IN no int,OUT square decimal)
//-> begin
//-> SET square = no*no;
//-> END//
