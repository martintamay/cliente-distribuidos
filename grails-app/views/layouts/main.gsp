<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<!doctype html>
<html lang="es" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">

    <asset:stylesheet src="application.css"/>
    <!-- Font Awesome -->
    <asset:stylesheet src="font-awesome.min.css"/>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <!-- ion icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.8.7/chosen.css" />
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500,700,900" rel="stylesheet">
    <!-- Simple line Icon -->
    <asset:stylesheet src="simple-line-icons.css"/>
    <!-- Themify Icon -->
    <asset:stylesheet src="themify-icons.css"/>
    <!-- Hover Effects -->
    <asset:stylesheet src="set1.css"/>
    <!-- Main CSS -->
    <asset:stylesheet src="style.css"/>

    <!-- js content -->

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.8.7/chosen.jquery.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>

    <g:layoutHead/>
</head>
<body>

    <div class="nav-menu mb-5">
        <div class="bg transition">
            <div class="container-fluid fixed">
                <div class="row">
                    <div class="col-md-12">
                        <nav class="navbar navbar-expand-lg navbar-dark">
                            <a class="navbar-brand" href="/">Delivery</a>
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="icon-menu"></span>
                            </button>
                            <div class="collapse navbar-collapse justify-content-end" id="navbarNavDropdown">
                                <ul class="navbar-nav">
                                    <li class="nav-item dropdown">
                                        <a class="nav-link" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            Items
                                            <span class="icon-arrow-down"></span>
                                        </a>
                                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                            <g:link class="dropdown-item" controller="user" action="list">Usuarios</g:link>
                                            <g:link class="dropdown-item" controller="order" action="list">Ordenes</g:link>
                                            <g:link class="dropdown-item" controller="comments" action="list">Comentarios</g:link>
                                            <g:link class="dropdown-item" controller="establishments" action="list">Restaurantes</g:link>
                                            <g:link class="dropdown-item" controller="bills" action="list">Factura</g:link>
                                            <g:link class="dropdown-item" controller="promotion" action="list">Promociones</g:link>
                                            <g:link class="dropdown-item" controller="products" action="list">Productos</g:link>
                                        </div>
                                    </li>
                                    <g:if test="${org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().name.trim().equals("__grails.anonymous.user__")}">
                                        <li class="nav-item">
                                            <a href="/login" class="nav-link">Iniciar Sesión</a>
                                        </li>
                                    </g:if>
                                    <g:else>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link" href="#" id="userDropDown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <sec:username />
                                                <span class="icon-arrow-down"></span>
                                            </a>
                                            <div class="dropdown-menu" aria-labelledby="userDropDown">
                                                <form name="logout" action="/logout" method="post">
                                                    <button class="dropdown-item" type="submit">Cerrar Sesión</button>
                                                </form>
                                            </div>
                                        </li>
                                    </g:else>
                                    <!--li class="nav-item">
                                        <a class="nav-link" href="#">Contact</a>
                                    </li-->
                                    <!--li><a href="#" class="btn btn-outline-light top-btn"><span class="ti-plus"></span> Add Listing</a></li-->
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <g:layoutBody/>


    <script>
        $(window).scroll(function() {
            // 100 = The point you would like to fade the nav in.
            if ($('.fixed') != null && $('.fixed').length > 0){
                if ($(window).scrollTop() > 100) {

                    $('.fixed').addClass('is-sticky');

                } else {

                    $('.fixed').removeClass('is-sticky');

                }
            }
        });
    </script>

</body>
</html>
