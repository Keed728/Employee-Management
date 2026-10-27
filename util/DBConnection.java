package employee_management.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private static final Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("D:\\Claude-Project\\JDBC_steps\\src\\main\\resources\\db.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                properties.getProperty("employee.db.url"),
                properties.getProperty("employee.db.usr").trim(),
                properties.getProperty("employee.db.pwd").trim());
    }
}
