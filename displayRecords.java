package assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayECStudents {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "232004";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database.");


            String selectSQL =
                    "SELECT * FROM Students WHERE semester = ? AND branch = ?";

            PreparedStatement ps = con.prepareStatement(selectSQL);
            ps.setInt(1, 7);
            ps.setString(2, "EC");

            ResultSet rs = ps.executeQuery();

            System.out.println("\nStudents of Semester 7 (EC):");
            System.out.println("--------------------------------");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                        "ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Branch: " + rs.getString("branch") +
                        ", Semester: " + rs.getInt("semester") +
                        ", Marks: " + rs.getInt("marks")
                );
            }

            if (!found) {
                System.out.println("No records found.");
            }

            // Close resources
            rs.close();
            ps.close();
            con.close();
            System.out.println("\nConnection closed.");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}
