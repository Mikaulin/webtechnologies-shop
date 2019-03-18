
<c:url value="/" var="indexUrl" />


<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ElectroHOME | Tienda de electrodom&eacute;sticos online </title>
    <link href="${pageContext.request.contextPath}/css/sticky-footer.css" rel="stylesheet">
    <link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />

    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="icon" href=" https://assets.jumpseller.com/store/bootstrap/themes/125212/favicon.png?1545325373 ">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>${title}</title>


</head>

<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="${indexUrl}/"><img src="${pageContext.request.contextPath}/img/logo.png" alt="logo ElectroHOME"></a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarContainer">
                <ul class="nav navbar-nav float-right nav-top">

                    <li >
                        <a href="cart" class="trsn nav-link" title="Comprobar compras">
                            <i class="fa fa-shopping-cart"></i>
                            <span id="nav-bar-cart"> 0 Producto(s) | 0 &euro;</span>
                        </a>
                    </li>

                    <li >
                        <a href="${pageContext.request.contextPath}/sesion" id="login-link" class="trsn nav-link" title="Iniciar sesi&oacute;">
                            <i class="fa fa-user fa-fw"></i>
                            <span class="customer-name">Login </span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>



<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">


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
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/list">Clientes</a>
                    </div>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ofertas">Ofertas</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link " href="${pageContext.request.contextPath}/servicios">Servicios</a>
                </li>
            </ul>

            <form class="form-inline my-2 my-md-0">
                <input class="form-control" type="text" placeholder=" Qu&eacute; est&aacute;s buscando ?" aria-label="Search">
            </form>
        </div>
    </div>
</nav>



<p>&nbsp;</p>


</body>
