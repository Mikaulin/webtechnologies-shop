<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">

            <div class="sidebar-sticky">

                <h5 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                    <span>PROMOCIONES</span>
                </h5>
                <c:forEach items="${promotion}" var="promo">
                    <ul class="nav flex-column mb-2">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/promociones/${promo.id}">
                                <span data-feather="file-text">${promo.name}</span>
                            </a>
                        </li>
                    </ul>
                </c:forEach>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 ">

                <div class="btn-toolbar mb-2 mb-md-0">
                    <div class="row">
                        <c:forEach items="${products}" var="product">

                            <div class='col-md-4'>
                                <div class='card mb-4 box-shadow'>
                                    <img class='card-img-top'
                                         src='${pageContext.request.contextPath}/electro/${product.photo}'
                                         alt='${product.name} '>
                                    <div class='card-body'>
                                        <p class='card-text'>
                                                ${product.brand.name}
                                        </p>
                                        <p class='card-text'>
                                                ${product.name}
                                        </p>
                                        <h4 class='card-title pricing-card-title'>
                                            <fmt:formatNumber currencySymbol="&euro;" value="${product.finalPrice}"
                                                              type="currency"/>
                                            <c:if test="${product.finalPrice != product.price}">
                                                <small class='text-muted'>
                                                    <del><fmt:formatNumber currencySymbol="&euro;"
                                                                           value="${product.price}"
                                                                           type="currency"/></del>
                                                </small>
                                            </c:if>
                                        </h4>

                                        <%@ include file="../shared/_rating.jsp" %>

                                        <a href='${pageContext.request.contextPath}/producto/detalle/${product.id}'
                                           class='btn btn-outline-danger btn-lg btn-block'
                                           role='button' aria-pressed='true'>
                                            Ver detalles
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </main>
    </div>

</div>

<p>&nbsp;</p>
<p>&nbsp;</p>

<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>
