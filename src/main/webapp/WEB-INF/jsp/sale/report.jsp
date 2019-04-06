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
                <button type="button" class="btn btn-secondary btn-sm" data-toggle="modal" data-target="#exampleModal">
                <c:set var="now" value="<%= new java.util.Date() %>"/>
                    <fmt:formatDate type="date" value="${now}"/></button>
        </div>
    </div>


    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Informe de ventas</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form>
                    <div class="modal-body">
                        <p>
                          <label for="date">Elige un fecha: </label>
                          <input type="date" id="date" />
                        </p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-secondary">Enviar fecha</button>
                    </div>
                </form>
            </div>
        </div>
    </div>



    <div class="border-top my-3"></div>

    <c:forEach items="${detailUser}" var="user">

        <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group" role="group" aria-label="First group">
              <h5 class="mb-3">
                 <a class="btn btn-success btn-sm" href="#${user.username}" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="${user.username}">
                 <i class="fa fa-bars" aria-hidden="true"></i></a>
                  <span class="customer-name">&nbsp;&nbsp;${user.name} ${user.lastname1}
                    <small>[&nbsp;
                        <c:forEach items="${lines}" var="count">
                          <c:if test="${user.username eq count.user.username and count.date.day eq now.day and count.date.month eq now.month }" >
                            <i class="fa fa-shopping-cart"></i>
                          </c:if>
                    </c:forEach>&nbsp;]
                    </small>
                   </span>
              </h5>
            </div>

            <div class="input-group">
                <a href="${pageContext.request.contextPath}/user/editar/${user.username}">
                    <button type="button" class="btn btn-outline-success btn-sm">${user.username} <i
                            class="fa fa-chevron-right" aria-hidden="true"></i></button>
                </a>
            </div>
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
                    <th scope="col">Acciones</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${lines}" var="sale">

                    <c:if test="${sale.user.username eq user.username and sale.date.day eq now.day and sale.date.month eq now.month and sale.date.year eq now.year}">
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
                            <td>
                                <div class="btn-group">

                                    <a class="btn btn-sm btn-outline-danger" role="button"
                                       href="${pageContext.request.contextPath}/ventas/devoluciones/${user.username}">Devolver</a>

                                </div>
                            </td>
                        </tr>

                    </c:if>

                </c:forEach>


                </tbody>
            </table>
        </div>

        <div class="border-top my-3"></div>

    </c:forEach>


    <p>&nbsp;</p>


</div>

<p>&nbsp;</p>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>
