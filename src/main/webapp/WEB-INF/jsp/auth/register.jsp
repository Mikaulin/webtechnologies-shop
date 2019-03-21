<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@ include file = "../shared/_header.jsp"%>

<div class="container">

    <div class="col-12">
        <h4 class="mb-3">Formulario nuevo cliente</h4>
        <hr>
    </div>

    <form:form method="POST" modelAttribute="userForm" class="form-signin">

    <div class="col-12">
    <div class="row">

         <div class="col-md-8 order-md-1">

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="name">Nombre</label>
                <input type="text" class="form-control" id="name" placeholder="" value="" required autofocus="true">
                <div class="invalid-feedback">
                    Por favor, introduce un nombre v$aacute;lido.
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <label for="lastname1">Apellido</label>
                <input type="text" class="form-control" id="lastname1" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Por favor, introduce un apellido v$aacute;lido.
                </div>
            </div>
        </div>


        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Por favor, introduce una direcci&oacute;n de correo v$aacute;lida.
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label for="phone">Tel&eacute;fono</label>
                <input type="text" class="form-control" id="phone" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Por favor, introduce un tel&eacute;fono de contacto v$aacute;lido.
                </div>
            </div>
        </div>

        <div class="mb-3">
            <label for="direction">Direcci&oacute;n</label>
            <input type="text" class="form-control" id="direction" placeholder="" value="" required>
            <div class="invalid-feedback">
                Por favor, introduce una direcci&oacute;n v$aacute;lida.
            </div>
        </div>

        <div class="row">
            <div class="col-md-5 mb-3">
                <label for="province">Provincia</label>
                <input type="text" class="form-control" id="province" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Por favor, introduce una provincia v$aacute;lida.
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <label for="country">Pa&iacute;s</label>
                <input type="text" class="form-control" id="country" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Por favor, introduce un pa&iacute;s v$aacute;lido.
                </div>
            </div>
            <div class="col-md-3 mb-3">
                <label for="pc">C.P.</label>
                <input type="text" class="form-control" id="pc" placeholder="" required>
                <div class="invalid-feedback">
                    Por favor, introduce un c&oacute;digo postal v$aacute;lido.
                </div>
            </div>
          </div>
        </div>

        <div class="col-md-4 order-md-2 mb-4">

            <div class="mb-3">
                <label for="username">Usuario</label>
                <spring:bind path="username">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="username" class="form-control" placeholder="" ></form:input>
                        <form:errors path="username"></form:errors>
                    </div>
                </spring:bind>

            </div>

            <div class="mb-3">
                <label for="password">Contrase&ntilde;a</label>
                    <spring:bind path="password">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="password" path="password" class="form-control" placeholder=""></form:input>
                            <form:errors path="password"></form:errors>
                        </div>
                    </spring:bind>
             </div>

             <div class="mb-3">
                 <label for="passwordConfirm">Repetir contrase&ntilde;a</label>
                    <spring:bind path="passwordConfirm">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="password" path="passwordConfirm" class="form-control" placeholder=""></form:input>
                            <form:errors path="passwordConfirm"></form:errors>
                        </div>
                    </spring:bind>
             </div>
           </div>

        </div>

        <p></p>


        <button class="btn btn-lg btn-danger" type="submit">Crear cuenta</button>

    </div>

    </form:form>


</div>

<%@ include file = "../shared/_js.jsp"%>
<%@ include file = "../shared/_footer.jsp"%>