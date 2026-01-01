import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.FileOutputStream;

public class ImgReadDemo {

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
                    con.prepareStatement("SELECT * FROM imgtable");

            // Step 4: Execute Query
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Step 5: Get image from DB
                Blob b = rs.getBlob(2);
                byte[] barr = b.getBytes(1, (int) b.length());

                // Step 6: Write image to file
                FileOutputStream fos =
                        new FileOutputStream("E:\\output.jpg");
                fos.write(barr);
                fos.close();

                System.out.println("Image read successfully 👍");
            }

            // Step 7: Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
