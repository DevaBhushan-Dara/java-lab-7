import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteRecordJDBC {

    // Database connection parameters (Adjust these according to your database setup)
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== JDBC Delete Record Demo ===");
        System.out.print("Enter Student ID to delete: ");
        int studentId = scanner.nextInt();

        // SQL DELETE statement with placeholder
        String deleteSQL = "DELETE FROM students WHERE id = ?";

        // Try-with-resources automatically closes the Connection and PreparedStatement
        try {
            // Step 1: (Optional in JDBC 4.0+) Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the database connection
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {

                System.out.println("Connected to the database successfully.");

                // Step 3: Set parameter values
                pstmt.setInt(1, studentId);

                // Step 4: Execute the DELETE query
                int rowsAffected = pstmt.executeUpdate();

                // Step 5: Check result
                if (rowsAffected > 0) {
                    System.out.println("Success: Record with ID " + studentId + " deleted successfully!");
                } else {
                    System.out.println("Notice: No record found with ID " + studentId + ".");
                }
            }

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found! Make sure the JDBC driver JAR is added to your classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
