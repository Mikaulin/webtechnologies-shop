<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@ include file = "../shared/_header.jsp"%>

<div class="container">

    <div class="col-md-8 order-md-1">

        <h4 class="mb-3">Inicia Sesión</h4>

        <form method="POST" action="${contextPath}/user/login" class="form-signin">
            <div class="form-group ${error != null ? 'has-error' : ''}">
                <span>${message}</span>
                <input name="username" type="text" class="form-control" placeholder="Usuario"
                       autofocus="true"/>
            </div>
            <div class="form-group ${error != null ? 'has-error' : ''}">
                <input name="password" type="password" class="form-control" placeholder="Contraseña"/>
                <span>${error}</span>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </div>
            <div class="form-group">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Conéctate</button>
            </div>
                <h4 class="text-center"><a href="${contextPath}/user/registration">Crea una cuenta</a></h4>

        </form>
    </div>
</div>

<%@ include file = "../shared/_js.jsp"%>
<%@ include file = "../shared/_footer.jsp"%>
