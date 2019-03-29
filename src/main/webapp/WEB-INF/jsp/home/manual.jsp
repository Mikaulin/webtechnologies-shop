<%@ include file="../shared/_header.jsp" %>

<div class="container">

    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">

            <div class="sidebar-sticky">
                <h5 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                    <span>MANUAL</span>
                </h5>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

            <embed src="${pageContext.request.contextPath}/doc/manual.pdf" width="100%" height="700"
                   style="border: none;">
        </main>
    </div>

</div>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>
