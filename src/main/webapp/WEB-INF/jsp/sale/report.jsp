<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group" role="group" aria-label="First group">
            <div class="input-group-prepend">


                <h4 class="mb-3">Informe de ventas
                    <small> ( fecha seleccionada:
                        <small>
                            <b><c:out value="${day}-${month}-${year}"/></b>
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
    <c:forEach items="${users}" var="user">

    <h1>${user.name}</h1>

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





                <tr>
                    <td>

                    </td>
             <c:forEach items="${user.getPurchaseByDate(date)}" var="sale">
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

             </c:forEach>



        </tbody>
    </table>
        <h3>Total facturacion para ${user.name} = ${user.getPruchaseTotalByDate(date)}</h3>

    </c:forEach>
    <div class="border-top my-3"></div>


    <p>&nbsp;</p>

</div>

<p>&nbsp;</p>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>