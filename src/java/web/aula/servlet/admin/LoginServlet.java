package web.aula.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import web.aula.dao.LoginDAO;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final LoginDAO login;
    
    public LoginServlet() {
        super();
        login = new LoginDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        request.getRequestDispatcher("/auth/login.jsp").forward(request, response);
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        Boolean valido = login.valida(email, senha);
        
        if (valido) {
            
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            
            HttpSession newSession = request.getSession(true);
            newSession.setMaxInactiveInterval(30*60);
            
            request.getSession().setAttribute("sessao", true);
            request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Credenciais inválidas!");
            request.getRequestDispatcher("/auth/login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Pagina de login";
    }

}
