import java.sql.*;

public class BatchProcessingDemo {

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

            // Disable auto-commit
            con.setAutoCommit(false);

            // Step 3: Create Statement
            Statement stmt = con.createStatement();

            // Step 4: Add SQL queries to batch
            stmt.addBatch("INSERT INTO person(id, name, age) VALUES (106,'Sam',74)");
            stmt.addBatch("INSERT INTO person(id, name, age) VALUES (107,'John',75)");

            // Step 5: Execute batch
            stmt.executeBatch();

            // Step 6: Commit transaction
            con.commit();

            // Close resources
            stmt.close();
            con.close();

            System.out.println("Batch executed successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
