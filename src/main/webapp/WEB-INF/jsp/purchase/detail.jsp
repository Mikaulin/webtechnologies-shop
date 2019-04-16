<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group" role="group" aria-label="First group">
            <div class="input-group-prepend">
                <h4 class="mb-3">Detalle de compra </h4>
            </div>
        </div>

    </div>

    <div class="border-top my-3"></div>


    <div class="row">

        <mvc:form method="post" modelAttribute="purchase" action="delete">

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
                        <th>Fecha de compra </th>
                        <th>Accion</th>
                    </tr>
                    </thead>
                        <tr>
                            <td width="100" class="text-center hidden-xs-down">
                                <a href="${pageContext.request.contextPath}/producto/detalle/${purchase.product.id}"><img
                                        class="card-img-top"
                                        src="${pageContext.request.contextPath}/electro/${purchase.product.photo}"></a>
                            </td>

                            <td width="280">
                                <span>${purchase.product.name}</span>
                            </td>
                            <td class="hidden-xs-down">
                                <span> ${purchase.unitPrice} &euro;</span>
                            </td>
                            <td>
                                <span>${purchase.count}</span>
                            </td>
                            <td>
                                <span>${purchase.purchasePrice} &euro;</span>
                            </td>
                        </tr>
                </table>
                <button class="btn btn-lg btn-danger" type="submit">Devolver compra</button>

                <hr class="my-3">

                <p>&nbsp;</p>

            </div>


        </div>


</mvc:form>

    </div>

</div>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>