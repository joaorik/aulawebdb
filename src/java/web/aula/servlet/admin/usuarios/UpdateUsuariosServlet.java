package web.aula.servlet.admin.usuarios;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.aula.dao.RegistroDAO;
import web.aula.dao.UsuarioDAO;
import web.aula.models.Usuario;

public class UpdateUsuariosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final UsuarioDAO usuarios;

    public UpdateUsuariosServlet() {
        super();
        usuarios = new UsuarioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int ID = Integer.parseInt(request.getParameter("Id"));

        Usuario usuario = usuarios.peloID(ID);
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("/admin/usuarios/editar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Integer ID = Integer.parseInt(request.getParameter("id"));

        Usuario usuario = new Usuario();
        usuario.setId(ID);
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        usuarios.updateUsuario(usuario);

        RequestDispatcher res = request.getRequestDispatcher("/admin/usuarios/index.jsp");
        request.setAttribute("usuarios", usuarios.todosUsuarios());
        res.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Editar usuario";
    }

}
