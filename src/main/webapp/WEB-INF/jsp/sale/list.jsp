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
            <a href="${pageContext.request.contextPath}/user/registration">
                <button type="button" class="btn btn-success btn-sm">Añadir Cliente</button>
            </a>
        </div>
    </div>

    <div class="border-top my-3"></div>

    <table id="example" class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Producto</th>
            <th scope="col">Descripción</th>
            <th scope="col">Ud.</th>
            <th scope="col">Importe</th>
            <th scope="col">Fecha</th>
            <th scope="col">Pago</th>
            <th scope="col">Usuario</th>
            <th scope="col">Acciones</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">

            <tr>
               <%-- <td scope="row">${user.id}</td>
                <td>${user.name}</td>
                <td>${user.lastname1}</td>
                <td>${user.direction}</td>
                <td>${user.city}</td>
                <td>${user.postalCode}</td>
                    &lt;%&ndash;<td>${user.province}</td>&ndash;%&gt;
                    &lt;%&ndash;<td>${user.country}</td>&ndash;%&gt;
                <td>${user.email}</td>
                    &lt;%&ndash;<td>${user.phone}</td>&ndash;%&gt;
                <td>${user.username}</td>
                <td>
                    <div class="btn-group">
                        <a class="btn btn-sm btn-outline-info" role="button"
                           href="${pageContext.request.contextPath}/user/editar/${user.username}">Edit</a>
                        <a class="btn btn-sm btn-outline-danger" role="button"
                           href="${pageContext.request.contextPath}/user/delete/${user.username}">DEL</a>
                    </div>
                </td>--%>
            </tr>

        </c:forEach>
        </tbody>
    </table>

</div>

<p>&nbsp;</p>
<p>&nbsp;</p>

<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>

