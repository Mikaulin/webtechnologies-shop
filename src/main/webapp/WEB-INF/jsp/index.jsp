

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

    <div class="album py-5 ">
        <div class="container">

            <div class="row">
                <div class="col-md-3">
                    <div class="card mb-3 box-shadow">
                        <img class="card-img-top" src="${pageContext.request.contextPath}/electro/002.jpg" alt="Frigor&iacute;fico Combi GBB60SWGFS">
                        <div class="card-body">
                            <p class="card-text">LG</p>
                            <p class="card-text">Frigor&iacute;fico Combi GBB60SWGFS</p>
                            <h4 class="card-title pricing-card-title">599,99 &euro; <small class="text-muted"> <strike> 799,99</strike></small></h4>
                            <ul class="list-unstyled mt-3 mb-4">
                                <li style="color:#FF0000">Ahorras 200 &euro;</li>
                            </ul>
                            <button type="button" class="btn btn-lg btn-block btn-outline-primary">A&ntilde;adir compra</button>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card mb-3 box-shadow">
                        <img class="card-img-top" src="${pageContext.request.contextPath}/electro/003.jpg" alt="Placa vitrocer&aacute;mica TB 6315">
                        <div class="card-body">
                            <p class="card-text">TEKA</p>
                            <p class="card-text">Placa vitrocer&aacute;mica TB 6315 (El&eacute;ctrica - 60 cm - Negro)</p>
                                <h4 class="card-title pricing-card-title">181,82 &euro; <small class="text-muted"> <strike> 219,99</strike></small></h4>
                                 <ul class="list-unstyled mt-3 mb-4">
                                    <li style="color:#FF0000">Ahorras 238,17 &euro;</li>
                                </ul>
                            <button type="button" class="btn btn-lg btn-block btn-outline-primary">A&ntilde;adir compra</button>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card mb-3 box-shadow">
                        <img class="card-img-top" src="${pageContext.request.contextPath}/electro/004.jpg" alt="Frigor&iacute;fico combi RB37K6033SS/EF">
                        <div class="card-body">
                            <p class="card-text">SAMSUNG</p>
                            <p class="card-text">Frigor&iacute;fico combi RB37K6033SS/EF</p>
                            <h4 class="card-title pricing-card-title">699,99 &euro; <small class="text-muted"> <strike> 849,99</strike></small></h4>
                            <ul class="list-unstyled mt-3 mb-4">
                                <li style="color:#FF0000">Ahorras 150 &euro;</li>
                            </ul>
                            <button type="button" class="btn btn-lg btn-block btn-outline-primary">A&ntilde;adir compra</button>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="card mb-3 box-shadow">
                        <img class="card-img-top" src="${pageContext.request.contextPath}/electro/001.jpg" alt="Lavadora F4J6JY0W">
                        <div class="card-body">
                            <p class="card-text">LG</p>
                            <p class="card-text">Lavadora F4J6JY0W (10 kg - 1400 rpm - Blanco)</p>
                            <h4 class="card-title pricing-card-title">520,69 &euro; <small class="text-muted"> <strike> 629,99</strike></small></h4>
                            <ul class="list-unstyled mt-3 mb-4">
                                <li style="color:#FF0000">Ahorras 109,30 &euro;</li>
                            </ul>
                            <button type="button" class="btn btn-lg btn-block btn-outline-primary">A&ntilde;adir compra</button>
                        </div>
                    </div>
                </div>
            </div>

            <p><br></p>

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
                    <strong class="d-inline-block mb-2 text-primary">Servicios electroHOME</strong>
                    <h3 class="mb-0">
                        <span class="text-dark" >SOLUCIONES</span>
                    </h3>
                    <div class="mb-1 text-muted">Postventa</div><p></p>
                    <p class="card-text mb-auto">Servicio de Entregas a Domicilio, que de forma r&aacute;pida y profesional. Disponible para todos aquellos productos que no disfrutan de entrega a domicilio gratuita.</p>
                    <a href="${pageContext.request.contextPath}/servicios">Continuar leyendo</a>
                </div>
                <img class="card-img-right flex-auto d-none d-md-block" src="${pageContext.request.contextPath}/img/servicios02.jpg" alt="Card image cap">
            </div>
        </div>
    </div>

            <p><br></p>

     <div class="row">
            <div class="col-md-3">
                <div class="card mb-3 box-shadow">
                    <img class="card-img-top" src="${pageContext.request.contextPath}/electro/005.jpg" alt="Horno SurroundCook BPS331120M">
                    <div class="card-body">
                        <p class="card-text">AEG</p>
                        <p class="card-text">Horno SurroundCook BPS331120M (71 L - 59.5 cm - Pirol&iacute;tico - Inox)</p>
                        <h4 class="card-title pricing-card-title">179,99 &euro; <small class="text-muted"> <strike> 199,99</strike></small></h4>
                        <ul class="list-unstyled mt-3 mb-4">
                            <li style="color:#FF0000">Ahorras 20 &euro;</li>
                        </ul>
                        <button type="button" class="btn btn-lg btn-block btn-outline-primary">A&ntilde;adir compra</button>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card mb-3 box-shadow">
                    <img class="card-img-top" src="${pageContext.request.contextPath}/electro/006.jpg" alt="Lavasecadora WVH28 1EP (4/7 kg - 1400 rpm - Blanco)">
                    <div class="card-body">
                        <p class="card-text">BOSCH</p>
                        <p class="card-text">Lavasecadora WVH28 1EP (4/7 kg - 1400 rpm - Blanco)</p>
                        <h4 class="card-title pricing-card-title">749,99 &euro; <small class="text-muted"> <strike> 999,99</strike></small></h4>
                        <ul class="list-unstyled mt-3 mb-4">
                            <li style="color:#FF0000">Ahorras 250 &euro;</li>
                        </ul>
                        <button type="button" class="btn btn-lg btn-block btn-outline-primary">A&ntilde;adir compra</button>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card mb-3 box-shadow">
                    <img class="card-img-top" src="${pageContext.request.contextPath}/electro/007.jpg" alt="Lavavajillas 3VS502BP (12 cubiertos - 60 cm - Blanco)">
                    <div class="card-body">
                        <p class="card-text">BALAY</p>
                        <p class="card-text">Lavavajillas 3VS502BP (12 cubiertos - 60 cm - Blanco)</p>
                        <h4 class="card-title pricing-card-title">299,99 &euro; <small class="text-muted"> <strike> 349,99</strike></small></h4>
                        <ul class="list-unstyled mt-3 mb-4">
                            <li style="color:#FF0000" >Ahorras 50 &euro;</li>
                        </ul>
                        <button type="button" class="btn btn-lg btn-block btn-outline-primary">A&ntilde;adir compra</button>
                    </div>
                </div>
            </div>

            <div class="col-md-3">
                <div class="card mb-3 box-shadow">
                    <img class="card-img-top" src="${pageContext.request.contextPath}/electro/008.jpg" alt="Frigorífico combi LI8 FF2I WH">
                    <div class="card-body">
                        <p class="card-text">INDISET</p>
                        <p class="card-text">Frigor&iacute;fico combi LI8 FF2I WH</p>
                        <h4 class="card-title pricing-card-title">399,99 &euro; <small class="text-muted"> <strike> 469,99</strike></small></h4>
                        <ul class="list-unstyled mt-3 mb-4">
                            <li style="color:#FF0000">Ahorras 70 &euro;</li>
                        </ul>
                        <button type="button" class="btn btn-lg btn-block btn-outline-primary">A&ntilde;adir compra</button>
                    </div>
                </div>
            </div>
        </div>


    </div>
</div>


<p>&nbsp;</p>


</div>

<%@ include file = "_js.jsp"%>
<%@ include file = "_footer.jsp"%>
