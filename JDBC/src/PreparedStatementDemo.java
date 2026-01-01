import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        try{
            // Step 1: Register Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","vedant@555");

            // Step 3: Create Query

            PreparedStatement pst = con.prepareStatement("INSERT INTO person VALUES (?,?,?)");
            // no of ? is depend on no of columns

            pst.setInt(1,104);
            pst.setString(2,"Raghav");
            pst.setInt(3,25);

            // Step 4
            int i = pst.executeUpdate();

            System.out.println("Record Inserted");

            // Step 5
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
