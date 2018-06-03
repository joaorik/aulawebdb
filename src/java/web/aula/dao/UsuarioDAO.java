package web.aula.dao;

import web.aula.db.MySqlConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import web.aula.models.Usuario;

public class UsuarioDAO {

    private final Connection conn;

    public UsuarioDAO() {
        conn = MySqlConnect.ConnectTo();
    }

    public void createUsuario(Usuario usuario) {
        try (PreparedStatement st = conn.prepareStatement("INSERT INTO usuarios(nome, email, senha) VALUES(? ,?, ?)")) {
            st.setString(1, usuario.getNome());
            st.setString(2, usuario.getEmail());
            st.setString(3, usuario.getSenha());
            st.executeUpdate();

            st.close();

        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

    public void updateUsuario(Usuario usuario) {
        try (PreparedStatement st = conn.prepareStatement("UPDATE usuarios SET nome = ?, email = ?, senha = ? WHERE id = ?")) {
            st.setString(1, usuario.getNome());
            st.setString(2, usuario.getEmail());
            st.setString(3, usuario.getSenha());
            st.setInt(4, usuario.getId());
            st.executeUpdate();

            st.close();

        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

    public void deleteUsuario(int usuario_id) {
        try (PreparedStatement st = conn.prepareStatement("DELETE FROM usuarios WHERE id = ?")) {
            st.setInt(1, usuario_id);
            st.executeUpdate();

            st.close();

        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

    }

    public List<Usuario> todosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        ResultSet rs;

        try (PreparedStatement st = conn.prepareStatement("SELECT * FROM usuarios")) {
            rs = st.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuarios.add(usuario);
            }

            rs.close();
            st.close();

        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        return usuarios;
    }

    public Usuario peloID(int usuario_id) {
        Usuario usuario = new Usuario();

        ResultSet rs;
        try (PreparedStatement st = conn.prepareStatement("SELECT * FROM usuarios WHERE id = ?")) {
            st.setInt(1, usuario_id);
            rs = st.executeQuery();
            if (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
            }
            rs.close();

        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        return usuario;
    }

    public ArrayList<Usuario> pesquisar(String nome, String email) {

        ArrayList al = null;
        ArrayList pid_list = new ArrayList();

        try {
            String sql = "SELECT * FROM usuarios WHERE nome LIKE ? OR email LIKE ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + nome + "%");
            st.setString(2, "%" + email + "%");
            ResultSet rs = st.executeQuery();

            System.out.println("Query " + st);

            while (rs.next()) {
                al = new ArrayList();

                al.add(Integer.parseInt(rs.getString(1)));
                al.add(rs.getString(2));
                al.add(rs.getString(3));
                al.add(rs.getString(4));

                System.out.println("all :: " + al);
                pid_list.add(al);
            }

        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        return pid_list;
    }

}
