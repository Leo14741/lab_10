package Servlets;

import Beans.Credentials;
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

        Credentials credentials = credentialsDaos.validarUsuarioPassword(username, password);

        if(credentials != null){
            HttpSession session = request.getSession();
            session.setAttribute("usuarioSession", credentials);

            //Validar que sea 1 o 2

            response.sendRedirect(request.getContextPath());
        }else{
            response.sendRedirect(request.getContextPath() + "/LoginServlet?error");
        }

    }
}
