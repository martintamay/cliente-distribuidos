<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main"/>
	<title>Acceso Denegado"</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">

			<%-- SIDEBAR  --%>
			<div class="col-sm-3 col-md-2 sidebar">

				<%--
				<ul class="nav nav-sidebar">
					<li><a href="${createLink(uri: '/alumno')}">Secretaria</a></li>
					<li><a href="">Docente</a></li>
					<li><a href="">Estudiante</a></li>
					<li><a href="">Administrador</a></li>
				</ul>
				--%>
			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<%-- CONTENT  --%>
	      <div id="contenido">
	        <div class="jumbotron">
	          <h1>Lo sentimos</h1>
	          <p class="lead">No estas autorizado para ver esta página</p>
	          <p><g:link controller='secure' action='logout' class="btn btn-lg btn-success">Cerrar Sesion</g:link></p>
	        </div>
	      </div>
				<%-- FOOTER
				<g:render template="/layouts/footer"></g:render>  	--%>

			</div>
		</div>
	</div>
</body>
</html>

