<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group" role="group" aria-label="First group">
            <div class="input-group-prepend">
                <h4 class="mb-3">Mi cuenta</h4>
            </div>
        </div>

        <div class="input-group">
            <a href="${pageContext.request.contextPath}/user/baja/${pageContext.request.userPrincipal.name}"
               title="Darme de baja">
                <button type="button" class="btn btn-danger btn-sm">Darme de baja</button>
            </a>
        </div>
    </div>

    <div class="border-top my-3"></div>

    <div class="row">

        <div class="col-md-8 order-md-1">

            <div class="card mb-4 shadow-sm">
                <div class="card-header">
                    <h4 class="my-0 font-weight-normal">Datos personales</h4>
                </div>

                <div class="card-body">

                    <div class="mb-3">
                        <h5>
                            <small>Nombre:</small>
                            ${detailUser.name} ${detailUser.lastname1}
                        </h5>
                    </div>
                    <div class="mb-3">
                        <h5>
                            <small>Direcci&oacute;n:</small>
                            ${detailUser.direction}, ${detailUser.postalCode} ${detailUser.city}, ${detailUser.province}
                            ( ${detailUser.country} )
                        </h5>
                    </div>

                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <h5>
                                <small>Tel&eacute;fono:</small>
                                ${detailUser.phone}
                            </h5>
                        </div>

                        <div class="col-md-6 mb-3">
                            <h5>
                                <small>Email:</small>
                                ${detailUser.email}
                            </h5>
                        </div>
                    </div>

                    <div class="mb-3">
                        <h5>
                            <small>Usuario:</small>
                            ${detailUser.username}
                        </h5>
                    </div>
                </div>

            </div>

        </div>

        <div class="col-md-4 order-md-2 mb-4">

            <div class="p-4 mb-3 bg-light rounded">
                <h6 class="font-italic">Política de protección de datos<br>
                    <small>Los datos personales de los usuarios serán conservados mientras sean necesarios para la
                        consecución de las finalidades propias que tengan que ver exclusivamente con el de la tienda online.
                        En el momento en que no sean necesarios para dichas finalidades,  los datos serán bloqueados durante
                        el periodo en el que puedan ser necesarios para el ejercicio  o la defensa frente a acciones judiciales
                        o administrativas y solo podrán ser desbloqueados y tratados de nuevo por este motivo.
                    </small>
                </h6>
            </div>
        </div>

    </div>

    <div class="row">
        <div class="col-md-6 order-md-1">

            <div class="jumbotron mt-3">
                <h4>Necesita consultar su compras ?</h4>
                <p class="lead">Desde aquí podrá consultar de forma cómoda el histórico de sus compras.</p>
                <a class="btn btn-outline-danger" href="${contextPath}/#" role="button">Consultar compras</a>
            </div>
        </div>
        <div class="col-md-6 order-md-1">
            <div class="jumbotron mt-3">
                <h4>Necesita devolver un producto ?</h4>
                <p class="lead">Desde aquí podrá gestionar de forma sencilla y rápida las devoluciones de tus
                    productos.</p>
                <a class="btn btn-outline-danger" href="${contextPath}/#" role="button">Devolver producto</a>
            </div>
        </div>
    </div>


</div>

<p>&nbsp;</p>
<p>&nbsp;</p>

<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>
