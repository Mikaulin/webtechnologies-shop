<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
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

            <c:if test="${total == 0.0}">
                <div class="row">
                    <div class="col-md-8 order-md-1">
                        <h4> EL CARRO DE LA COMPRA ESTÁ VACÍO</h4>
                        <br><br>
                        <h5> No tiene productos en el carro de la compra.</h5>
                    </div>
                </div>
            </c:if>

            <c:if test="${total > 0.0}">

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

                            <td width="280">
                                <span>${cart.product.name}</span>
                            </td>

                            <td>
                                <span class="order-product-price"> ${cart.product.finalPrice} &euro;</span>
                            </td>

                            <td>
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
                                <span class="order-product-subtotal">${cart.product.finalPrice * cart.count} &euro;</span>
                            </td>

                            <td>
                                <a class="btn btn-danger btn-sm cart-product-remove" href="" title="Quitar Producto">
                                    <i class="fa fa-trash-o" aria-hidden="true"></i>
                                </a>
                            </td>

                        </tr>
                    </c:forEach>
                </table>

                <hr class="my-3">

                <p>&nbsp;</p>

            </div>

            </c:if>

            <c:if test="${total == null}">

            <div class="row">
                <div class="col-md-8 order-md-1">
                    <h4> EL CARRO DE LA COMPRA ESTÁ VACÍO</h4>

                    <br><br>

                    <h5> No tiene productos en el carro de la compra. Por favor, para comprar algún producto, debe antes iniciar sesión en el área de cliente.</h5>

                    <br>

                    <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/user/login">Área de cliente
                        <i class="fa fa-chevron-right" aria-hidden="true"></i></a>
                </div>
            </div>


        </c:if>

        <c:if test="${total > 0.0}">

            <div class="row">

                <div class="col-md-6 order-md-1">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-header">
                            <h4 class="my-0 font-weight-normal">Forma de pago</h4>
                        </div>

                        <div class="card-body">

                                <div class="form-check">
                                    <input type="radio" name="forma_pago" value="1"
                                           id="pago1" class="radiobox" checked="checked"/>
                                    <span>Tarjeta crédito/débito</span>
                                </div><br>
                                <div class="form-check">
                                    <input type="radio" name="forma_pago" value="2"
                                           id="pago2" class="radiobox"/>
                                        <span>Servicio PayPal</span>
                                </div><br>
                                <div class="form-check">
                                    <input type="radio" name="forma_pago" value="3"
                                           id="pago3" class="radiobox"/>
                                            <span>Transferencia bancaria</span>
                                </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6 order-md-1">

                    <div class="card mb-4 shadow-sm">
                        <div class="card-header">
                            <h4 class="my-0 font-weight-normal">Forma de envío</h4>
                        </div>
                        <div class="card-body">

                            <div class="form-check">
                                <input type="radio" name="forma_envio" value="1"
                                       id="envio1" class="radiobox" checked="checked" />
                                <span>Envío normal <i>- 0 &euro; <br><small>(5 o 6 días laborables)</small></i></span>
                            </div><br>
                            <div class="form-check">
                                <input type="radio" name="forma_envio" value="2"
                                       id="envio2" class="radiobox" />
                                <span>Envío Express <i>- 20 &euro; <br><small>(2 o 3 días laborables)</small></i></span>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </c:if>

        </div>



        <div class="col-sm-12 col-md-12 col-lg-4 mb-4">

            <c:if test="${total > 0.0}">

                <div class="card mb-3">
                    <div class="card-header">
                        <h4 class="card-title">Resumen del pedido</h4>
                    </div>
                    <div class="card-block">
                        <div class="card-text">
                            <div id="estimate_shipping">
                                <table class="table ">
                                    <tr>
                                        <td colspan="1" class="text-left">Subtotal</td>
                                        <td colspan="1" class="text-right">${subtotal} &euro;</td>
                                    </tr>
                                    <tr>
                                        <td colspan="1" class="text-left">I.V.A.</td>
                                        <td colspan="1" class="text-right">${iva} &euro;</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>


                    <table class="table table-striped">

                        <tr class="totals key">
                            <td colspan="1" class="text-left"><strong>Total</strong></td>
                            <td colspan="1" class="text-right"><strong>${total} &euro;</strong>
                            </td>
                        </tr>
                    </table>



                    <p>&nbsp;</p>

                    <div class="text-center cart-actions">
                        <a href="${pageContext.request.contextPath}/carrito/orden" class="btn btn-danger btn-block" title="Tramitar pedido">Tramitar pedido</a>
                    </div>
            </c:if>



        </div>

    </div>

</div>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>