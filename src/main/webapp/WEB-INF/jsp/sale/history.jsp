<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../shared/_header.jsp" %>

<%--Script DataTABLE--%>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/table.js"></script>

<div class="container">

    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group" role="group" aria-label="First group">
            <div class="input-group-prepend">
                <h4 class="mb-3">Histórico de ventas</h4>
            </div>
        </div>
        <div class="input-group">
            <a href="${pageContext.request.contextPath}/admin/usuarios/listado">
                <button type="button" class="btn btn-success btn-sm">Listado clientes</button>
            </a>
        </div>
    </div>

    <div class="border-top my-3"></div>

    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group" role="group" aria-label="First group">
            <h5 class="mb-3"><i class="fa fa-user fa-fw"></i><span
                    class="customer-name">${user.name} ${user.lastname1}</span>
            </h5>
        </div>

        <div class="input-group">
            <h5 class="mb-3"><span class="customer-name"><small><b>usuario:</b> ${user.username} |
                <b>email:</b> <a href="mailto:${user.email}">${user.email}</a></small></span>
            </h5>
        </div>
    </div>


    <div class="border-top my-3"></div>

    <table id="example" class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Producto</th>
            <th scope="col">Nombre</th>
            <th scope="col">Precio</th>
            <th scope="col">Cantidad</th>
            <th scope="col">importe</th>
            <th scope="col">Fecha</th>
            <th scope="col">F. Pago</th>
            <th scope="col">Acciones</th>

        </tr>
        </thead>
        <tbody>

        <c:forEach items="${lines}" var="sale">

            <tr>
                <td scope="row">${sale.id}</td>
                <td width="100"><img class="card-img-top" alt="${sale.product.name}"
                                     src="${pageContext.request.contextPath}/electro/${sale.product.photo}"></td>
                <td width="280"> ${sale.product.name}</td>
                <td> ${sale.unitPrice}</td>
                <td> ${sale.count}</td>
                <td> ${sale.purchasePrice}</td>
                <td> ${sale.date.time.toLocaleString().substring(0,11)}</td>
                <td> Tarjeta</td>
                <td>
                    <div class="btn-group">

                        <a class="btn btn-sm btn-outline-danger" role="button"
                           href="${pageContext.request.contextPath}/admin/ventas/detalle/${sale.id}">Devolver</a>
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