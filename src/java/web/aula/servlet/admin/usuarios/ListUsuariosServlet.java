package web.aula.servlet.admin.usuarios;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.aula.dao.UsuarioDAO;

public class ListUsuariosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UsuarioDAO usuarios;
    
    public ListUsuariosServlet() {
        super();
        usuarios = new UsuarioDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("usuarios", usuarios.todosUsuarios());
        request.getRequestDispatcher("/admin/usuarios/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }
    
    @Override
    public String getServletInfo() {
        return "Lista usuarios";
    }

}
