

<%@ include file = "shared/_header.jsp"%>

<div class="container">

    <div class="col-md-8 order-md-1">

        <h4 class="mb-3">Inicia Sesi&oacute;n</h4>

        <form action="${pageContext.request.contextPath}/action_page.php" class="needs-validation" novalidate>

            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="email">Email:</label>
                    <input type="email" class="form-control" id="email" value="" required>
                </div>

                <div class="col-md-6 mb-3">
                    <label for="pwd">Contrase&ntilde;a:</label>
                    <input type="password" class="form-control" id="pwd" value="" required>
                </div>
            </div>

            <div class="checkbox mb-3">
                <label>
                    <a href="">Has olvidado tu contrase&ntilde;a ?</a>
                </label>
            </div>

            <button type="submit" class="btn btn-primary btn-lg">Iniciar Sesi&oacute;n</button>

        </form>
    </div>

    <p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>

    <div class="container">
        <div class="jumbotron mt-3">
            <h4>Si no tienes una cuenta puedes crearla ahora</h4>
            <p class="lead">Y empezar&aacute;s a disfrutar de todas las ventajas que te ofrece ElectroHOME</p>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/cuenta" role="button">Crear Cuenta</a>
        </div>
    </div>

</div>

<%@ include file = "shared/_js.jsp"%>
<%@ include file = "shared/_footer.jsp"%>
