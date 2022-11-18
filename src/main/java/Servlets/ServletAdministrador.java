package Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletAdministrador", urlPatterns = {"/AdministradorServlet","/AdminServlet","/Admin","/Administrador"})
public class ServletAdministrador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "crearCliente" : request.getParameter("action");
        RequestDispatcher requestDispatcher;

        switch (action){
            case "crearCliente":
                requestDispatcher = request.getRequestDispatcher("/Administrador/CrearCliente.jsp");
                requestDispatcher.forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
