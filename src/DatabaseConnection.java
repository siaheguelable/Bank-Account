package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // MySQL database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/userBankaccount?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root"; // Default XAMPP username
    private static final String PASSWORD = ""; // Default XAMPP password

    // Get a database connection
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database!");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
        return conn;
    }

    // Test connection
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connection successful!");
        } else {
            System.out.println("Connection failed!");
        }
    }
}
