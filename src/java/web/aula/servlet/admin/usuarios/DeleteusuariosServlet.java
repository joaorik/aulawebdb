package web.aula.servlet.admin.usuarios;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.aula.dao.UsuarioDAO;

public class DeleteusuariosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final UsuarioDAO usuarios;

    public DeleteusuariosServlet() {
        super();
        usuarios = new UsuarioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int ID = Integer.parseInt(request.getParameter("Id"));

        usuarios.deleteUsuario(ID);

        RequestDispatcher res = request.getRequestDispatcher("/admin/usuarios/index.jsp");
        request.setAttribute("usuarios", usuarios.todosUsuarios());
        res.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Deletar usuario";
    }

}
