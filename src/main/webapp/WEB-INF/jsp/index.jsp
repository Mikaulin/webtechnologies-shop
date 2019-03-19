<%@ page import="java.util.List" %>
<%@ page import="uned.webtechnologies.shop.inmemorydb.model.Product" %>

<%@ include file="_header.jsp" %>

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


        <%
            if (request.getAttribute("productList") != null) {
                List<Product> products = (List) request.getAttribute("productList");
                for (Product product : products) {
                    if (product.getId() < 5) {%>


        <div class='col-md-3'>
            <div class='card mb-3 box-shadow'>
                <img class='card-img-top' src='<%=product.getPhoto() %> ' alt='<%=product.getName()%> '>
                <div class='card-body'>
                    <p class='card-text'>
                        <%=product.getBrand().getName()%>
                    </p>
                    <p class='card-text'>
                        <%=product.getName() %>
                    </p>
                    <h4 class='card-title pricing-card-title'>
                        <%=product.getFinalPrice()%> &euro;
                        <small class='text-muted'><strike>
                            <%=product.getPrice()%>
                        </strike></small>
                    </h4>
                    <ul class='list-unstyled mt-3 mb-4'>
                        <li style='color:#FF0000'>
                            Ahorras <%=product.getDif() %> &euro;
                        </li>
                    </ul>
                    <a href='${pageContext.request.contextPath}/product/detail/<%=product.getId()%>' class='btn btn-outline-danger btn-lg btn-block'
                       role='button' aria-pressed='true'>
                        Ver detalles
                    </a>
                </div>
            </div>
        </div>

        <%
                    }
                }
            }
        %>

    </div>

    <p></p>

    <div class="row mb-2">
        <div class="col-md-6">
            <div class="card flex-md-row mb-4 box-shadow h-md-250">
                <div class="card-body d-flex flex-column align-items-start">
                    <strong class="d-inline-block mb-2 text-primary">Promoci&oacute;n del mes</strong>
                    <h3 class="mb-0">
                        <span class="text-dark">SIN IVA</span>
                    </h3>
                    <div class="mb-1 text-muted">en TEKA</div>
                    <p></p>
                    <p class="card-text mb-auto">V&aacute;lido desde el 28 de febrero al 6 de marzo en todos los
                        electrodom&eacute;sticos TEKA. Te descontamos el importe equivalente al IVA.</p>
                    <a href="${pageContext.request.contextPath}/servicios">Continuar leyendo</a>
                </div>
                <img class="card-img-right flex-auto d-none d-md-block"
                     src="${pageContext.request.contextPath}/img/servicios01.jpg" alt="Card image cap">
            </div>
        </div>
        <div class="col-md-6">
            <div class="card flex-md-row mb-4 box-shadow h-md-250">
                <div class="card-body d-flex flex-column align-items-start">
                    <strong class="d-inline-block mb-2 text-primary">Servicios ElectroHOME</strong>
                    <h3 class="mb-0">
                        <span class="text-dark">SOLUCIONES</span>
                    </h3>
                    <div class="mb-1 text-muted">Postventa</div>
                    <p></p>
                    <p class="card-text mb-auto">Servicio de Entregas a Domicilio. Disponible para todos aquellos
                        productos que no disfrutan de entrega a domicilio gratuita.</p>
                    <a href="${pageContext.request.contextPath}/servicios">Continuar leyendo</a>
                </div>
                <img class="card-img-right flex-auto d-none d-md-block"
                     src="${pageContext.request.contextPath}/img/servicios02.jpg" alt="Card image cap">
            </div>
        </div>
    </div>

    <p></p>


</div>

<%@ include file="_js.jsp" %>
<%@ include file="_footer.jsp" %>