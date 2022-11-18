<%@ page import="Beans.Contrato" %><%--
  Created by IntelliJ IDEA.
  User: DANA
  Date: 17/11/2022
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listContratos" scope="request" type="java.util.ArrayList<Beans.Contrato>"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OCEAN vibes by TemplateMo</title>
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap" rel="stylesheet"> <!-- https://fonts.google.com/ -->
    <link rel="stylesheet" href="../fontawesome/css/all.min.css"> <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="../css/magnific-popup.css">
    <link rel="stylesheet" href="../css/templatemo-ocean-vibes.css">
    <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</head>
<body>
<header class="tm-site-header">
    <h1 class="tm-mt-0 tm-mb-15"><span class="tm-color-primary">El Banco</span> <span class="tm-color-gray-2"> del Perú</span></h1>
    <em class="tm-tagline tm-color-light-gray">Bienvenido Cliente (Nombre del cliente)</em>
</header>
<div style="height: 100px; display: block;"></div>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <table class="table" style="margin: 20px 50px 50px 50px">
            <tr style="color: #309AFD">
                <th>#</th>
                <th>idCliente</th>
                <th>Divisa</th>
                <th>Estado</th>
                <th>Meses en el Estado</th>
            </tr>
            <% for (Contrato contrato: listContratos){ %>
            <tr style="color: #9E9FA0">
                <td><%=contrato.getNroDeContrato()%></td>
                <td><%=contrato.getIdCliente()%></td>
                <td><%=contrato.getDivisa()%></td>
                <td><%=contrato.getEstado()%></td>
                <td><%=contrato.getMesesEnEseEstado()%></td>
            </tr>
            <% } %>
        </table>
    </div>
    <div class="col-md-1"></div>
</div>
<div style="height: 200px; display: block;"></div>
<footer class="tm-footer">
    <span>Copyright &copy; 2020 Laboratorio 10</span>
    <span>Web Designed by Dana Nolasco, Leonardo Abanto</span>
</footer>
</body>
</html>
