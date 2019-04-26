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
                        <div class="col-md-6">
                            <div class="card mb-4 shadow-sm">
                                <img class="card-img-right flex-auto d-none d-md-block"
                                     src="${pageContext.request.contextPath}/img/siemensPromo01.jpg" alt="">
                                <div class="card-body">
                                    <h5 class="card-title">5 a&ntilde;os de garant&iacute;a total</h5>
                                    <p class="card-text">Por adquirir un electrodom&eacute;stico de una selecci&oacute;n
                                        de siemens.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="card mb-4 shadow-sm">
                                <img class="card-img-right flex-auto d-none d-md-block"
                                     src="${pageContext.request.contextPath}/img/siemensPromo02.jpg" alt="">

                                <div class="card-body">
                                    <h5 class="card-title">Instalaci&oacute;n gratuita cocci&oacute;n</h5>
                                    <p class="card-text">Por la compra del horno iQ700 o una placa de inducci&oacute;n
                                        iQ710.</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <p></p>

                    <div class="card mb-4 shadow-sm">
                        <img class="card-img-right flex-auto d-none d-md-block"
                             src="${pageContext.request.contextPath}/img/samsungPromo.jpg" alt="">
                        <div class="card-body">
                            <h5 class="card-title">Ll&eacute;vate este TV de 24'' de regalo</h5>
                            <p class="card-text">Se admitir&aacute;n registros hasta el 21 de marzo de 2019.</p>
                        </div>
                    </div>

                    <p></p>

                    <div class="card mb-4 shadow-sm">
                        <img class="card-img-right flex-auto d-none d-md-block"
                             src="${pageContext.request.contextPath}/img/boschPromo.jpg" alt="">
                        <div class="card-body">
                            <h5 class="card-title">Lava como siempre, seca como nunca</h5>
                            <p class="card-text">Lavadoras con funci&oacute;n secado de Bosch.</p>
                        </div>
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
