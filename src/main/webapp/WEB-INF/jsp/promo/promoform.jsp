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

            <form:form method="POST" modelAttribute="promotionForm" class="form-signin" action="create">

                <h4 class="mb-3">Dar de alta una promoci&oacute;n</h4>
                <hr>

                <div class="mb-3">
                    <label for="name">Nombre</label>
                    <spring:bind path="name">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" path="name" class="form-control" placeholder=""></form:input>
                            <form:errors path="name"></form:errors>
                        </div>
                    </spring:bind>
                </div>

                <div class="mb-3">
                    <label for="description">Descripci&oacute;n</label>
                    <spring:bind path="description">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" path="description" class="form-control" placeholder=""></form:input>
                            <form:errors path="description"></form:errors>
                        </div>
                    </spring:bind>
                </div>

                <div class="row">
                    <div class="col-md-4 mb-3">
                        <label for="startDate">Fecha Inicio</label>
                        <spring:bind path="startDate">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="date" path="startDate" class="form-control"
                                            placeholder=""></form:input>
                                <form:errors path="startDate"></form:errors>
                            </div>
                        </spring:bind>
                            <%-- <mvc:label path="startDate">Fecha Inicio</mvc:label>
                             <mvc:input id="startDate" path="startDate" class="form-control" value="" />--%>

                    </div>

                    <div class="col-md-4 mb-3">
                        <label for="endDate">Fecha Fin</label>
                        <spring:bind path="endDate">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="date" path="endDate" class="form-control" placeholder=""></form:input>
                                <form:errors path="endDate"></form:errors>
                            </div>
                        </spring:bind>
                            <%-- <mvc:label path="endDate">Fecha Fin</mvc:label>&ndash;%&gt;
                             &lt;%&ndash;<mvc:input id="endDate" path="endDate" class="form-control" value="" />--%>

                    </div>

                    <div class="col-md-4 mb-3">

                        <label for="discount">Descuento</label>
                        <spring:bind path="discount">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="discount" class="form-control"
                                            placeholder=""></form:input>
                                <form:errors path="discount"></form:errors>
                            </div>
                        </spring:bind>
                            <%-- <mvc:label path="discount">Descuento</mvc:label>
                             <mvc:input path="discount" class="form-control" value="" />--%>
                    </div>
                </div>

                <button class="btn btn-lg btn-danger" type="submit">Dar de alta</button>

            </form:form>
        </div>

        <div class="col-md-4 order-md-2 mb-4">

            <div class="card mb-4 shadow-sm">
                <div class="card-header">
                    <h4 class="my-0 font-weight-normal">Promociones activas</h4>
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