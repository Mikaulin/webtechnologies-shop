<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="uned.webtechnologies.shop.inmemorydb.model.Product" %>
<%@ include file = "../_header.jsp"%>

<%

    Product product=(Product) request.getAttribute("product");
   /* int idProduct = Integer.parseInt(request.getParameter("id"))-1;
    List<Product> products = (List) request.getAttribute("productList");*/
%>


<div class="container">

<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <% out.println("<h1 class='page-header'>"+ product.getName()+" </h1>");%>
        <hr>
    </div>
</div>
<!-- /.row -->

<div class="row">

    <div class="col-sm-12 col-md-12 col-lg-6 mb-4">

        <!-- There's only One image -->
        <div class="">
            <div class="main-product-image">
                <% out.println("<img src='"+product.getPhoto()+" ' alt='' class='img-fluid'>");%>
            </div>
        </div>

    </div>

    <div class="col-sm-12 col-md-12 col-lg-6">
        <div class="col-sm-12">
            <form class="form-horizontal" action="" method="post" enctype="multipart/form-data" name="buy">
                <div>

                    <div class="form-group row">
                        <label class="col-sm-3 col-md-3 form-control-label">Marca:</label>
                        <div class="col-sm-9 col-md-9">
                            <% out.println("<p>"+ product.getBrand().getName() +"</p>");%>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-3 col-md-3 form-control-label">Descripción:</label>
                        <div class="col-sm-8 col-md-9 description">
                            <% out.println("<p>"+ product.getName() +"</p>");%>
                        </div>
                    </div>

                    <div class="form-group price_elem row">
                        <label class="col-sm-3 col-md-3 form-control-label nopaddingtop">Precio:</label>
                        <div class="col-sm-8 col-md-9">
                            <span class="product-form-price" id="product-form-price">
                                    <% out.println("<h4><b>"+ product.getFinalPrice() + " &euro;</b><small class='text-muted'> <strike>" + product.getPrice() + "</strike></small></h4> ");%></span>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-3 col-md-3 form-control-label">Ahorras:</label>
                        <div class="col-sm-8 col-md-9 description">
                            <% out.println("<p style='color:red'>"+ product.getDif() +" &euro;</p>");%>
                        </div>
                    </div>


                    <div class="form-group row">
                        <label for="input-qty" class="col-sm-3 col-md-3 form-control-label">Cantidad:</label>
                        <div class="col-sm-8 col-md-9">

                            <input type="number" class="qty form-control" id="input-qty" name="qty" maxlength="5" value="1"   >
                        </div>
                    </div>

                    <!-- Out of Stock -->
                    <%
                    if (product.getCount() < 1) {
                    out.println("<div class='form-group product-stock product-out-stock row hidden' >");
                    out.println("<label class='col-sm-3 col-md-3 form-control-label' > Disponibilidad:</label >");
                    out.println("<div class='col-sm-8 col-md-9' >");
                    out.println("<span class='product-form-price' > Agotado </span >");
                    out.println("<p > Este producto se ha quedado sin stock.Puedes preguntarnos por el.</p >");
                    out.println("<a href = '/es/contact' class='btn btn-secondary btn-sm' title = 'Contáctanos' > Contáctanos </a >");
                    out.println("<a href = 'https://bootstrap.jumpseller.com' class='btn btn-link btn-sm' title = '&larr; Continue Comprando' > & larr; Continua Comprando</a >");
                    out.println("</div >");
                    out.println("</div >");

                    }
                    %>

                    <div class="form-group product-stock product-available row visible">
                        <label class="col-sm-3 col-md-3 form-control-label"></label>
                        <div class="col-sm-8 col-sm-offset-3 col-md-9 col-md-offset-3">
                            <input type="submit" class="adc btn btn-danger" value="A&ntilde;adir a la cesta" /><p><br></p>
                            <a href="/" class="btn btn-link btn-sm" title="Continúa Comprando">&larr; Contin&uacute;a Comprando</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</div>


<%@ include file = "../_js.jsp"%>
<%@ include file = "../_footer.jsp"%>
