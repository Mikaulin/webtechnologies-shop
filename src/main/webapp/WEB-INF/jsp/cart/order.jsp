<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group" role="group" aria-label="First group">
            <div class="input-group-prepend">
                <h4 class="mb-3">Orden de compra</h4>
            </div>
        </div>

    </div>

    <div class="border-top my-3"></div>


    <div class="row">

        <%--<mvc:form method="post" modelAttribute="sales" action="create">--%>

        <div class="col-sm-12 col-md-12 col-lg-8 mb-4">

            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th class="hidden-xs-down">Producto</th>
                        <th>Descripci&oacute;n</th>
                        <th class="hidden-xs-down">Precio</th>
                        <th>Cantidad</th>
                        <th>Importe</th>
                    </tr>
                    </thead>
                    <c:forEach items="${carts}" var="cart">
                        <tr>
                            <td width="100" class="text-center hidden-xs-down">
                                <a href="${pageContext.request.contextPath}/producto/detalle/${cart.product.id}"><img
                                        class="card-img-top"
                                        src="${pageContext.request.contextPath}/electro/${cart.product.photo}"></a>
                            </td>

                            <td width="280">
                                <span>${cart.product.name}</span>
                            </td>
                            <td class="hidden-xs-down">
                                <span> ${cart.product.finalPrice} &euro;</span>
                            </td>
                            <td>
                                <span>${cart.count}</span>
                            </td>
                            <td>
                                <span>${cart.cartPrice} &euro;</span>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

                <hr class="my-3">

                <p>&nbsp;</p>

            </div>

            <div class="col-md-12 order-md-1">
                <div class="card mb-4 shadow-sm">
                    <div class="card-header">
                        <h4 class="my-0 font-weight-normal">Dirección de entrega</h4>
                    </div>

                    <div class="card-body">
                        <div class="mb-3">
                            <h6>
                                ${user.name} ${user.lastname1}
                            </h6>
                        </div>
                        <div class="mb-3">
                            <h6>
                                ${user.direction}, <br>
                                ${user.postalCode} ${user.city},<br>
                                ${user.province} - ${user.country}
                            </h6>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="col-sm-12 col-md-12 col-lg-4 mb-4">
            <div class="card mb-3">
                <div class="card-header">
                    <h4 class="card-title">Resumen del pedido</h4>
                </div>
                <div class="card-block">
                    <div class="card-text">
                        <div id="estimate_shipping">
                            <table class="table ">
                                <tr>
                                    <td colspan="1" class="text-left">Total (IVA incluido)</td>
                                    <td colspan="1" class="text-right">${total} &euro;</td>
                                </tr>
                                <tr>
                                    <td colspan="1" class="text-left">Envío y manipulación</td>
                                    <td colspan="1" class="text-right">0 &euro;</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <table class="table table-striped">
                <tr class="totals key">
                    <td colspan="1" class="text-left"><strong>Total pedido</strong></td>
                    <td colspan="1" class="text-right"><strong>${total} &euro;</strong>
                    </td>
                </tr>
            </table>

            <p>&nbsp;</p>

            <div class="text-center cart-actions">
                <a href="${pageContext.request.contextPath}/compra/confirmacion" class="btn btn-danger btn-block"
                   title="orden de pago">Orden de pago</a>
            </div>
        </div>

    </div>

</div>

<p>&nbsp;</p><p>&nbsp;</p>
<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>