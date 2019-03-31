<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@ include file="../shared/_header.jsp" %>

<div class="container">

    <div class="row">
        <div class="col-md-8 order-md-1">

            <form:form method="POST" modelAttribute="editPromo" class="form-signin">

                <h4 class="mb-3">Editar una promoci&oacute;n</h4>
                <hr>

                <div class="mb-3">
                    <form:label path="name">Nombre</form:label>
                    <form:input path="name" class="form-control" value="${editPromo.name}"/>
                </div>

                <div class="mb-3">
                    <form:label path="description">Descripci&oacute;n</form:label>
                    <form:input path="description" class="form-control" value="${editPromo.description}"/>
                </div>

                <div class="row">

                    <div class="col-md-4 mb-3">
                        <form:label path="startDate">Fecha Inicio</form:label>
                        <form:input type="date" path="startDate" class="form-control" value=""/>
                    </div>

                    <div class="col-md-4 mb-3">
                        <form:label path="endDate">Fecha Fin</form:label>
                        <form:input type="date" path="endDate" class="form-control" value=""/>

                    </div>

                    <div class="col-md-4 mb-3">
                        <form:label path="discount">Descuento</form:label>
                        <form:input path="discount" class="form-control" value="${editPromo.discount}"/>
                    </div>
                </div>

                <button class="btn btn-lg btn-danger" type="submit">Actualizar</button>

            </form:form>
        </div>

        <div class="col-md-4 order-md-2 mb-4">
            <div class="card mb-4 shadow-sm">
                <div class="card-header">
                    <h4 class="my-0 font-weight-normal">Lista Promociones</h4>
                </div>

                <div class="card-body">
                    <ul class="list-unstyled mt-3 mb-4">
                        <c:forEach items="${promotion}" var="promo">
                            <li>
                                <div class="form-group form-check">
                                    <label class="form-check-label">${promo.name}</label>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>