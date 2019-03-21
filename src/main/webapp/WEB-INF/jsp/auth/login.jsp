<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@ include file = "../shared/_header.jsp"%>

<div class="container">

    <div class="col-12">
        <h4 class="mb-3">Iniciar sesi&oacute;n en ElectroHOME</h4>
        <hr>
    </div>

     <form method="POST" action="${contextPath}/user/login" class="form-signin">

          <div class="col-md-8 order-md-1">

            <div class="row">
                <div class="col-md-6 mb-3 ${error != null ? 'has-error' : ''}">
                        <span>${message}</span>
                        <input name="username" type="text" class="form-control" placeholder="Usuario"
                           autofocus="true"/>
                </div>
                <div class="col-md-6 mb-3 ${error != null ? 'has-error' : ''}">
                        <input name="password" type="password" class="form-control" placeholder="Contraseña"/>
                        <span>${error}</span>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </div>
            </div>

            <div class="checkbox mb-3">
                <label>
                    <a href="#"  class="text-danger">Has olvidado tu contrase&ntilde;a ?</a>
                </label>
            </div>

                    <button type="submit" class="btn btn-danger btn-lg">Iniciar Sesi&oacute;n</button>
          </div>
     </form>

    <p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>


    <div class="jumbotron mt-3">
        <h4>Si no tienes una cuenta puedes crearla ahora</h4>
        <p class="lead">Y empezar&aacute;s a disfrutar de todas las ventajas que te ofrece ElectroHOME</p>
        <a class="btn btn-outline-danger" href="${contextPath}/user/registration" role="button">Crear Cuenta</a>
    </div>

</div>

<%@ include file = "../shared/_js.jsp"%>
<%@ include file = "../shared/_footer.jsp"%>
