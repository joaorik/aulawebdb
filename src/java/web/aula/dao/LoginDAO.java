package web.aula.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import web.aula.db.MySqlConnect;

public class LoginDAO {

    private final Connection conn;

    public LoginDAO() {
        conn = MySqlConnect.ConnectTo();
    }

    public Boolean valida(String email, String senha) {
        boolean status = false;

        try (PreparedStatement st = conn.prepareStatement("SELECT * FROM usuarios WHERE email = ? AND senha = ?")) {
            st.setString(1, email);
            st.setString(2, senha);

            try (ResultSet rs = st.executeQuery()) {
                status = rs.next();
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        return status;
    }
}
