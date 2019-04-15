<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group" role="group" aria-label="First group">
            <div class="input-group-prepend">

                <c:set var="now" value="${date}"/>

                <h4 class="mb-3">Informe de ventas
                    <small> ( fecha seleccionada:
                        <small>
                            <b><c:out value="${now.substring(8,10)}-${now.substring(5,7)}-${now.substring(0,4)}"/></b>
                        </small>
                        )
                    </small>
                </h4>
            </div>
        </div>

        <div class="input-group">
            <a href="${pageContext.request.contextPath}/ventas/fecha">
                <button type="button" class="btn btn-success btn-sm">Nuevo Informe</button>
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
            <th scope="col">Importe</th>
            <th scope="col">F. pago</th>
            <th scope="col">Usuario</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${lines}" var="sale">

            <c:if test="${
                     sale.date.toLocaleString().substring(7,11) eq now.substring(0,4)
                    and sale.date.month+1 eq now.substring(5,7)
                    and sale.date.toLocaleString().substring(0,2) eq now.substring(8,10)}">

                <tr>
                    <td>
                        <span>${sale.id}</span>
                    </td>

                    <td width="100" class="text-center hidden-xs-down">
                        <a href="${pageContext.request.contextPath}/producto/detalle/${sale.product.id}">
                            <img class="card-img-top" alt="${sale.product.name}"
                                 src="${pageContext.request.contextPath}/electro/${sale.product.photo}"></a>
                    </td>
                    <td width="280">
                        <span>${sale.product.name}</span>
                    </td>
                    <td>
                        <span class="order-product-price"> ${sale.product.finalPrice} &euro;</span>
                    </td>
                    <td>
                        <span class="order-product-price"> ${sale.count}</span>
                    </td>
                    <td>
                            <%--TODO calcular bien AQUI el precio final.--%>
                        <span class="order-product-subtotal">${sale.purchasePrice} &euro;</span>
                    </td>
                    <td>
                        <span>Tarjeta</span>
                    </td>
                    <td>
                        <div class="btn-group">

                            <a class="btn btn-sm btn-outline-secondary" role="button"
                               href="${pageContext.request.contextPath}/ventas/historial/${sale.user.username}">${sale.user.username}</a>
                        </div>
                    </td>
                </tr>

            </c:if>
        </c:forEach>

        </tbody>
    </table>


    <div class="border-top my-3"></div>


    <p>&nbsp;</p>

</div>

<p>&nbsp;</p>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>