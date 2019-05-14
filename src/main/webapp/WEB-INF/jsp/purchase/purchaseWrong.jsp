<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group" role="group" aria-label="First group">
            <div class="input-group-prepend">
                <h4 class="mb-3">Error en el pedido</h4>
            </div>
        </div>

        <div class="input-group">
            <a href="${pageContext.request.contextPath}/carrito" title="Ir al carrito">
                <button type="button" class="btn btn-success btn-sm">Ir al carrito</button>
            </a>
        </div>
    </div>

    <div class="border-top my-3"></div>


    <p>&nbsp;</p>

    <div class="row">
        <div class="col-md-8 order-md-1">
            <h5>Causa del error:
                <br>
                <small>${mensaje}</small>
            </h5>

            <br><br>

            <h5>Por favor, regrese al carrito y compruebe la linea de compra de dicho producto.
                Modifíquelo y continue con la compra. Muchas gracias.</h5>
        </div>
    </div>

    <p>&nbsp;</p>
    <p>&nbsp;</p>


</div>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>
