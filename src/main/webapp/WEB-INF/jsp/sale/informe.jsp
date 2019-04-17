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

        <c:set value="${lines}" var="linea">

            <c:if test="${!linea.empty()}">

            <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
                <div class="btn-group" role="group" aria-label="First group">
                    <h5 class="mb-3">
                        <a class="btn btn-success btn-sm" href="#${user.username}" data-toggle="collapse"
                           role="button" aria-expanded="false" aria-controls="${user.username}">

                            <i class="fa fa-bars" aria-hidden="true"></i></a>
                        <span class="customer-name">&nbsp;&nbsp;${user.name} ${user.lastname1}
                    <small>[&nbsp;
                        <c:forEach items="${lines}" var="count2">
                            <c:if test="${user.username eq count2.user.username }">
                                <i class="fa fa-shopping-cart"></i>
                            </c:if>
                        </c:forEach>&nbsp;]
                    </small>
                   </span>
                    </h5>
                </div>
               <%-- <div class="input-group">
                    <a href="${pageContext.request.contextPath}/user/editar/${user.username}">
                        <button type="button" class="btn btn-outline-success btn-sm">${user.username} <i
                                class="fa fa-chevron-right" aria-hidden="true"></i></button>
                    </a>
                </div>--%>
            </div>




               <div class="collapse multi-collapse" id="${user.username}">

                <table id="example" class="table">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Producto</th>
                        <th scope="col">Descripci&oacute;n</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Importe</th>
                        <th scope="col">F. pago</th>

                    </tr>
                    </thead>
                    <tbody>

                   <c:forEach items="${lines}" var="sale2">

                        <c:if test="${sale2.user.username eq user.username }">
                            <tr>
                                <td>
                                    <span>${sale2.id}</span>
                                </td>

                                <td width="100" class="text-center hidden-xs-down">
                                    <a href="${pageContext.request.contextPath}/producto/detalle/${sale2.product.id}">
                                        <img class="card-img-top" alt="${sale2.product.name}"
                                             src="${pageContext.request.contextPath}/electro/${sale2.product.photo}"></a>
                                </td>
                                <td width="280">
                                    <span>${sale2.product.name}</span>
                                </td>
                                <td>
                                    <span class="order-product-price"> ${sale2.product.finalPrice} &euro;</span>
                                </td>
                                <td>
                                    <span class="order-product-price"> ${sale2.count}</span>
                                </td>
                                <td>
                                    <span class="order-product-subtotal">${sale2.purchasePrice} &euro;</span>
                                </td>
                                <td>
                                    <span>Tarjeta</span>
                                </td>
                            </tr>

                        </c:if>

                    </c:forEach>


                    </tbody>
                </table>
            </div>

            <div class="border-top my-3"></div>
            </c:if>

        </c:set>

    </c:forEach>

        <p>&nbsp;</p>


</div>

<p>&nbsp;</p>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>