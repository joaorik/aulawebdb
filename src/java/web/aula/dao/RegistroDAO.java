package web.aula.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import web.aula.db.MySqlConnect;

public class RegistroDAO {
    
    private final Connection conn;
    
    public RegistroDAO() {
        conn = MySqlConnect.ConnectTo();
    }
    
    public Boolean valida(String nome, String email) {
        boolean status = false;

        try (PreparedStatement st = conn.prepareStatement("SELECT * FROM usuarios WHERE nome = ? AND email = ?")) {
            st.setString(1, nome);
            st.setString(2, email);

            try (ResultSet rs = st.executeQuery()) {
                status = rs.next();
            }
            
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        return status;
    }
}
