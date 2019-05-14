<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@ include file="../shared/_header.jsp" %>

<div class="container">
    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group" role="group" aria-label="First group">
            <div class="input-group-prepend">
                <h4 class="mb-3">Listado de ventas</h4>
            </div>
        </div>

        <div class="input-group">
            <a href="${pageContext.request.contextPath}/admin/ventas/fecha">
                <button type="button" class="btn btn-success btn-sm">Informes</button>
            </a>
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
            <th scope="col">Usuario</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${lines}" var="purchaseLine">
            <tr>
                <td scope="row">${purchaseLine.id}</td>
                <td width="100"><img class="card-img-top"
                                     src="${pageContext.request.contextPath}/electro/${purchaseLine.product.photo}"
                                     alt="foto producto"></td>
                <td width="280"> ${purchaseLine.product.name}</td>
                <td> ${purchaseLine.unitPrice}</td>
                <td> ${purchaseLine.count}</td>
                <td> ${purchaseLine.purchasePrice}</td>
                <td> ${purchaseLine.date.time.toLocaleString().substring(0,11)}</td>
                <td> Tarjeta</td>
                <td> ${purchaseLine.user.username}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

</div>

<p>&nbsp;</p>
<p>&nbsp;</p>

<%@ include file="../shared/_js.jsp" %>
<%--Script DataTABLE--%>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/table.js"></script>
<%@ include file="../shared/_footer.jsp" %>

