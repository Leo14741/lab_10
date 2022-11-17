package Servlets;

import Beans.Cliente;
import Daos.ClienteDaos;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletCliente", value = "/ServletCliente")
public class ServletCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        action = (action == null) ? "listar" : action;
        RequestDispatcher requestDispatcher;
        ClienteDaos daoClientes = new ClienteDaos();
        ArrayList<Cliente> list = daoClientes.listarClientes();

        switch (action){
            case "listar":
                request.setAttribute("lista", daoClientes.listarClientes());

                requestDispatcher = request.getRequestDispatcher("clientes/lista.jsp");
                requestDispatcher.forward(request, response);
            case "crear":
                requestDispatcher = request.getRequestDispatcher("clientes/formCrear.jsp");
                requestDispatcher.forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
