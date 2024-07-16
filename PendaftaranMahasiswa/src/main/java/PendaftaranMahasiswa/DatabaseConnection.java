package PendaftaranMahasiswa;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection getConnection() {
        try {
           
            String url = "jdbc:mysql://localhost:3306/pendaftaranmahasiswa";
            
           
            String username = "root";
            String password = "";

           
            Class.forName("com.mysql.cj.jdbc.Driver");

           
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
