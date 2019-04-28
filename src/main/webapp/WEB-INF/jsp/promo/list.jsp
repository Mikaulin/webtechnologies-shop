<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@ include file="../shared/_header.jsp" %>

<%--Script DataTABLE--%>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/table.js"></script>

<div class="container">

    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group" role="group" aria-label="First group">
            <div class="input-group-prepend">
                <h4 class="mb-3">Listado de promociones</h4>
            </div>
        </div>

        <div class="input-group">
            <a href="${pageContext.request.contextPath}/promociones/altaPromociones">
                <button type="button" class="btn btn-success btn-sm">Añadir Promoci&oacute;n</button>
            </a>
        </div>
    </div>

    <div class="border-top my-3"></div>

    <table id="example" class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">T&iacute;tulo</th>
            <%--<th scope="col">Descripci&oacute;n</th>--%>
            <th scope="col">Dto. (%)</th>
            <th scope="col">Fecha Inicio</th>
            <th scope="col">Fecha Fin</th>
            <th scope="col">Activa</th>
            <th scope="col">Acción</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${promotion}" var="promo">
            <tr>
                <td scope="row"> ${promo.id}</td>
                <td> ${promo.name}</td>
                <%--<td>${promo.description}</td>--%>
                <td> ${promo.discount}</td>
                <td> ${promo.startDate.time.toLocaleString().substring(0,11)}</td>
                <td> ${promo.endDate.time.toLocaleString().substring(0,11)}</td>
                <td> ${promo.active}</td>
                <td>
                    <div class="btn-group">

                        <a class="btn btn-sm btn-outline-danger" role="button"
                           href="${pageContext.request.contextPath}/admin/promociones/editar/${promo.id}">Editar</a>
                    </div>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>

</div>

<p>&nbsp;</p>
<p>&nbsp;</p>

<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>