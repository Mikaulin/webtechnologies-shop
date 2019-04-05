<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group" role="group" aria-label="First group">
            <div class="input-group-prepend">
                <h4 class="mb-3">Informe de ventas </h4>
            </div>
        </div>

        <div class="input-group">

            <%--Para cambiar la fecha del informe, cambiar el java date--%>
            <c:set var="now" value="<%= new java.util.Date() %>"/>
            <fmt:formatDate type="date" value="${now}"/>
        </div>
    </div>

    <div class="border-top my-3"></div>

    <c:forEach items="${detailUser}" var="user">


        <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group" role="group" aria-label="First group">
                <h5 class="mb-3"><i class="fa fa-user fa-fw"></i><span
                        class="customer-name">${user.name} ${user.lastname1}</span>
                </h5>
            </div>

            <div class="input-group">
                <a href="${pageContext.request.contextPath}/user/editar/${user.username}">
                    <button type="button" class="btn btn-outline-secondary btn-sm">${user.username} <i
                            class="fa fa-chevron-right" aria-hidden="true"></i></button>
                </a>
            </div>
        </div>

        <table class="table">
            <thead>
            <tr>
                <th>Id</th>
                <th class="hidden-xs-down">Producto</th>
                <th>Descripci&oacute;n</th>
                <th class="hidden-xs-down">Precio</th>
                <th>Cantidad</th>
                <th>Importe</th>
                <th>F. pago</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${lines}" var="sale">

                <c:if test="${sale.user.username eq user.username}">

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
                            <span class="order-product-subtotal">${sale.product.finalPrice * sale.count} &euro;</span>
                        </td>
                        <td>
                            <span>Tarjeta</span>
                        </td>
                    </tr>

                </c:if>

            </c:forEach>


            </tbody>
        </table>

        <p>&nbsp;</p>

        <p>&nbsp;</p>

    </c:forEach>
    <hr class="my-3">

    <p>&nbsp;</p>


</div>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>
