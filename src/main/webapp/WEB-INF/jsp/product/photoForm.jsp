<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@ include file="../shared/_header.jsp" %>

<div class="container">
    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group" role="group" aria-label="First group">
            <div class="input-group-prepend">
                <h4 class="mb-3">Listado de ventas</h4>
            </div>
        </div>

        <div class="input-group">
            <a href="${pageContext.request.contextPath}/admin/ventas/fecha">
                <button type="button" class="btn btn-success btn-sm">Informes</button>
            </a>
        </div>
    </div>

    <div class="border-top my-3"></div>

    <table id="example" class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Foto</th>
            <th scope="col">Url</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${photos}" var="photo" >
            <tr>
                <td scope="row">${photo.id}</td>
                <td width="100"><img class="card-img-top" src="${pageContext.request.contextPath}/electro/${photo.url}" alt="foto producto" ></td>
                <td width="280"> ${photo.url}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

</div>
<form action="imagenes" method="post" enctype="multipart/form-data">

    <table>

        <tr>
            <td>Select File</td>
            <td><input type="file" name="file"></td>
            <td><button type="submit">Upload</button></td>
        </tr>
    </table>
</form>

<p>&nbsp;</p>
<p>&nbsp;</p>

<%@ include file="../shared/_js.jsp" %>
<%--Script DataTABLE--%>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/table.js"></script>
<%@ include file="../shared/_footer.jsp" %>


