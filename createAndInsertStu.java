import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateStudentTable {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "122004";

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, password);

            statement = connection.createStatement();

            // Create Students table
            String createTableQuery =
                    "CREATE TABLE IF NOT EXISTS Students (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "marks INT)";

            statement.executeUpdate(createTableQuery);
            System.out.println("Students table created successfully");

            // Insert records
            String insertQuery1 =
                    "INSERT INTO Students VALUES (1, 'Amit', 85)";
            String insertQuery2 =
                    "INSERT INTO Students VALUES (2, 'Neha', 90)";
            String insertQuery3 =
                    "INSERT INTO Students VALUES (3, 'Rahul', 78)";

            statement.executeUpdate(insertQuery1);
            statement.executeUpdate(insertQuery2);
            statement.executeUpdate(insertQuery3);

            System.out.println("Student records inserted successfully");

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
                System.out.println("Error while closing resources");
            }
        }
    }
}
