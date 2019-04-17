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


        <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group" role="group" aria-label="First group">
                <h5 class="mb-3">
                    <a class="btn btn-success btn-sm" href="#${user.username}" data-toggle="collapse"
                       role="button" aria-expanded="false" aria-controls="${user.username}">

                        <i class="fa fa-bars" aria-hidden="true"></i></a>
                    <span class="customer-name">&nbsp;&nbsp;${user.name} ${user.lastname1}

                   </span>
                </h5>
            </div>
            <div class="input-group">
                <h5>Facturaci&oacute;n: <b>${user.getPruchaseTotalByDate(date)} &euro;</b></h5>
            </div>
        </div>

        <div class="collapse multi-collapse" id="${user.username}">

            <table id="example" class="table">
                <thead>
                <tr>
                    <th scope="col">Producto</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Descripci&oacute;n</th>
                    <th scope="col">Precio</th>
                    <th scope="col">Cantidad</th>
                    <th scope="col">Importe</th>
                    <th scope="col">F. pago</th>
                </tr>
                </thead>

                <tbody>

                <tr>

                  <c:forEach items="${user.getPurchaseByDate(date)}" var="sale">

                    <td width="100">
                        <img class="card-img-top" alt="${sale.product.name}"
                             src="${pageContext.request.contextPath}/electro/${sale.product.photo}">
                    </td>
                    <td width="280">
                        <span>${sale.product.name}</span>
                    </td>
                      <td width="280">
                          <span>${sale.product.description}</span>
                      </td>
                    <td>
                        <span class="order-product-price"> ${sale.product.finalPrice} &euro;</span>
                    </td>
                    <td>
                        <span class="order-product-price"> ${sale.count}</span>
                    </td>
                    <td>
                        <span class="order-product-subtotal">${sale.purchasePrice} &euro;</span>
                    </td>
                    <td>
                        <span>Tarjeta</span>
                    </td>

                   </c:forEach>

                </tr>
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