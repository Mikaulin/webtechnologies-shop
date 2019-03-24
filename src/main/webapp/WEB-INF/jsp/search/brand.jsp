<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file = "../shared/_header.jsp"%>


<div class="container">

    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">

            <div class="sidebar-sticky">

                <h5 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                    <span>MARCAS</span>
                </h5>

                <c:forEach items="${marca}" var="brand">
                <ul class="nav flex-column mb-2">

                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/producto/marcas/${brand.id}">
                            <span data-feather="file-text"></span>${brand.name}
                        </a>
                    </li>
                </ul>

                </c:forEach>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 ">

                <div class="btn-toolbar mb-2 mb-md-0">
                <img class="card-img-right flex-auto d-none d-md-block"
                     src="${pageContext.request.contextPath}/img/promoMarcas.jpg" alt="">
                </div>
            </div>
        </main>

    </div>

</div>


<%@ include file = "../shared/_js.jsp"%>
<%@ include file = "../shared/_footer.jsp"%>
