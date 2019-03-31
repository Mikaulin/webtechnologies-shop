<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <div class="col-12">
        <h4 class="mb-3">Editar un cliente</h4>
        <hr>
    </div>

    <form:form method="POST" modelAttribute="editUser" class="form-signin">

        <div class="col-12">
            <div class="row">

                <div class="col-md-8 order-md-1">

                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <form:label path="name">Nombre</form:label>
                            <form:input path="name" class="form-control" value="${editUser.name}"/>
                        </div>
                        <div class="col-md-6 mb-3">
                            <form:label path="lastname1">Apellido</form:label>
                            <form:input path="lastname1" class="form-control" value="${editUser.lastname1}"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <form:label path="email">Email</form:label>
                            <form:input path="email" class="form-control" value="${editUser.email}"/>
                        </div>

                        <div class="col-md-6 mb-3">
                            <form:label path="phone">Tel&eacute;fono</form:label>
                            <form:input path="phone" class="form-control" value="${editUser.phone}"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-9 mb-3">
                            <form:label path="direction">Direcci&oacute;n</form:label>
                            <form:input path="direction" class="form-control" value="${editUser.direction}"/>
                        </div>

                        <div class="col-md-3 mb-3">
                            <form:label path="postalCode">C.P.</form:label>
                            <form:input path="postalCode" class="form-control" value="${editUser.postalCode}"/>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-4 mb-3">
                            <form:label path="city">Ciudad</form:label>
                            <form:input path="city" class="form-control" value="${editUser.city}"/>
                        </div>
                        <div class="col-md-4 mb-3">
                            <form:label path="province">Provincia</form:label>
                            <form:input path="province" class="form-control" value="${editUser.province}"/>
                        </div>
                        <div class="col-md-4 mb-3">
                            <form:label path="country">Pa&iacute;s</form:label>
                            <form:input path="country" class="form-control" value="${editUser.country}"/>
                        </div>
                    </div>

                </div>

                <div class="col-md-4 order-md-2 mb-4">

                    <div class="mb-3">
                        <form:label path="username">Usuario:</form:label>
                        <form:input path="username" class="form-control" value="${editUser.username}"/>
                    </div>

                   <%-- <div class="mb-3">
                        <label for="password">Contrase&ntilde;a</label>
                        <spring:bind path="password">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="password" path="password" class="form-control"
                                            placeholder=""></form:input>
                                <form:errors path="password"></form:errors>
                            </div>
                        </spring:bind>
                    </div>

                    <div class="mb-3">
                        <label for="passwordConfirm">Repetir contrase&ntilde;a</label>
                        <spring:bind path="passwordConfirm">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="password" path="passwordConfirm" class="form-control"
                                            placeholder=""></form:input>
                                <form:errors path="passwordConfirm"></form:errors>
                            </div>
                        </spring:bind>
                    </div>--%>
                </div>

            </div>

            <p></p>


            <button class="btn btn-lg btn-danger" type="submit">Actualizar</button>

        </div>

    </form:form>


</div>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>