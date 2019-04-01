<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@ include file="../shared/_header.jsp" %>

<div class="container">

    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">

            <div class="sidebar-sticky">
                <h5 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                    <span>MANUAL</span>
                </h5><br>
                <p>Los integrantes del equipo que han desarrollado este proyecto son:</p>
                <ul class="nav flex-column mb-2">
                    <li class="nav-item">
                        <a class="nav-link" href="mailto:pablo@hotmail.com">
                            <span data-feather="file-text">Pablo Uzquiano</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="mailto:mikel@hotmail.com">
                            <span data-feather="file-text">Mikel Mikaulin</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="mailto:kike@hotmail.com">
                            <span data-feather="file-text">Enrique Pérez</span>
                        </a>
                    </li>
                </ul>
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
