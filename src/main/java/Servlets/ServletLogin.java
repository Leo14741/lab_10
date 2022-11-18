package Servlets;

import Beans.Cliente;
import Daos.ClienteDaos;
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
        ClienteDaos clienteDaos = new ClienteDaos();

        String username = request.getParameter("inputUsuario");
        String password = request.getParameter("inputPassword");

        Cliente cliente = clienteDaos.validarUsuarioPassword(username, password);

        if(cliente != null){
            HttpSession session = request.getSession();
            session.setAttribute("usuarioSession", cliente);

            //Validar que sea 1 o 2

            response.sendRedirect(request.getContextPath());
        }else{
            response.sendRedirect(request.getContextPath() + "/LoginServlet?error");
        }

    }
}
