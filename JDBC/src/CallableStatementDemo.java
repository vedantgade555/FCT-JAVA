

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CallableStatementDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            // step1: Register Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step2: Create Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","vedant@555");

            // Step3: Create Query

            CallableStatement stmt = con.prepareCall("{call delete_from_person(?)}");
            stmt.setInt(1,104);

            // step4

            stmt.execute();
            System.out.println("Deleted Sucessfully");

            // step:5

            con.close();



        }catch(Exception e) {

            System.out.println(e);

        }

    }

}




//mysql> delimiter //
//mysql> create procedure delete_from_person(IN no int)
//    -> begin
//    -> DELETE FROM PERSON WHERE id=no;
//    -> END//
//Query OK, 0 rows affected (0.02 sec)
