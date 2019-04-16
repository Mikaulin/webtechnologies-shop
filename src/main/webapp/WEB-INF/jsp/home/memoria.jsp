<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <div class="row">

        <%@ include file="../shared/_doc.jsp" %>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

            <embed src="${pageContext.request.contextPath}/doc/memoria.pdf" width="100%" height="700"
                   style="border: none;">
        </main>
    </div>

</div>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>


