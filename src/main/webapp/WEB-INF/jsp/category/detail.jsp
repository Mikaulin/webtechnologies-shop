<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../shared/_header.jsp" %>

<div class="container">

    <h4>Categor&iacute;as</h4>

    <div class="border-top my-3"></div>

    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">

                <p>&nbsp;</p>

                <c:forEach items="${category}" var="c">
                    <ul class="nav flex-column mb-2">

                        <c:choose>
                            <c:when test="${c.id eq id}">
                                <li class="nav-item"><h6><b>&nbsp;&nbsp; ${c.name}</b></h6></li>
                            </c:when>

                            <c:otherwise>
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/categorias/${c.id}">
                                        <span data-feather="file-text">${c.name}</span>
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </ul>

                </c:forEach>
            </div>
        </nav>

        <%@ include file="../shared/_listSearch.jsp" %>

    </div>

</div>

<p>&nbsp;</p>
<p>&nbsp;</p>

<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>
