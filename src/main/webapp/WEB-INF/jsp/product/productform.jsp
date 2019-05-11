<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../shared/_header.jsp" %>

<div class="container">

    <h4 class="mb-3">Dar de alta un producto</h4>
    <hr>

    <mvc:form method="post" modelAttribute="product" action="alta">

        <div class="row">

            <div class="col-md-8 order-md-1">

                <div class="mb-3">
                    <label for="name">Nombre</label>
                    <input name="name" id="name" class="form-control" value="" required=""/>
                </div>

                <div class="mb-3">
                    <label for="description">Descripci&oacute;n</label>
                    <input name="description" id="description" class="form-control" value="" required=""/>
                </div>

                <div class="row">
                    <div class="col-md-4 mb-3">
                        <label for="width">Ancho (mm)</label>
                        <input name="width" id="width" class="form-control" placeholder="0.0" required=""/>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="depth">Profundidad (mm)</label>
                        <input name="depth" id="depth" class="form-control" placeholder="0.0" required=""/>
                    </div>

                    <div class="col-md-4 mb-3">
                        <label for="height">Alto (mm)</label>
                        <input name="height" id="height" class="form-control" placeholder="0.0" required=""/>
                    </div>
                </div>

                <div class="row">

                    <div class="col-md-4 mb-3">
                        <div class="form-group">
                            <label for="category">Categor&iacute;a</label>
                            <select class="form-control" name="category" id="category" required>
                                <option value=""> Elige ...</option>
                                <c:forEach items="${categories}" var="category">
                                    <option value="${category.id}">${category.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="col-md-4 mb-3">
                        <div class="form-group">
                            <label for="brand">Marca</label>
                            <select class="form-control" name="brand" id="brand" required>
                                <option value=""> Elige ...</option>
                                <c:forEach items="${brands}" var="brand">
                                    <option value="${brand.id}">${brand.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>


                    <div class="col-md-4 mb-3">
                        <div class="form-group">
                            <label for="deleted">Descatalogado</label>
                            <select class="form-control" id="deleted" name="deleted">
                                <option selected>FALSE</option>
                                <option>TRUE</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-8 mb-3">
                        <div class="form-group">
                            <label for="photo">Elige una foto del producto</label>
                            <input id="photo" name="photo" class="form-control" value=""
                                   required=""/>
                        </div>
                    </div>

                    <div class="col-md-4 mb-3">
                        <label for="discount">Descuento (%)</label>
                        <input id="discount" name="discount" class="form-control" value="0.0"/>
                    </div>
                </div>

                <button class="btn btn-lg btn-danger" type="submit">Dar de alta</button>
            </div>

            <div class="col-md-4 order-md-2 mb-4">
                <div class="mb-3">
                    <label for="count">Cantidad</label>
                    <input id="count" name="count" class="form-control" placeholder="0" required=""/>
                </div>

                <div class="mb-3">
                    <label for="price">Precio Ud.</label>
                    <input id="price" name="price" class="form-control" placeholder="0.0" required=""/>
                </div>

                <div class="card mb-4 shadow-sm">
                    <div class="card-header">
                        <h4 class="my-0 font-weight-normal">Promociones</h4>
                    </div>

                    <div class="card-body">
                        <ul class="list-unstyled mt-3 mb-4">


                            <c:forEach items="${promotion}" var="promo">
                                <li>
                                    <div class="form-group form-check">
                                        <mvc:checkbox path="promotions" value="${promo.id}"/> ${promo.name}
                                    </div>
                                </li>
                            </c:forEach>

                        </ul>
                    </div>
                </div>
            </div>

        </div>


    </mvc:form>

</div>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>