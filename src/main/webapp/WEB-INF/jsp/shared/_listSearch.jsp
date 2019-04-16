<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 ">

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