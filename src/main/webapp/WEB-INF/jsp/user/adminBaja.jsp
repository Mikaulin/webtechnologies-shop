<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <h4 class="mb-3">Confirmar baja del usuario</h4>

    <div class="border-top my-3"></div>

    <p>&nbsp;</p>

    <mvc:form method="POST" modelAttribute="user"
              commandName="user" class="form-signin">

        <div class="row">

            <div class="col-md-8 order-md-1">
                <h4><b>¿Desea eliminar la cuenta de ${user.name} ${user.lastname1} ?</b></h4>
            </div>

            <div class="col-md-4 order-md-2 mb-4">
                <button class="btn btn-lg btn-danger btn-block" type="submit">Confirmar Baja</button>
            </div>
        </div>

    </mvc:form>

</div>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>
