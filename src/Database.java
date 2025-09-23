package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    public static void saveUser(User user) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                String sql = "INSERT INTO users (firstname, lastname, email, balance, password, accountNumber) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, user.getFirstname());
                pstmt.setString(2, user.getLastname());
                pstmt.setString(3, user.getEmail());
                pstmt.setDouble(4, user.getBalance());
                pstmt.setString(5, user.getUserPassword());
                pstmt.setString(6, user.getAccountNumber());
                pstmt.executeUpdate();
                System.out.println("User saved to database.");
            }
        } catch (SQLException e) {
            System.out.println("Error saving user to database.");
            e.printStackTrace();
        }
    }

    public static void updateUserBalance(User user) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                String sql = "UPDATE users SET balance = ? WHERE email = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setDouble(1, user.getBalance());
                pstmt.setString(2, user.getEmail());
                pstmt.executeUpdate();
                System.out.println("User balance updated in database.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating user balance in database.");
            e.printStackTrace();
        }
    }

    public static void deleteUser(String email) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                String sql = "DELETE FROM users WHERE email = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, email);
                pstmt.executeUpdate();
                System.out.println("User deleted from database.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting user from database.");
            e.printStackTrace();
        }
    }

    public static void listUsers() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                String sql = "SELECT firstname, lastname, email, balance, accountNumber FROM users";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                System.out.println("List of users:");
                while (rs.next()) {
                    System.out.println("Name: " + rs.getString("firstname") + " " + rs.getString("lastname")
                            + ", Email: " + rs.getString("email")
                            + ", Balance: $" + rs.getDouble("balance")
                            + ", Account Number: " + rs.getString("accountNumber"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error listing users from database.");
            e.printStackTrace();
        }
    }

    public static void saveAdmin(String adminUsername, String adminPassword) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                String sql = "INSERT INTO admin (adminUsername, adminPassword) VALUES (?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, adminUsername);
                pstmt.setString(2, adminPassword);
                pstmt.executeUpdate();
                System.out.println("Admin saved to database.");
            }
        } catch (SQLException e) {
            System.out.println("Error saving admin to database.");
            e.printStackTrace();
        }
    }
}
