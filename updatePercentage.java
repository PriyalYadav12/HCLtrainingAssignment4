import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class UpdateCSEStudentsMarks {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/clg";
        String username = "root";
        String password = "121020";

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, password);

            statement = connection.createStatement();

            // Update marks by 5% 
            String updateQuery =
                    "UPDATE Students " +
                    "SET marks = marks + (marks * 5 / 100) " +
                    "WHERE branch = 'CSE'";

            int rowsUpdated = statement.executeUpdate(updateQuery);

            if (rowsUpdated > 0) {
                System.out.println("Marks increased by 5% for CSE students");
            } else {
                System.out.println("No CSE students found");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found");
        } catch (SQLException e) {
            System.out.println("Database error occurred");
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.out.println("Error while closing connection");
            }
        }
    }
}
