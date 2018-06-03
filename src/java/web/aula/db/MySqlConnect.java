package web.aula.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnect {
    
    public static Connection conn = null;
    
    public static Connection ConnectTo() {
        
        if (conn != null) {
            return conn;
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Mysql Driver Loaded...");
                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/aula07", "root", "");
                System.out.println("Connection OK!");
            } catch (SQLException sqle) {
                System.out.println("Database error connection: ");
            }  catch (ClassNotFoundException ex) {
                System.out.println("Class not found error: ");
            }
        }
        return conn;
        
    }
    
}
