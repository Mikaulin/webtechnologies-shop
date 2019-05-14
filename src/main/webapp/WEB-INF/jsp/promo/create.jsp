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

            <form:form method="POST" modelAttribute="promotionForm" class="form-signin" action="crear">

                <h4 class="mb-3">Dar de alta una promoci&oacute;n</h4>
                <hr>

                <div class="mb-3">
                    <label for="name">Nombre</label>
                    <input type="text" id="name" name="name" class="form-control" required=""/>
                </div>

                <div class="mb-3">
                    <label for="description">Descripci&oacute;n</label>
                    <input type="text" id="description" name="description" class="form-control" required=""/>
                </div>

                <div class="row">
                    <div class="col-md-4 mb-3">
                        <label for="startDate">Fecha Inicio</label>
                        <input type="date" id="startDate" name="startDate" class="form-control" value="" required=""/>
                    </div>

                    <div class="col-md-4 mb-3">
                        <label for="endDate">Fecha Fin</label>
                        <input type="date" id="endDate" name="endDate" class="form-control" value="" required=""/>
                    </div>

                    <div class="col-md-4 mb-3">
                        <label for="discount">Descuento</label>
                        <input type="text" id="discount" name="discount" class="form-control" placeholder="0"
                               required=""/>
                    </div>
                </div>

                <button class="btn btn-lg btn-danger" type="submit">Dar de alta</button>

            </form:form>
        </div>

        <div class="col-md-4 order-md-2 mb-4">

            <div class="card mb-4 shadow-sm">
                <div class="card-header">
                    <h4 class="my-0 font-weight-normal">Promociones existentes</h4>
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