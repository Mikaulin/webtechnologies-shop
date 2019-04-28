<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <h4>Formulario nuevo cliente</h4>
    <hr>

    <form:form method="POST" modelAttribute="userForm" class="form-signin">

        <div class="row">

            <div class="col-md-8 order-md-1">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="name">Nombre</label>
                        <input type="text" name="name" id="name" class="form-control" placeholder="" required="" />
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="lastname1">Apellido</label>
                        <input type="text" id="lastname1" name="lastname1" class="form-control" placeholder="" required="" />
                    </div>
                </div>


                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="email">Email</label>
                        <input type="text" id="email" name="email" class="form-control" placeholder="" required="" />
                    </div>

                    <div class="col-md-6 mb-3">
                        <label for="phone">Tel&eacute;fono</label>
                        <input type="text" id="phone" name="phone" class="form-control" placeholder="" />
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-9 mb-3">
                        <label for="direction">Direcci&oacute;n</label>
                        <input type="text" id="direction" name="direction" class="form-control" placeholder="" required="" />
                    </div>

                    <div class="col-md-3 mb-3">
                        <label for="postalCode">C.P.</label>
                        <input type="text" id="postalCode" name="postalCode" class="form-control" placeholder="" required="" />
                    </div>
                </div>


                <div class="row">
                    <div class="col-md-4 mb-3">
                        <label for="city">Ciudad</label>
                        <input type="text" id="city" name="city" class="form-control" placeholder="" required="" />
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="province">Provincia</label>
                        <input type="text" id="province" name="province" class="form-control" placeholder="" required="" />
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="country">Pa&iacute;s</label>
                        <input type="text" id="country" name="country" class="form-control" placeholder="" required="" />
                    </div>
                </div>

            </div>

            <div class="col-md-4 order-md-2 mb-4">

                <div class="mb-3">
                    <label for="username">Usuario</label>
                    <spring:bind path="username">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" path="username" class="form-control" placeholder="" />
                            <form:errors path="username" />
                        </div>
                    </spring:bind>

                </div>

                <div class="mb-3">
                    <label for="password">Contrase&ntilde;a</label>
                    <spring:bind path="password">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="password" path="password" class="form-control" placeholder="" />
                            <form:errors path="password" />
                        </div>
                    </spring:bind>
                </div>

                <div class="mb-3">
                    <label for="passwordConfirm">Repetir contrase&ntilde;a</label>
                    <spring:bind path="passwordConfirm">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="password" path="passwordConfirm" class="form-control" placeholder="" />
                            <form:errors path="passwordConfirm" />
                        </div>
                    </spring:bind>
                </div>
            </div>
        </div>

        <button class="btn btn-lg btn-danger" type="submit">Crear cuenta</button>

    </form:form>

</div>

<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>