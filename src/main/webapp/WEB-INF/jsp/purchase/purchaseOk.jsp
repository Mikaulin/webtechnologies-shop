<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <h4 class="mb-3">Confirmación del pedido</h4>

    <div class="border-top my-3"></div>


    <p>&nbsp;</p>

    <div class="row">
        <div class="col-md-8 order-md-1">
            <h5>${mensaje}
            </h5>

            <br><br>

            <h5>En breve recibirá un email con todos los datos de tu compra, así como un ID de pedido
                con el que podrá realizar el seguimiento del mismo.</h5>
        </div>
    </div>

    <p>&nbsp;</p>
    <p>&nbsp;</p>

    <div class="jumbotron mt-3">
        <h4>Le recordamos que ...</h4>
        <p class="lead">Te mandaremos otro e-mail cuando enviemos tu(s) producto(s).<br>
            La fecha estimada de entrega se te indicará en dicho email.<br>
            Visita "Mi cuenta" en ElectroHOME para consultar tus compras o gestionar tus devoluciones.<br><br>
            Gracias por tu pedido en ElectroHOME.</p>
    </div>

</div>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>

