<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>

<%@ include file = "../_header.jsp"%>


<h1>Agregar nuevo producto:</h1>

<mvc:form modelAttribute="product" action="create">
    <table>
        <tr>
            <td><mvc:label path="id">ID</mvc:label></td>
            <td><mvc:input path="id"/></td>
        </tr>
        <tr>
            <td><mvc:label path="name">Nombre</mvc:label></td>
            <td><mvc:input path="name"/></td>
        </tr>
        <tr>
            <td><mvc:label path="price">Precio</mvc:label></td>
            <td><mvc:input path="price"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Enviar producto..."/>
            </td>
        </tr>
    </table>
</mvc:form>


<%@ include file = "../_js.jsp"%>
<%@ include file = "../_footer.jsp"%>
