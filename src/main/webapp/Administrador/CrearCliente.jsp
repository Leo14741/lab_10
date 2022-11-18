<%--
  Created by IntelliJ IDEA.
  User: DANA
  Date: 17/11/2022
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <em class="tm-tagline tm-color-light-gray">
        Bienvenido Administrador
    </em>
</header>
<div style="height: 100px; display: block;"></div>
<div>
    <h2 style="margin-left: 100px; color: #309afd"> Crear Cliente</h2>

    <div style="height: 30px; display: block;"></div>
    <div class="row">
        <div class="col-md-2 col-sm-2"></div>
        <div class="col-sm-4 col-md-4>">
            <div style="height: 5px; display: block; color: #98999a; font-weight: bold">
                Nombre
            </div>
        </div>
        <div class="col-sm-4 col-md-4">
            <input type="email" class="form-control" id="exampleFormControlInput" placeholder="name@example.com">
        </div>
        <div class="col-md-2 col-sm-2"></div>
    </div>
    <div class="row">
        <div class="col-md-2 col-sm-2"></div>
        <div class="col-sm-4 col-md-4>">
            <div style="height: 5px; display: block; color: #98999a; font-weight: bold">
                Edad
            </div>
        </div>
        <div class="col-sm-4 col-md-4">
            <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
        </div>
        <div class="col-md-2 col-sm-2"></div>
    </div>
    <div class="row">
        <div class="col-md-2 col-sm-2"></div>
        <div class="col-sm-4 col-md-4>">
            <div style="height: 5px; display: block; color: #98999a; font-weight: bold">
                Tipo de Cliente
            </div>
        </div>
        <div class="col-sm-4 col-md-4">
            <input type="email" class="form-control" id="exampleFormControlInput2" placeholder="name@example.com">
        </div>
        <div class="col-md-2 col-sm-2"></div>
    </div>
    <div class="row">
        <div class="col-md-2 col-sm-2"></div>
        <div class="col-sm-4 col-md-4>">
            <div style="height: 5px; display: block; color: #98999a; font-weight: bold">
                Tipo de Documento
            </div>
        </div>
        <div class="col-sm-4 col-md-4">
            <input type="email" class="form-control" id="exampleFormControlInput3" placeholder="name@example.com">
        </div>
        <div class="col-md-2 col-sm-2"></div>
    </div>
    <div style="height: 30px; display: block;"></div>
    <div class="row">
        <div class="col-md-2 col-sm-2"></div>
        <div class="col-sm-4 col-md-4">
            <div style="height: 5px; display: block; color: #98999a; font-weight: bold">
                Número de Documento
            </div>
        </div>
        <div class="col-sm-4 col-md-4">
            <select style="border-color: #ced4da">
                <%=for (Cliente cliente: listaClientes)%>
                <option selected>---</option>
                <option value="1">cliente</option>
            </select>
        </div>
        <div class="col-md-2 col-sm-2"></div>
    </div>
</div>

<div style="height: 200px; display: block;"></div>
<footer class="tm-footer">
    <span>Copyright &copy; 2020 Laboratorio 10</span>
    <span>Web Designed by Dana Nolasco, Leonardo Abanto</span>
</footer>
</body>
</html>
