import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionDemo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("Connection Successful");
            } else {
                System.out.println("Unable to connect");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found");
            
        } catch (SQLException e) {
            System.out.println("Unable to connect");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error while closing connection");
            }
        }
    }
}
