package Servlets;

import Beans.Cliente;
import Daos.ClienteDaos;
import Daos.ContratoDaos;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletCliente",  urlPatterns = {"/ClienteServlet","/Cliente"})
public class ServletCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ? "principal" : request.getParameter("action");
        RequestDispatcher requestDispatcher;
        ClienteDaos daoClientes = new ClienteDaos();
        ContratoDaos daoContratos = new ContratoDaos();
        ArrayList<Cliente> list = daoClientes.listarClientes();
        request.getAttribute("usuarioSession");
        String cliente_id = null;
        switch (action){
            case "principal":
                requestDispatcher = request.getRequestDispatcher("Cliente/PrincipalCliente.jsp");
                requestDispatcher.forward(request, response);
            case "listarContratos":
                request.setAttribute("listContratos", daoContratos.listarContratos());
                requestDispatcher = request.getRequestDispatcher("Cliente/ListarMisContratos.jsp");
                requestDispatcher.forward(request, response);
            case "misDatos":

                request.setAttribute("cliente", daoClientes.buscarCliente());
                requestDispatcher = request.getRequestDispatcher("Cliente/MisDatos.jsp");
                requestDispatcher.forward(request, response);
            case "mostrarCantContrat":
                request.setAttribute("cantContratos", daoContratos.mostrarCantidadContratos());
                requestDispatcher = request.getRequestDispatcher("Cliente/MostrarCantContratos.jsp");
                requestDispatcher.forward(request, response);
            case "mostrarMaxEL":
                requestDispatcher = request.getRequestDispatcher("Cliente/MostrarMaxExpecetedLoss.jsp");
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
