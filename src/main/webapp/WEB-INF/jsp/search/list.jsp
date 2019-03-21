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

             <%-- <c:forEach items="${products}" var="product">
                    <ul class="nav flex-column mb-2">

                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/producto/detalle/${product.brand.id}">
                                <span data-feather="file-text"></span>${product.brand.name}
                            </a>
                        </li>
                    </ul>

                </c:forEach>--%>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 ">

                <%--<h1 class="h2">${products.brand.name}</h1>--%>

                <div class="btn-toolbar mb-2 mb-md-0">


                   <%-- <c:forEach items="${featuredProducts}" var="product">
                        <c:if test="${product.id < 5 and product.count > 0}" >
                            <div class='col-md-3'>
                                <div class='card mb-3 box-shadow'>
                                    <img class='card-img-top' src='${product.photo}' alt='${product.name} '>
                                    <div class='card-body'>
                                        <p class='card-text'>
                                                ${product.brand.name}
                                        </p>
                                        <p class='card-text'>
                                                ${product.name}
                                        </p>
                                        <h4 class='card-title pricing-card-title'>
                                            <fmt:formatNumber currencySymbol="&euro;" value="${product.finalPrice}" type="currency"/>
                                            <c:if test="${product.finalPrice != product.price}" >
                                                <small class='text-muted'>
                                                    <strike> <fmt:formatNumber currencySymbol="&euro;" value="${product.price}" type="currency"/></strike>
                                                </small>
                                            </c:if>
                                        </h4>

                                        <a href='${pageContext.request.contextPath}/producto/detalle/${product.id}'
                                           class='btn btn-outline-danger btn-lg btn-block'
                                           role='button' aria-pressed='true'>
                                            Ver detalles
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>--%>
                </div>
            </div>
        </main>

    </div>



</div>


<%@ include file = "../shared/_js.jsp"%>
<%@ include file = "../shared/_footer.jsp"%>
