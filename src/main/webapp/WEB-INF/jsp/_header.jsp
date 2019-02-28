<c:url value="/" var="indexUrl" />


<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Formulario </title>
    <link href="${pageContext.request.contextPath}/css/sticky-footer.css" rel="stylesheet">
    <link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />

    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>${title}</title>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="${indexUrl}/"><img src="${pageContext.request.contextPath}/img/logo.png" alt="logo ElectroHOME"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarsExample07">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown07" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">B&uacute;squeda</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown07">
                        <a class="dropdown-item" href="#">Categor&iacute;a</a>
                        <a class="dropdown-item" href="#">Marcas</a>
                        <a class="dropdown-item" href="#">Valoraci&oacute;n</a>
                    </div>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="ofertas">Ofertas</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link " href="servicios">Servicios</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link " href="sesion">Iniciar Sesi&oacute;n</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link " href="cuenta">Crear Cuenta</a>
                </li>

            </ul>
            <form class="form-inline my-2 my-md-0">
                <input class="form-control" type="text" placeholder=" Qu&eacute; est&aacute;s buscando ?" aria-label="Search">
            </form>
        </div>
    </div>
</nav>

<p>&nbsp;</p>

