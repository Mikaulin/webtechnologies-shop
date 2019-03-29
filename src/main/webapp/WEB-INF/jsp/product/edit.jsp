<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <h4 class="mb-3">Editar un producto</h4>
    <hr>

    <mvc:form method="post" modelAttribute="product" action="../create">

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

                    <%-- <div class="row">
                             <div class="col-md-8 mb-3">
                                 <div class="form-group">
                                     <mvc:label path="category">Categor&iacute;a</mvc:label>
                                     <mvc:select class="form-control" path="category">
                                         <mvc:option value="NONE" label="Elige ..." />
                                         <c:forEach items="${categories}" var="category">
                                             <mvc:option value="${categories.id}" label="${product.category.name}" />
                                         </c:forEach>
                                     </mvc:select>
                                 </div>
                             </div>
                             <div class="col-md-4 mb-3">
                                 <div class="form-group">
                                     <mvc:label path="brand">Marca</mvc:label>
                                     <mvc:select class="form-control" path="brand">
                                         <mvc:option value="NONE" label="Elige ..." />
                                         <c:forEach items="${brands}" var="brand">
                                             <mvc:option value="${brand.id}" label="${product.brand.name}" />
                                         </c:forEach>
                                     </mvc:select>
                                 </div>
                             </div>
                         </div>--%>

                <div class="mb-3">
                    <div class="form-group">
                        <mvc:label path="photo">Elige una foto del producto</mvc:label>
                        <mvc:input type="file" path="photo" class="form-control" value="'/electro/'+${product.photo}"/>
                    </div>
                </div>
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
                <div class="mb-3">
                    <mvc:label path="discount">Descuento (%)</mvc:label>
                    <mvc:input path="discount" class="form-control" value="${product.discount}"/>
                </div>
                <div class="mb-3">
                    <div class="form-group">
                        <mvc:label path="deleted">Descatalogado</mvc:label>
                        <mvc:select class="form-control" path="deleted">
                            <option selected>FALSE</option>
                            <option>TRUE</option>
                        </mvc:select>
                    </div>
                </div>
            </div>

        </div>
        <p></p>

        <button class="btn btn-lg btn-danger" type="submit">Actualizar</button>

    </mvc:form>

</div>

<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>