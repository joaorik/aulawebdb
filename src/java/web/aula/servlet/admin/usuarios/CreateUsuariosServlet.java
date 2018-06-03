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

public class CreateUsuariosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final UsuarioDAO usuarios;
    private final RegistroDAO registros;

    public CreateUsuariosServlet() {
        super();
        usuarios = new UsuarioDAO();
        registros = new RegistroDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/admin/usuarios/adicionar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Boolean existe = registros.valida(nome, email);

        if (existe) {
            request.setAttribute("error", "Usuario com esses dados já existe!");
            request.getRequestDispatcher("/admin/usuarios/adicionar.jsp").forward(request, response);
        } else {
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);

            usuarios.createUsuario(usuario);

            RequestDispatcher res = request.getRequestDispatcher("/admin/usuarios/index.jsp");
            request.setAttribute("usuarios", usuarios.todosUsuarios());
            request.setAttribute("success", "Usuario cadastrado com sucesso!");
            res.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Cadastrar usuario";
    }

}
