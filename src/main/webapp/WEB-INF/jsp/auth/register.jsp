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
                        <spring:bind path="name">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="name" class="form-control" placeholder="" />
                                <form:errors path="name" />
                            </div>
                        </spring:bind>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="lastname1">Apellido</label>
                        <spring:bind path="lastname1">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="lastname1" class="form-control" placeholder="" />
                                <form:errors path="lastname1" />
                            </div>
                        </spring:bind>
                    </div>
                </div>


                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="email">Email</label>
                        <spring:bind path="email">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="email" class="form-control" placeholder="" />
                                <form:errors path="email" />
                            </div>
                        </spring:bind>
                    </div>

                    <div class="col-md-6 mb-3">
                        <label for="phone">Tel&eacute;fono</label>
                        <spring:bind path="phone">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="phone" class="form-control" placeholder="" />
                                <form:errors path="phone" />
                            </div>
                        </spring:bind>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-9 mb-3">
                        <label for="direction">Direcci&oacute;n</label>
                        <spring:bind path="direction">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="direction" class="form-control" placeholder="" />
                                <form:errors path="direction" />
                            </div>
                        </spring:bind>
                    </div>

                    <div class="col-md-3 mb-3">
                        <label for="postalCode">C.P.</label>
                        <spring:bind path="postalCode">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="postalCode" class="form-control" placeholder="" />
                                <form:errors path="postalCode" />
                            </div>
                        </spring:bind>
                    </div>
                </div>


                <div class="row">
                    <div class="col-md-4 mb-3">
                        <label for="city">Ciudad</label>
                        <spring:bind path="city">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="city" class="form-control" placeholder="" />
                                <form:errors path="city" />
                            </div>
                        </spring:bind>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="province">Provincia</label>
                        <spring:bind path="province">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="province" class="form-control" placeholder="" />
                                <form:errors path="province" />
                            </div>
                        </spring:bind>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="country">Pa&iacute;s</label>
                        <spring:bind path="country">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="country" class="form-control" placeholder="" />
                                <form:errors path="country" />
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