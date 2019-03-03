
<%@ page import="java.util.List" %>
<%@ page import="uned.webtechnologies.shop.inmemorydb.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file = "_header.jsp"%>

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

                        if (product.getId()<5) {

                            out.println("<div class='col-md-3'>");
                            out.println("<div class='card mb-3 box-shadow'>");
                            out.println("<img class='card-img-top' src='../" + product.getFoto() + "' alt='" + product.getDescripcion() + "'>");
                            out.println("<div class='card-body'>");
                            out.println("<p class='card-text'>" + product.getMarca() + "</p>");
                            out.println("<p class='card-text'>" + product.getDescripcion() + "</p>");
                            out.println("<h4 class='card-title pricing-card-title'>" + product.getPriceRbj() + " &euro; <small class='text-muted'> <strike>" + product.getPriceOrg() + "</strike></small></h4>");
                            out.println("<ul class='list-unstyled mt-3 mb-4'>");
                            out.println("<li style='color:#FF0000'>Ahorras " + product.getAhorro() + " &euro;</li>");
                            out.println("</ul>");
                            out.println("<a href='product?id="+ product.getId() +"' class='btn btn-outline-danger btn-lg btn-block' role='button' aria-pressed='true'>Ver detalles</a>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");

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
                        <span class="text-dark" >SIN IVA</span>
                    </h3>
                    <div class="mb-1 text-muted">en TEKA</div><p></p>
                    <p class="card-text mb-auto">V&aacute;lido desde el 28 de febrero al 6 de marzo en todos los electrodom&eacute;sticos TEKA. Te descontamos el importe equivalente al IVA.</p>
                    <a href="${pageContext.request.contextPath}/servicios">Continuar leyendo</a>
                </div>
                <img class="card-img-right flex-auto d-none d-md-block" src="${pageContext.request.contextPath}/img/servicios01.jpg" alt="Card image cap">
            </div>
        </div>
        <div class="col-md-6">
            <div class="card flex-md-row mb-4 box-shadow h-md-250">
                <div class="card-body d-flex flex-column align-items-start">
                    <strong class="d-inline-block mb-2 text-primary">Servicios ElectroHOME</strong>
                    <h3 class="mb-0">
                        <span class="text-dark" >SOLUCIONES</span>
                    </h3>
                    <div class="mb-1 text-muted">Postventa</div><p></p>
                    <p class="card-text mb-auto">Servicio de Entregas a Domicilio. Disponible para todos aquellos productos que no disfrutan de entrega a domicilio gratuita.</p>
                    <a href="${pageContext.request.contextPath}/servicios">Continuar leyendo</a>
                </div>
                <img class="card-img-right flex-auto d-none d-md-block" src="${pageContext.request.contextPath}/img/servicios02.jpg" alt="Card image cap">
            </div>
        </div>
    </div>

    <p></p>

    <div class="row">


        <%
            if (request.getAttribute("productList") != null) {

                List<Product> products = (List) request.getAttribute("productList");

                for (Product product : products) {

                    if (product.getId()>4) {

                        out.println("<div class='col-md-3'>");
                        out.println("<div class='card mb-3 box-shadow'>");
                        out.println("<img class='card-img-top' src='../" + product.getFoto() + "' alt='" + product.getDescripcion() + "'>");
                        out.println("<div class='card-body'>");
                        out.println("<p class='card-text'>" + product.getMarca() + "</p>");
                        out.println("<p class='card-text'>" + product.getDescripcion() + "</p>");
                        out.println("<h4 class='card-title pricing-card-title'>" + product.getPriceRbj() + " &euro; <small class='text-muted'> <strike>" + product.getPriceOrg() + "</strike></small></h4>");
                        out.println("<ul class='list-unstyled mt-3 mb-4'>");
                        out.println("<li style='color:#FF0000'>Ahorras " + product.getAhorro() + " &euro;</li>");
                        out.println("</ul>");
                        out.println("<a href='product?id="+ product.getId() +"' class='btn btn-outline-danger btn-lg btn-block' role='button' aria-pressed='true'>Ver detalles</a>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</div>");

                    }
                }
            }

        %>

    </div>



    <p>&nbsp;</p><p>&nbsp;</p>


</div>

<%@ include file = "_js.jsp"%>
<%@ include file = "_footer.jsp"%>
