package web.aula.servlet.admin.usuarios;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.aula.dao.UsuarioDAO;
import web.aula.models.Usuario;

public class SearchUsuariosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final UsuarioDAO usuarios;

    public SearchUsuariosServlet() {
        super();
        usuarios = new UsuarioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/admin/usuarios/pesquisar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");

        ArrayList<Usuario> usuario = usuarios.pesquisar(nome, email);

        request.setAttribute("usuarios", usuario);
        request.getRequestDispatcher("/admin/usuarios/pesquisar.jsp").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Pesquisar usuario";
    }

}
