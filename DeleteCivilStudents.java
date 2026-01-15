package assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStudent {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "232004";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database.");

            String deleteSQL = "DELETE FROM Students WHERE yop = ? AND branch = ?";
            PreparedStatement ps = con.prepareStatement(deleteSQL);

            ps.setInt(1, 2024);
            ps.setString(2, "Civil");

            int rows = ps.executeUpdate();
            System.out.println(rows + " record(s) deleted.");

            ps.close();
            con.close();
            System.out.println("Connection closed.");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}
