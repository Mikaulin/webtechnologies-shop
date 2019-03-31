<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group" role="group" aria-label="First group">
            <div class="input-group-prepend">
                <h4 class="mb-3">${product.name}</h4>
            </div>
        </div>

        <div class="input-group">
            <a href="javascript:history.back()" title="Continúa Comprando">
                <button type="button" class="btn btn-success btn-sm">Continuar comprando</button>
            </a>
        </div>
    </div>

    <div class="border-top my-3"></div>

    <%--  <div class="row">
          <div class="col-md-12 col-sm-12 col-xs-12">
              <h1 class='page-header'>${product.name}</h1>
              <hr>
          </div>
      </div>--%>

    <div class="row">

        <div class="col-sm-12 col-md-12 col-lg-6 mb-4">

            <div class="">
                <div class="main-product-image">
                    <img src='${pageContext.request.contextPath}/electro/${product.photo}' alt='' class='img-fluid'>
                </div>
            </div>
        </div>

        <div class="col-sm-12 col-md-12 col-lg-6">
            <div class="col-sm-12">
                <form id="buy-form" class="form-horizontal" action="" method="post" enctype="multipart/form-data"
                      name="buy">
                    <div>

                        <div class="form-group row">
                            <label class="col-sm-3 col-md-3 form-control-label">Marca:</label>
                            <div class="col-sm-9 col-md-9">
                                <p>${product.brand.name}</p>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 col-md-3 form-control-label">Descripción:</label>
                            <div class="col-sm-8 col-md-9 description">
                                <p>${product.description}</p>
                            </div>
                        </div>

                        <div class="form-group price_elem row">
                            <label class="col-sm-3 col-md-3 form-control-label nopaddingtop">Precio:</label>
                            <div class="col-sm-8 col-md-9">
                                <span class="product-form-price" id="product-form-price">
                                    <h4><b> ${product.finalPrice} &euro;</b>
                                        <c:if test="${product.finalPrice != product.price}">
                                            <small class='text-muted'>
                                                <del>${product.price} &euro;</del>
                                            </small>
                                        </c:if>
                                    </h4>
                                </span>
                            </div>
                        </div>
                        <c:if test="${product.dif != 0}">
                            <div class="form-group row">
                                <label class="col-sm-3 col-md-3 form-control-label">Ahorras:</label>
                                <div class="col-sm-8 col-md-9 description">
                                    <p class="text-danger"><fmt:formatNumber currencySymbol="&euro;"
                                                                             value="${product.dif}"
                                                                             type="currency"/></p>
                                </div>
                            </div>
                        </c:if>
                        <div class="form-group dimension_elem row">
                            <label class="col-sm-3 col-md-3 form-control-label nopaddingtop">Dimensiones:</label>
                            <div class="col-sm-8 col-md-9 description">
                                <p> ${product.width}
                                    <small>mm.</small>
                                    x ${product.depth}
                                    <small>mm.</small>
                                    x ${product.height}
                                    <small>mm.</small>
                                    <br>
                                    <small>(ancho x profundidad x alto)</small>
                                </p>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 col-md-3 form-control-label">Valoración:</label>
                            <div class="row col-sm-8 col-md-9">
                                <div class="col-4">
                                    <%@ include file="../shared/_rating.jsp" %>
                                </div>
                                <div class="col-4">
                                    (${product.ratingList.size()} votos)
                                </div>
                            </div>
                        </div>


                        <div class="form-group row">
                            <label class="col-sm-3 col-md-3 form-control-label"
                                   for="exampleFormControlSelect1">Puntuar:</label>
                            <div class="row col-sm-9 col-md-9">

                                <div class="col-6">
                                    <select class="form-control" id="exampleFormControlSelect1">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                </div>
                                <div class="col-3">
                                    <button type="button" class="btn btn-secondary ">Votar</button>
                                </div>

                            </div>
                        </div>

                        <div class='form-group product-stock product-out-stock row hidden'>
                            <label class='col-sm-3 col-md-3 form-control-label'> Disponibilidad:</label>
                            <div class='col-sm-8 col-md-9'>

                                <c:choose>
                                    <c:when test="${product.count <= 0}">
                                        <span class='product-form-price' style="color: red"> Agotado </span>
                                        <p> Si lo desea podemos avisarle en cuanto tengamos el producto de nuevo en
                                            stock.</p>
                                        <a href='${pageContext.request.contextPath}/' class='btn btn-secondary btn-sm'
                                           title='Contáctanos'> Contáctanos </a>
                                    </c:when>
                                    <c:otherwise>
                                        <span class='product-form-price'> Disponible </span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="input-qty"
                                   class="col-sm-3 col-md-3 form-control-label">Cantidad:</label>
                            <div class="col-sm-6 col-md-6">
                                <c:choose>
                                    <c:when test="${product.count <= 0}">
                                        <span class='product-form-price'> Producto sin unidades.</span>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="number" class="qty form-control" id="input-qty" name="qty"
                                               maxlength="5"
                                               value="1">
                                        <input type="hidden" id="productId" name="productId" value="${product.id}">
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>


                        <div class="form-group product-stock product-available row visible">
                            <label class="col-sm-3 col-md-3 form-control-label"></label>
                            <div class="col-sm-8 col-sm-offset-3 col-md-9 col-md-offset-3">

                                <c:choose>
                                    <c:when test="${product.count <= 0}">

                                    </c:when>
                                    <c:otherwise>
                                        <br>
                                           <input type="submit" id="add-to-cart" class="adc btn btn-danger"
                                                  value="A&ntilde;adir a la cesta"/>
                                       </c:otherwise>
                                   </c:choose>

                                   <%-- <p>&nbsp;</p> --%>

                               </div>
                           </div>

                       </div>
                   </form>
               </div>
           </div>
       </div>

   </div>

   <p>&nbsp;</p>
   <p>&nbsp;</p>

   <%@ include file="../shared/_js.jsp" %>
   <%@ include file="../shared/_footer.jsp" %>
