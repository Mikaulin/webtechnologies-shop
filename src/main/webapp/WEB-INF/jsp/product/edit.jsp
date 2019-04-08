<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../shared/_header.jsp" %>

<div class="container">

    <mvc:form method="post" modelAttribute="product">


        <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group" role="group" aria-label="First group">
                <div class="input-group-prepend">
                    <h4 class="mb-3">Editar un producto</h4>
                </div>
            </div>



            <div class="input-group">
                <div class="custom-control custom-checkbox my-1 mr-sm-2">
                    <mvc:checkbox class="custom-control-input" id="customControlInline2" path="featured" value="${product.featured}" />
                    <mvc:label class="custom-control-label" path="featured" for="customControlInline2">Destacado</mvc:label>
                </div>
            </div>
        </div>

        <div class="border-top my-3"></div>



        <div class="row">

            <div class="col-md-8 order-md-1">
                <mvc:input type="hidden" path="id" class="form-control" value="${product.id}"/>
                <div class="mb-3">
                    <mvc:label path="name">Nombre</mvc:label>
                    <mvc:input path="name" class="form-control" value="${product.name}"/>
                </div>
                <div class="mb-3">
                    <mvc:label path="description">Descripci&oacute;n</mvc:label>
                    <mvc:input path="description" class="form-control" value="${product.description}"/>
                </div>
                <div class="row">
                    <div class="col-md-4 mb-3">
                        <mvc:label path="width">Ancho (mm)</mvc:label>
                        <mvc:input path="width" class="form-control" value="${product.width}"/>
                    </div>
                    <div class="col-md-4 mb-3">
                        <mvc:label path="depth">Profundidad (mm)</mvc:label>
                        <mvc:input path="depth" class="form-control" value="${product.depth}"/>
                    </div>
                    <div class="col-md-4 mb-3">
                        <mvc:label path="height">Alto (mm)</mvc:label>
                        <mvc:input path="height" class="form-control" value="${product.height}"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 mb-3">
                        <div class="form-group">
                        <mvc:select class="form-control" path="category">
                            <mvc:options items="${categoryList}" itemValue="id" itemLabel="name"/>
                        </mvc:select>
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <div class="form-group">
                        <mvc:select class="form-control" path="brand">
                            <mvc:options items="${brandList}" itemValue="id" itemLabel="name"/>
                        </mvc:select>
                        </div>
                    </div>

                    <div class="col-md-4 mb-3">
                        <div class="custom-control custom-checkbox my-1 mr-sm-2">
                            <mvc:checkbox class="custom-control-input" id="customControlInline" path="deleted" value="${product.deleted}" />
                            <mvc:label class="custom-control-label" path="deleted" for="customControlInline">Descatalogado</mvc:label>
                        </div>

                    </div>
                </div>

                <div class="row">
                    <div class="col-md-8 mb-3">
                        <div class="form-group">
                            <mvc:label path="photo">Elige una foto del producto</mvc:label>
                            <mvc:input type="file" path="photo" class="form-control"  value="'/electro/'+${product.photo}"/>
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <mvc:label path="discount">Descuento (%)</mvc:label>
                        <mvc:input path="discount" class="form-control" value="${product.discount}"/>
                    </div>
                </div>

                <p></p>

                <button class="btn btn-lg btn-danger" type="submit">Actualizar</button>

            </div>


            <div class="col-md-4 order-md-2 mb-4">

                <div class="mb-3">
                    <mvc:label path="count">Cantidad</mvc:label>
                    <mvc:input path="count" class="form-control" value="${product.count}"/>
                </div>
                <div class="mb-3">
                    <mvc:label path="price">Precio Ud.</mvc:label>
                    <mvc:input path="price" class="form-control" value="${product.price}"/>
                </div>

                <div class="card mb-4 shadow-sm">
                <div class="card-header">
                        <%--TODO si no se selecciona ninguna se borraran las promociones del producto--%>
                    <h4 class="my-0 font-weight-normal">Promociones disponibles</h4>
                </div>

                <div class="card-body">
                    <ul class="list-unstyled mt-3 mb-4">

                        <c:forEach items="${promotion}" var="promo">
                            <li>
                                <div class="form-group form-check">
                                    <mvc:checkbox path="promotions" id="customControl${promo.id}" value="${promo.id}"/>
                                    <mvc:label  path="promotions" for="customControl${promo.id}" >${promo.name}</mvc:label>
                                </div>
                            </li>
                        </c:forEach>

                    </ul>
                </div>
                    <div class="card mb-4 shadow-sm">
                        <div class="card-header">
                            <h4 class="my-0 font-weight-normal">Promociones Activas del producto</h4>
                        </div>

                        <div class="card-body">
                            <ul class="list-unstyled mt-3 mb-4">

                                <c:forEach items="${product.promotions}" var="promoProducto">
                                    <li>
                                        <div class="form-group form-check" >
                                            ${promoProducto.name}
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