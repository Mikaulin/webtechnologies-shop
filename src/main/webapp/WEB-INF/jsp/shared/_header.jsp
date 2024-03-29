<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:url value="/" var="indexUrl"/>
<fmt:setLocale value="es_ES"/>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>ElectroHOME | Tienda de electrodomésticos online</title>
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
        <a class="navbar-brand" href="${pageContext.request.contextPath}/"><img
                src="${pageContext.request.contextPath}/img/logo.png"
                alt="logo ElectroHOME"></a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample07"
                aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarContainer">
            <ul class="nav navbar-nav float-right nav-top">

                <li>
                    <a href="${pageContext.request.contextPath}/carrito" class="trsn nav-link"
                       title="Comprobar compras">
                        <i class="fa fa-shopping-cart"></i>
                        <span id="nav-bar-cart"> <span id="total-products">0</span> Producto(s)</span>
                    </a>
                </li>

                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li>
                        <a href="${pageContext.request.contextPath}/usuarios/detalles/${pageContext.request.userPrincipal.name}"
                           id="account-link" class="trsn nav-link"
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
                        <a href="${pageContext.request.contextPath}/usuarios/login" id="login-link"
                           class="trsn nav-link"
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
                        <a class="dropdown-item"
                           href="${pageContext.request.contextPath}/categorias">Categor&iacute;a</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/marcas">Marcas</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/producto/valoraciones">Valoraci&oacute;n</a>
                    </div>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/promociones">Promociones activas</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/servicios">Servicios</a>
                </li>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown03" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">Clientes</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown03">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/usuarios/alta">Alta
                                Usuario</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/usuarios/listado">Listado</a>
                        </div>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown02" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">Productos</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown02">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/producto/alta">Alta
                                Producto</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/producto/listado">Listado</a>

                        </div>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="admin-promo" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">Promociones</a>
                        <div class="dropdown-menu" aria-labelledby="admin-promo">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/promociones/crear">Alta
                                Promocion</a>
                            <a class="dropdown-item"
                               href="${pageContext.request.contextPath}/admin/promociones/listado">Listado</a>
                        </div>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown06" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">Ventas</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown06">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/ventas/fecha">Informes</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/ventas/listado">Listado</a>

                        </div>
                    </li>

                </sec:authorize>

            </ul>

            <div class=" my-2 my-md-0">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown08" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">Documentación</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown08">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/memoria">Memoria</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/manual">Manual</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/javadoc/index.html"
                               target="_blank">Javadoc</a>
                        </div>
                    </li>
                </ul>
            </div>


        </div>
    </div>
</nav>


<p>&nbsp;</p>

