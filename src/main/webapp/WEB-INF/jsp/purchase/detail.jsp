<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <h4 class="mb-3">Devolver producto al inventario</h4>

    <div class="border-top my-3"></div>


    <div class="row">

        <div class="table-responsive">

            <mvc:form method="post" modelAttribute="purchase" action="../delete">

                <mvc:input type="hidden" path="id" class="form-control" value="${purchase.id}"/>


                <table class="table">
                    <thead>
                    <tr>
                        <th class="hidden-xs-down">Producto</th>
                        <th>Descripci&oacute;n</th>
                        <th class="hidden-xs-down">Precio</th>
                        <th>Cantidad</th>
                        <th>Importe</th>
                        <th>Fecha</th>
                        <th>usuario</th>
                    </tr>
                    </thead>

                    <tr>
                        <td width="120" class="text-center hidden-xs-down">
                            <img class="card-img-top"
                                 src="${pageContext.request.contextPath}/electro/${purchase.product.photo}"
                                 alt="producto">
                        </td>
                        <td>
                            <span>${purchase.product.name}</span>
                        </td>
                        <td class="hidden-xs-down">
                            <span> ${purchase.product.finalPrice} &euro;</span>
                        </td>
                        <td>
                            <span>${purchase.count}</span>
                        </td>
                        <td>
                            <span>${purchase.purchasePrice} &euro;</span>
                        </td>
                        <td>
                            <span>${purchase.date.time.toLocaleString().substring(0,11)}</span>
                        </td>
                        <td>
                            <span>${purchase.user.username}</span>
                        </td>
                    </tr>

                </table>

                <hr class="my-3">

                <p>&nbsp;</p>

                <h5><b>Desea eliminar esta compra del histórico de ventas del cliente ?</b></h5>

                <p>&nbsp;</p>

                <button class="btn btn-lg btn-danger" type="submit"> Confirmar</button>

            </mvc:form>

        </div>
    </div>
</div>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>