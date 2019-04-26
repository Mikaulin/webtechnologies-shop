<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <h4 class="mb-3">Darse de baja en ElectroHOME</h4>

    <div class="border-top my-3"></div>

    <p>&nbsp;</p>

    <mvc:form method="POST" modelAttribute="bajaUser" action="${contextPath}/usuarios/baja"
              commandName="bajaUser" class="form-signin">

        <div class="row">

            <div class="col-md-8 order-md-1">
                <h4><b>¿Desea eliminar su cuenta, ${bajaUser.name} ${bajaUser.lastname1} ?</b></h4>
            </div>

            <div class="col-md-4 order-md-2 mb-4">
                <button class="btn btn-lg btn-danger btn-block" type="submit">Confirmar Baja</button>
            </div>
        </div>

    </mvc:form>

    <p>&nbsp;</p>
    <div class="jumbotron mt-3">
        <h4>Le recordamos que ...</h4>
        <p class="lead">Una vez dado de baja, le recordamos que ya no podrá acceder a todos los servicios que tenía con
            ElectroHOME.
            Así mismo sus datos serán eliminados de nuestros ficheros. Agradecemos la confianza depositada en
            ElectroHOME.<br><br>
            Reciba un cordial saludo de todo el equipo de ElectroHOME.</p>
    </div>


</div>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>
