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
                            <label for="name">Nombre</label>
                            <spring:bind path="name">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="name" class="form-control" placeholder=""
                                                value="${editUser.name}"></form:input>
                                    <form:errors path="name"></form:errors>
                                </div>
                            </spring:bind>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="lastname1">Apellido</label>
                            <spring:bind path="lastname1">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="lastname1" class="form-control" placeholder=""
                                                value="${editUser.lastname1}"></form:input>
                                    <form:errors path="lastname1"></form:errors>
                                </div>
                            </spring:bind>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="email">Email</label>
                            <spring:bind path="email">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="email" class="form-control" placeholder=""
                                                value="${editUser.email}"></form:input>
                                    <form:errors path="email"></form:errors>
                                </div>
                            </spring:bind>
                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="phone">Tel&eacute;fono</label>
                            <spring:bind path="phone">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="phone" class="form-control" placeholder=""
                                                value="${editUser.phone}"></form:input>
                                    <form:errors path="phone"></form:errors>
                                </div>
                            </spring:bind>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-9 mb-3">
                            <label for="direction">Direcci&oacute;n</label>
                            <spring:bind path="direction">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="direction" class="form-control" placeholder=""
                                                value="${editUser.direction}"></form:input>
                                    <form:errors path="direction"></form:errors>
                                </div>
                            </spring:bind>
                        </div>

                        <div class="col-md-3 mb-3">
                            <label for="postalCode">C.P.</label>
                            <spring:bind path="postalCode">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="postalCode" class="form-control" placeholder=""
                                                value="${editUser.postalCode}"></form:input>
                                    <form:errors path="postalCode"></form:errors>
                                </div>
                            </spring:bind>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-4 mb-3">
                            <label for="city">Ciudad</label>
                            <spring:bind path="city">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="city" class="form-control" placeholder=""
                                                value="${editUser.city}"></form:input>
                                    <form:errors path="city"></form:errors>
                                </div>
                            </spring:bind>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="province">Provincia</label>
                            <spring:bind path="province">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="province" class="form-control" placeholder=""
                                                value="${editUser.province}"></form:input>
                                    <form:errors path="province"></form:errors>
                                </div>
                            </spring:bind>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="country">Pa&iacute;s</label>
                            <spring:bind path="country">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="country" class="form-control" placeholder=""
                                                value="${editUser.country}"></form:input>
                                    <form:errors path="country"></form:errors>
                                </div>
                            </spring:bind>
                        </div>
                    </div>

                </div>

                <div class="col-md-4 order-md-2 mb-4">

                    <div class="mb-3">
                        <label for="username">Usuario</label>
                        <spring:bind path="username">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="username" class="form-control" placeholder=""
                                            value="${editUser.username}"></form:input>
                                <form:errors path="username"></form:errors>
                            </div>
                        </spring:bind>

                    </div>

                    <div class="mb-3">
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
                    </div>
                </div>

            </div>

            <p></p>


            <button class="btn btn-lg btn-danger" type="submit">Actualizar</button>

        </div>

    </form:form>


</div>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>