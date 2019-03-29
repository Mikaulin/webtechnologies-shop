<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <div class="col-12">
        <h4 class="mb-3">Darse de baja en ElectroHOME</h4>
        <hr>
    </div>

    <mvc:form method="POST" modelAttribute="user" action="${contextPath}/${user.username}"
              commandName="user" class="form-signin">

        <div><br>
            <h4><b>Desea eliminar su cuenta ${user.username}?</b></h4>
        </div>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Confirmar Baja</button>
    </mvc:form>

</div>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>
