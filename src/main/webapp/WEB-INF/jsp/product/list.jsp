<%@page contentType="text/html"%>

<%@page pageEncoding="UTF-8"%>

<%@ include file = "../shared/_header.jsp"%>

<div class="container">

    <div class="col-12">
       <div class="row">

               <table id="example" class="table table-striped" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Nombre</th>
            <th scope="col">Descripci&oacute;n</th>
            <th scope="col">Imagen</th>
            <th scope="col">Precio</th>
            <th scope="col">Dto.</th>
<%--        <th scope="col">Ancho (mm)</th>
            <th scope="col">Profund.(mm)</th>
            <th scope="col">Alto (mm)</th>--%>
            <th scope="col">Categor&iacute;a</th>
            <th scope="col">Marca</th>
            <th scope="col">Ud.</th>
            <th scope="col">Desc.</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${products}" var="product">

                 <tr>
                    <td scope="row">${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.photo}</td>
                    <td>${product.price}</td>
                    <td>${product.discount}</td>
<%--                <td>${product.width}</td>
                    <td>${product.depth}</td>
                    <td>${product.height}</td>--%>
                    <td>${product.category.name}</td>
                    <td>${product.brand.name}</td>
                    <td>${product.count}</td>
                    <td>${product.deleted}</td>
                     <td>
                      <div class="btn-group">
                         <a class="btn btn-sm btn-outline-info" role="button" href="${pageContext.request.contextPath}/producto/detalle/${product.id}">View</a>
                         <a class="btn btn-sm btn-outline-danger" role="button" href="${pageContext.request.contextPath}/producto/editar/${product.id}">Edit</a>
                       </div>
                     </td>
                 </tr>

            </c:forEach>
         </tbody>
        </table>
      </div>
    </div>

</div>

<p>&nbsp;</p><p>&nbsp;</p>

<%@ include file = "../shared/_js.jsp"%>
<%@ include file = "../shared/_footer.jsp"%>
