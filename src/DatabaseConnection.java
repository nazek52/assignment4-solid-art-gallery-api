import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/gallery.db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Ilovemath8";

    private static Connection connection;

    private DatabaseConnection() {
        
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connected successfully");
            } catch (SQLException e) {
                throw new RuntimeException(
                        "Failed to connect to database", e
                );
            }
        }
        return connection;
    }
}
