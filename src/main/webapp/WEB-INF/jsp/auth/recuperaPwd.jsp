<%@ include file="../shared/_header.jsp" %>

<div class="container">

    <div class="jumbotron mt-3">

        <h4>Has olvidado la contrase&ntilde;a?</h4>

        <p class="lead"> Por favor introduce tu email. En breve recibir&aacute;s un correo con un enlace para cambiar tu
            contrase&ntilde;a.</p>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" value="" required>
            </div>
        </div>

        <button type="submit" class="btn btn-danger btn-lg">Enviar</button>

    </div>

</div>

<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>
