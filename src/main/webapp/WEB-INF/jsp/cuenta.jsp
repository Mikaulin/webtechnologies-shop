

<%@ include file = "shared/_header.jsp"%>

<div class="container">

    <div class="col-md-8 order-md-1">

        <h4 class="mb-3">Crear Cuenta</h4>

    <mvc:form modelAttribute="product" action="create">
        <%--<form class="needs-validation" novalidate>--%>


            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="nombre">Nombre</label>
                    <input type="text" class="form-control" id="nombre" placeholder="" value="" required>
                    <div class="invalid-feedback">
                        Por favor, introduce tu nombre.
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="apellido">Apellido</label>
                    <input type="text" class="form-control" id="apellido" placeholder="" value="" required>
                    <div class="invalid-feedback">
                        Por favor, introduce tu apellido.
                    </div>
                </div>
            </div>

            <div class="mb-3">
                <label for="username">Usuario</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">@</span>
                    </div>
                    <input type="text" class="form-control" id="username" placeholder="" value="" required>
                    <div class="invalid-feedback" style="width: 100%;">
                        Por favor, introduce un nombre de usuario.
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="pass">Contrase&ntilde;a</label>
                    <input type="password" class="form-control" id="pass" placeholder="" value="" required>
                    <div class="invalid-feedback">
                        Por favor, introduce una contrase&ntilde;a.
                    </div>
                </div>

                <div class="col-md-6 mb-3">
                    <label for="pass2">Repetir contrase&ntilde;a</label>
                    <input type="password" class="form-control" id="pass2" placeholder="" value="" required>
                    <div class="invalid-feedback">
                        Por favor, repite la contrase&ntilde;a.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="email">Email <span class="text-muted">(Opcional)</span>
                    </label>
                    <input type="email" class="form-control" id="email" placeholder="">
                    <div class="invalid-feedback">
                        Por favor, introduce una direcci&oacute;n de correo v$aacute;lida.
                    </div>
                </div>

                <div class="col-md-6 mb-3">
                    <label for="username">Tel&eacute;fono</label>
                    <input type="text" class="form-control" id="telefono" placeholder="" value="" required>
                    <div class="invalid-feedback">
                        Por favor, introduce un tel&eacute;fono de contacto.
                    </div>
                </div>
            </div>

            <div class="mb-3">
                <label for="direccion">Direcci&oacute;n</label>
                <input type="text" class="form-control" id="direccion" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Por favor, introduce una direcci&oacute;n v$aacute;lida.
                </div>
            </div>

            <div class="row">
                <div class="col-md-5 mb-3">
                    <label for="provincia">Provincia</label>
                    <input type="text" class="form-control" id="provincia" placeholder="" value="" required>
                    <div class="invalid-feedback">
                        Por favor, introduce una provincia v$aacute;lida.
                    </div>
                </div>
                <div class="col-md-4 mb-3">
                    <label for="pais">Pa&iacute;s</label>
                    <input type="text" class="form-control" id="pais" placeholder="" value="" required>
                    <div class="invalid-feedback">
                        Por favor, introduce una pa&iacute;s v$aacute;lida.
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <label for="cp">C.P.</label>
                    <input type="text" class="form-control" id="cp" placeholder="" required>
                    <div class="invalid-feedback">
                        Por favor, introduce un c&oacute;digo postal v$aacute;lida
                    </div>
                </div>
            </div>

            <p></p>

            <button class="btn btn-primary btn-lg " type="submit">Crear Cuenta</button>
    </mvc:form>

    <%--</form>--%>

  </div>

</div>



<%@ include file = "shared/_js.jsp"%>
<%@ include file = "shared/_footer.jsp"%>
