<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@ include file="../shared/_header.jsp" %>


<%--TODO Esto de momento no se usa, terminar o eliminar--%>

<div class="container">

    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group" role="group" aria-label="First group">
            <div class="input-group-prepend">
                <h4 class="mb-3">Lista de compras</h4>
            </div>
        </div>

        <div class="input-group">
            <a href="javascript:history.back()" title="Continúa Comprando">
                <button type="button" class="btn btn-success btn-sm">Continuar comprando</button>
            </a>
        </div>
    </div>

    <div class="border-top my-3"></div>


    <div class="row">
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
                        <th></th>
                    </tr>
                    </thead>
                    <c:forEach items="${carts}" var="cart">
                        <tr>


                            <td width="100" class="text-center hidden-xs-down">
                                <a href="${pageContext.request.contextPath}/producto/detalle/${cart.product.id}"><img
                                        class="card-img-top"
                                        src="${pageContext.request.contextPath}/electro/${cart.product.photo}"></a>

                            </td>

                            <td width="200">
                                <h6><b>${cart.product.name}</b></h6>
                            </td>

                            <td class="hidden-xs-down">
                                <span class="order-product-price"> ${cart.product.price} &euro;</span>
                            </td>
                            <td width="50">
                                <select class="select select-qty form-control" name="" title="Qty">


                                    <option value=${cart.count} selected="selected">${cart.count}</option>

                                    <option value="1">1</option>

                                    <option value="2">2</option>

                                    <option value="3">3</option>

                                    <option value="4">4</option>

                                    <option value="5">5</option>

                                    <option value="6">6</option>

                                    <option value="7">7</option>

                                    <option value="8">8</option>

                                    <option value="9">9</option>

                                    <option value="10">10</option>

                                </select>
                            </td>
                            <td>
                                <span class="order-product-subtotal">${cart.product.price * cart.count} &euro;</span>
                            </td>

                            <td>
                                <a href="" class="cart-product-remove" title="Quitar Producto">
                                    <i class="fa fa-times-circle-o fa-fw"></i>
                                </a>
                            </td>

                        </tr>
                    </c:forEach>
                </table>

                <hr class="my-3">
            </div>
        </div>

        <div class="col-sm-12 col-md-12 col-lg-4 mb-4">

            <div class="col-sm-12 col-md-12 cart-estimate">
                <div class="card mb-3">
                    <div class="card-header">
                        <h4 class="card-title">Resumen del pedido</h4>
                    </div>
                    <div class="card-block">
                        <div class="card-text">
                            <div id="estimate_shipping">

                                <form action="" accept-charset="UTF-8" id="estimate_shipping_form" autocomplete="off"
                                      method="post">

                                    <table class="table ">

                                        <tr>
                                            <td colspan="1" class="text-left"><strong>Subtotal</strong></td>
                                            <td colspan="1" class="text-right"><strong>
                                                <%--<%out.println(totalReb);%>--%>
                                                &euro;</strong></td>
                                        </tr>


                                        <tr>
                                            <td colspan="1" class="text-left"><strong>I.V.A.</strong></td>
                                            <td colspan="1" class="text-right"><strong>120.00 &euro;</strong></td>
                                        </tr>
                                    </table>


                                    <div class="estimate_shipping_buttons">

                                    </div>
                                </form>


                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="col-sm-12 cart-totals">
                <table class="table table-striped">

                    <tr class="totals key">
                        <td colspan="1" class="text-left"><strong>Total</strong></td>
                        <td colspan="1" class="text-right"><strong>
                            <%--<%out.println(totalReb + 120.00);%> &euro;--%>
                        </strong>
                        </td>
                    </tr>
                </table>

                <div class="text-center cart-actions">
                    <a href="" class="btn btn-danger btn-block" title="Tramitar pedido">Tramitar pedido</a>
                </div>
            </div>

        </div>


    </div>

</div>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>