package Servlets;

import Beans.Cliente;
import Daos.ClienteDaos;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletCliente",  urlPatterns = {"/ClienteServlet"})
public class ServletCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        action = (action == null) ? "principal" : action;
        RequestDispatcher requestDispatcher;
        ClienteDaos daoClientes = new ClienteDaos();
        ArrayList<Cliente> list = daoClientes.listarClientes();

        switch (action){
            case "principal":
                requestDispatcher = request.getRequestDispatcher("Cliente/PrincipalCliente.jsp");
                requestDispatcher.forward(request, response);
            case "listar":
                request.setAttribute("lista", daoClientes.listarClientes());

                requestDispatcher = request.getRequestDispatcher("Cliente/ListarMisContratos.jsp");
                requestDispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        ClienteDaos daoCliente = new ClienteDaos();

        switch (action){
            case "buscar":
                String searchText = request.getParameter("searchText");

                ArrayList<Cliente> lista = daoCliente.buscarCliente(searchText);
                request.setAttribute("lista", lista);
                request.setAttribute("searchText", searchText);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Cliente/ListarMisContratos.jsp");
                requestDispatcher.forward(request, response);
                break;
        }
    }
}
