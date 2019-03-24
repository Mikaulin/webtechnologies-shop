<%@ include file="shared/_header.jsp" %>

<div class="container">

    <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100" src="${pageContext.request.contextPath}/img/promo1.jpg" alt="First slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="${pageContext.request.contextPath}/img/promo2.jpg" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="${pageContext.request.contextPath}/img/promo3.jpg" alt="Third slide">
            </div>
        </div>
    </div>
    <p><br></p>

    <div class="row">
        <c:forEach items="${featuredProducts}" var="product">
            <%--TODO en lugar de limitar los productos a mostrar aqui deberia hacerse mediante el boolean FEATURED de cada producto --%>
        <c:if test="${product.id < 5 and product.count > 0}">
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
                        <c:if test="${product.finalPrice != product.price}">
                            <small class='text-muted'>
                                <strike> <fmt:formatNumber currencySymbol="&euro;" value="${product.price}"
                                                           type="currency"/></strike>
                            </small>
                        </c:if>
                    </h4>


                        <p>Rating del producto = ${rating.getProductRating(product.id)}</p>


                            <a href='${pageContext.request.contextPath}/producto/detalle/${product.id}'
                               class='btn btn-outline-danger btn-lg btn-block'
                               role='button' aria-pressed='true'>
                                Ver detalles
                            </a>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>

    <p></p>

    <div class=" row mb-2">
                    <div class="col-md-6">
                        <div class="card flex-md-row mb-4 box-shadow h-md-250">
                            <div class="card-body d-flex flex-column align-items-start">
                                <strong class="d-inline-block mb-2 text-danger">Promoci&oacute;n del mes</strong>
                                <h3 class="mb-0">
                                    <span class="text-dark">SIN IVA</span>
                                </h3>
                                <div class="mb-1 text-muted">en TEKA</div>
                                <p></p>
                                <p class="card-text mb-auto">V&aacute;lido desde el 28 de febrero al 6 de marzo en todos
                                    los
                                    electrodom&eacute;sticos TEKA. Te descontamos el importe equivalente al IVA.</p>
                                <a href="${pageContext.request.contextPath}/ofertas">Continuar leyendo</a>
                            </div>
                            <img class="card-img-right flex-auto d-none d-md-block"
                                 src="${pageContext.request.contextPath}/img/servicios01.jpg" alt="Card image cap">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="card flex-md-row mb-4 box-shadow h-md-250">
                            <div class="card-body d-flex flex-column align-items-start">
                                <strong class="d-inline-block mb-2 text-danger">Servicios ElectroHOME</strong>
                                <h3 class="mb-0">
                                    <span class="text-dark">SOLUCIONES</span>
                                </h3>
                                <div class="mb-1 text-muted">Postventa</div>
                                <p></p>
                                <p class="card-text mb-auto">Servicio de Entregas a Domicilio. Disponible para todos
                                    aquellos
                                    productos que no disfrutan de entrega a domicilio gratuita.</p>
                                <a href="${pageContext.request.contextPath}/servicios">Continuar leyendo</a>
                            </div>
                            <img class="card-img-right flex-auto d-none d-md-block"
                                 src="${pageContext.request.contextPath}/img/servicios02.jpg" alt="">
                        </div>
                    </div>
                </div>

                <p></p>


                <div class="row">
                    <c:forEach items="${featuredProducts}" var="product">
                        <c:if test="${product.id > 4 and product.id < 9 and product.count > 0}">
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
                                            <fmt:formatNumber currencySymbol="&euro;" value="${product.finalPrice}"
                                                              type="currency"/>
                                            <c:if test="${product.finalPrice != product.price}">
                                                <small class='text-muted'>
                                                    <strike> <fmt:formatNumber currencySymbol="&euro;"
                                                                               value="${product.price}"
                                                                               type="currency"/></strike>
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
                    </c:forEach>
                </div>

            </div>

            <p>&nbsp;</p>
            <p>&nbsp;</p>

            <%@ include file="shared/_js.jsp" %>
<%@ include file="shared/_footer.jsp" %>