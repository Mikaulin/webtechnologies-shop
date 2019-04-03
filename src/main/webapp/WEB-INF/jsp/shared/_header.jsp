<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/" var="indexUrl"/>
<fmt:setLocale value="es_ES"/>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>ElectroHOME | Tienda de electrodomésticos online</title>

    <%--DataTABLE--%>
    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.dataTables.min.css"/>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop.css">
    <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.png"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sticky-footer.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
</head>

<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/img/logo.png"
                                              alt="logo ElectroHOME"></a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample07"
                aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarContainer">
            <ul class="nav navbar-nav float-right nav-top">

                <li>
                    <a href="${pageContext.request.contextPath}/carrito" class="trsn nav-link" title="Comprobar compras">
                        <i class="fa fa-shopping-cart"></i>
                        <span id="nav-bar-cart"> <span id="total-products">0</span> Producto(s)
                    </a>
                </li>

                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li>
                        <a href="${pageContext.request.contextPath}/user/detail/${pageContext.request.userPrincipal.name}" id="account-link" class="trsn nav-link"
                           title="Mi cuenta">
                            <i class="fa fa-user fa-fw"></i>
                            <span class="customer-name">Hola, ${pageContext.request.userPrincipal.name}</span>
                        </a>
                    </li>
                    <li>
                        <form id="logoutForm" method="POST" action="${contextPath}/logout">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                        <a onclick="document.forms['logoutForm'].submit()" class="trsn nav-link"
                           style="cursor: pointer;">
                            <i class="fa fa-sign-out fa-fw"></i>
                            <span>Salir</span>
                        </a>
                    </li>
                </c:if>

                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li>
                        <a href="${pageContext.request.contextPath}/user/login" id="login-link" class="trsn nav-link"
                           title="Iniciar sesión">
                            <i class="fa fa-user fa-fw"></i>
                            <span class="customer-name">&Aacute;rea de cliente </span>
                        </a>
                    </li>
                </c:if>

            </ul>
        </div>
    </div>
</nav>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">


        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample07"
                aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarsExample07">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">B&uacute;squeda</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown01">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/categorias">Categor&iacute;a</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/marcas">Marcas</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/producto/valoraciones">Valoraci&oacute;n</a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown07" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">Promociones</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown07">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/promociones">Promo Activas</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/promociones/altaPromociones">Alta
                            Promocion</a>
                        <a class="dropdown-item"
                           href="${pageContext.request.contextPath}/promociones/listado">Listado</a>
                    </div>
                </li>

                <li class="nav-item">
                    <a class="nav-link " href="${pageContext.request.contextPath}/servicios">Servicios</a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown06" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">Ventas</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown06">
                        <a class="dropdown-item" href="#">Devoluciones</a>
                        <a class="dropdown-item" href="#">Informes</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/producto/ventas/listado">Listado</a>

                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown02" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">Productos</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown02">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/producto/alta">Alta
                            Producto</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/producto/listado">Listado</a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown03" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">Clientes</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown03">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/user/registration">Alta
                            Usuario</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/user/usuarios">Listado</a>
                        <a class="dropdown-item" href="#">Histórico</a>
                    </div>
                </li>


                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown05" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">Documentación</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown05">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/memoria">Memoria</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/manual">Manual</a>
                        <a class="dropdown-item" href="#">Javadoc</a>
                    </div>
                </li>
            </ul>

            <form class="form-inline my-2 my-md-0">
                <input class="form-control" type="text" placeholder=" Qu&eacute; est&aacute;s buscando ?"
                       aria-label="Search">
            </form>
        </div>
    </div>
</nav>


<p>&nbsp;</p>

