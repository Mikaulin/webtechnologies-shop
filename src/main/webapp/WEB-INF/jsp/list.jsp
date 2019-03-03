

<%@ page import="java.util.List" %>
<%@ page import="uned.webtechnologies.shop.inmemorydb.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file = "_header.jsp"%>

<div class="container">

<h2>Lista de clientes</h2>


    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Nombre</th>
            <th scope="col">Apellidos</th>
            <th scope="col">Direcci&oacute;n</th>
            <th scope="col">Provincia</th>
            <th scope="col">Cp</th>
            <th scope="col">Pais</th>
            <th scope="col">Email</th>
            <th scope="col">Tlf</th>
            <th scope="col">Usuario</th>
            <th scope="col">Contrase&ntilde;a</th>
            <th scope="col">Eliminar</th>
        </tr>
        </thead>
        <tbody>

<%
    if (request.getAttribute("userList") != null) {

        List<User> users = (List) request.getAttribute("userList");

        for (User user : users) {

            out.println("<tr>");
            out.println("<td>"+ user.getId() +"</td>");
            out.println("<td>"+ user.getUserNombre() +"</td>");
            out.println("<td>"+ user.getUserApellidos() +"</td>");
            out.println("<td>"+ user.getUserDireccion() +"</td>");
            out.println("<td>"+ user.getUserProvincia() +"</td>");
            out.println("<td>"+ user.getUserCp() +"</td>");
            out.println("<td>"+ user.getUserPais() +"</td>");
            out.println("<td>"+ user.getUserEmail() +"</td>");
            out.println("<td>"+ user.getUserTlf() +"</td>");
            out.println("<td>"+ user.getUserName() +"</td>");
            out.println("<td>"+ user.getUserPwd() +"</td>");
            out.println("<td><a href='${pageContext.request.contextPath}/${product.id}'>Borrar</a></td>");
            out.println("</tr>");

        }
    }
%>
    </tbody>
    </table>

</div>

<%@ include file = "_js.jsp"%>
<%@ include file = "_footer.jsp"%>
