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

        <mvc:form method="post" modelAttribute="purchase" action="../delete">
            <mvc:input type="hidden" path="id" class="form-control" value="${purchase.id}"/>
            <div>${purchase.product.name}</div>
            <div>${purchase.product.count}</div>
            <div>${purchase.product.id}</div>


            <button class="btn btn-lg btn-danger" type="submit">Eliminar</button>


        </mvc:form>

    </div>

</div>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>