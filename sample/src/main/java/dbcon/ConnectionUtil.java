package dbcon;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", "Razak@123");
    }
}
