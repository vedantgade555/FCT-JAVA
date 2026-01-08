import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.FileInputStream;

class ImgStoreDemo {

    public static void main(String[] args) {

        try {
            // Step 1: Register Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javadb",
                    "root",
                    "vedant@555"
            );

            // Step 3: Prepare SQL Query
            PreparedStatement stmt =
                    con.prepareStatement("INSERT INTO imgtable(name, profile_pic) VALUES (?, ?)");

            stmt.setString(1, "Vedant");

            // Step 4: Read Image
            FileInputStream input =
                    new FileInputStream("C:\\Users\\Arnav Gade\\Downloads\\download.jpg");

            stmt.setBinaryStream(2, input);

            // Step 5: Execute Query
            stmt.executeUpdate();

            System.out.println("Image inserted successfully 👍");

            // Step 6: Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
