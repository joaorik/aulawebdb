package web.aula.db;

import java.sql.Connection;

public class TesteConexao {
    
    public static void main(String[] args) {
        Connection conn = new MySqlConnect().ConnectTo();
        System.out.println(conn);
    }
}
