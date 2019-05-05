<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@ include file="../shared/_header.jsp" %>

<%--Script DataTABLE--%>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/table.js"></script>

<div class="container">

    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group" role="group" aria-label="First group">
            <div class="input-group-prepend">
                <h4 class="mb-3">Listado de clientes</h4>
            </div>
        </div>

        <div class="input-group">
            <a href="${pageContext.request.contextPath}/admin/usuarios/alta">
                <button type="button" class="btn btn-success btn-sm">Añadir Cliente</button>
            </a>
        </div>
    </div>

    <div class="border-top my-3"></div>

    <table id="example" class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Nombre</th>
            <th scope="col">Apellidos</th>
            <th scope="col">Direcci&oacute;n</th>
            <th scope="col">Ciudad</th>
            <th scope="col">Cp</th>
            <%--<th scope="col">Provincia</th>--%>
            <%--<th scope="col">Pais</th>--%>
            <th scope="col">Email</th>
            <%--<th scope="col">Tlf</th>--%>
            <th scope="col">Usuario</th>
            <th scope="col">Alta/baja</th>
            <th scope="col">Acciones</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">

            <tr>
                <td scope="row">${user.id}</td>
                <td>${user.name}</td>
                <td>${user.lastname1}</td>
                <td>${user.direction}</td>
                <td>${user.city}</td>
                <td>${user.postalCode}</td>
                    <%--<td>${user.province}</td>--%>
                    <%--<td>${user.country}</td>--%>
                <td>${user.email}</td>
                    <%--<td>${user.phone}</td>--%>
                <td >${user.username}</td>
                <c:if test="${user.deleted}">
                    <td class="text-danger">BAJA</td>
                </c:if>
                <c:if test="${!user.deleted}">
                    <td>ALTA</td>
                </c:if>


                <td>
                    <div class="btn-group">
                        <a class="btn btn-sm btn-outline-info" role="button"
                           href="${pageContext.request.contextPath}/admin/usuarios/editar/${user.username}">Editar</a>
                        <a class="btn btn-sm btn-outline-secondary" role="button"
                           href="${pageContext.request.contextPath}/admin/ventas/historial/${user.username}">Ventas</a>
                        <c:if test="${!user.deleted}">
                        <a class="btn btn-sm btn-outline-danger" role="button"
                           href="${pageContext.request.contextPath}/admin/usuarios/baja/${user.username}">Baja</a>
                        </c:if>
                        <c:if test="${user.deleted}">
                            <a class="btn btn-sm btn-outline-danger disabled" role="button"
                               href="${pageContext.request.contextPath}/admin/usuarios/baja/${user.username}">Baja</a>
                        </c:if>
                    </div>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>

</div>

<p>&nbsp;</p>
<p>&nbsp;</p>

<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>
