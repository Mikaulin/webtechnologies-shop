<%@ page import="java.util.List" %>
<%@ page import="uned.webtechnologies.shop.inmemorydb.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Lista de usuarios</h2>
<%
    if (request.getAttribute("userList") != null) {
        List<User> users = (List) request.getAttribute("userList");
        for (User user : users) {
        %>
            <p>(<%= user.getUsername() %>)</p>
        <%
        }
    }
%>

</body>
</html>
