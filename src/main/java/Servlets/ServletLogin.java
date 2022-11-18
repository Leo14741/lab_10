package Servlets;

import Beans.Cliente;
import Beans.Credentials;
import Daos.ClienteDaos;
import Daos.CredentialsDaos;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Login",  urlPatterns = {"/Login", ""})
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ?
                "loginform" : request.getParameter("action");

        RequestDispatcher view;

        switch (action) {
            case "loginform":
                view = request.getRequestDispatcher("InicioSesion.jsp");
                view.forward(request, response);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CredentialsDaos credentialsDaos = new CredentialsDaos();

        String username = request.getParameter("inputUsuario");
        String password = request.getParameter("inputPassword");

        Credentials credentials = credentialsDaos.validarUsuarioPassword(username,password);

        if(credentials != null){
            HttpSession session = request.getSession();
            session.setAttribute("usuarioSession", credentials);

            if(credentials.getTipoUsuario()==1){
                response.sendRedirect(request.getContextPath() + "/Admin");
            }else if(credentials.getTipoUsuario()==2){
                credentials.getNumeroDocumento();
                response.sendRedirect(request.getContextPath() + "/ClienteServlet?action=principal");
            }

        }else{
            response.sendRedirect(request.getContextPath() + "/Login?error");
        }

    }
}
