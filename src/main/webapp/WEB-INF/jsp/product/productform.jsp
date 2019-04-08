<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <h4 class="mb-3">Dar de alta un producto</h4>
    <hr>

    <mvc:form method="post" modelAttribute="product" action="create">

        <div class="row">

            <div class="col-md-8 order-md-1">

                <div class="mb-3">
                    <mvc:label path="name">Nombre</mvc:label>
                    <mvc:input path="name" class="form-control" value=""/>
                </div>

                <div class="mb-3">
                    <mvc:label path="description">Descripci&oacute;n</mvc:label>
                    <mvc:input path="description" class="form-control" value=""/>
                </div>

                <div class="row">
                    <div class="col-md-4 mb-3">
                        <mvc:label path="width">Ancho (mm)</mvc:label>
                        <mvc:input path="width" class="form-control" value=""/>
                    </div>
                    <div class="col-md-4 mb-3">
                        <mvc:label path="depth">Profundidad (mm)</mvc:label>
                        <mvc:input path="depth" class="form-control" value=""/>
                    </div>

                    <div class="col-md-4 mb-3">
                        <mvc:label path="height">Alto (mm)</mvc:label>
                        <mvc:input path="height" class="form-control" value=""/>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4 mb-3">
                        <div class="form-group">
                            <mvc:label path="category">Categor&iacute;a</mvc:label>
                            <mvc:select class="form-control" path="category">
                                <mvc:option value="NONE" label="Elige ..."/>
                                <c:forEach items="${categories}" var="category">
                                    <option value="${category.id}">${category.name}</option>
                                </c:forEach>
                            </mvc:select>
                        </div>
                    </div>

                    <div class="col-md-4 mb-3">
                        <div class="form-group">
                            <mvc:label path="brand">Marca</mvc:label>
                            <mvc:select class="form-control" path="brand">
                                <mvc:option value="NONE" label="Elige ..."/>
                                <c:forEach items="${brands}" var="brand">
                                    <mvc:option value="${brand.id}" label="${brand.name}"/>
                                </c:forEach>
                            </mvc:select>
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <div class="form-group">
                            <mvc:label path="deleted">Descatalogado</mvc:label>
                            <mvc:select class="form-control" path="deleted">
                                <option selected>FALSE</option>
                                <option>TRUE</option>
                            </mvc:select>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-8 mb-3">
                        <div class="form-group">
                            <mvc:label path="photo">Elige una foto del producto</mvc:label>
                            <mvc:input type="file" path="photo" class="form-control" value="/electro/"/>
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <mvc:label path="discount">Descuento (%)</mvc:label>
                        <mvc:input path="discount" class="form-control" value=""/>
                    </div>
                </div>

                <button class="btn btn-lg btn-danger" type="submit">Dar de alta</button>
            </div>

            <div class="col-md-4 order-md-2 mb-4">
                <div class="mb-3">
                    <mvc:label path="count">Cantidad</mvc:label>
                    <mvc:input path="count" class="form-control" value=""/>
                </div>

                <div class="mb-3">
                    <mvc:label path="price">Precio Ud.</mvc:label>
                    <mvc:input path="price" class="form-control" value=""/>
                </div>

                <div class="card mb-4 shadow-sm">
                    <div class="card-header">
                        <h4 class="my-0 font-weight-normal">Promociones activas</h4>
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

                                <%-- <c:forEach items="${promotion}" var="promo">
                                     <li>
                                         <div class="form-group form-check"><input type="checkbox"
                                                                                   class="form-check-input"
                                                                                   id="${promo.id}">
                                             <label class="form-check-label" for="${promo.id}">${promo.name}</label>
                                         </div>
                                     </li>
                                 </c:forEach>--%>
                        </ul>
                    </div>
                </div>
            </div>

        </div>


    </mvc:form>

</div>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>