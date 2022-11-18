<%--
  Created by IntelliJ IDEA.
  User: DANA
  Date: 17/11/2022
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="usuarioSession" type="Beans.Credentials" scope="session"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OCEAN vibes by TemplateMo</title>
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap" rel="stylesheet"> <!-- https://fonts.google.com/ -->
    <link rel="stylesheet" href="../fontawesome/css/all.min.css"> <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="../css/magnific-popup.css">
    <link rel="stylesheet" href="../css/templatemo-ocean-vibes.css">
</head>
<body>
<header class="tm-site-header">
    <h1 class="tm-mt-0 tm-mb-15">
        <span class="tm-color-primary">El Banco</span>
        <span class="tm-color-gray-2"> del Perú</span>
    </h1>
    <em class="tm-tagline tm-color-light-gray">
        Bienvenido Cliente


    </em>
</header>
<div style="height: 200px; display: block;"></div>
<div class="tm-container">
    <nav class="tm-main-nav">
        <ul id="inline-popups">
            <li class="tm-nav-item" style="font-size: 20px">
                <a class="tm-nav-link">
                    Mis Datos
                    <i class="fas fa-3x fa-water"></i>
                </a>
            </li>
            <li class="tm-nav-item">
                <a class="tm-nav-link" id="tm-gallery-link">
                    Listar mis Contratos
                    <i class="far fa-3x fa-images"></i>
                </a>
            </li>
            <li class="tm-nav-item">
                <a class="tm-nav-link">
                    Mostrar mis Contratos
                    <i class="fas fa-3x fa-tint"></i>
                </a>
            </li>
            <li class="tm-nav-item">
                <a class="tm-nav-link">
                    Máximo de Exp. Loss
                    <i class="far fa-3x fa-comments"></i>
                </a>
            </li>
        </ul>
    </nav>
</div>
<div style="height: 200px; display: block;"></div>
<footer class="tm-footer">
    <span>Copyright &copy; 2020 Laboratorio 10</span>
    <span>Web Designed by Dana Nolasco, Leonardo Abanto</span>
</footer>
</body>
</html>
