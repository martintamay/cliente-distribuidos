<!doctype html>
<html lang="es" dir="ltr">
<head>
	<meta charset="utf-8">
	<title>No tienes permitido acceder aquí</title>
	<link href="https://fonts.googleapis.com/css?family=Roboto+Mono|Staatliches" rel="stylesheet">
	<style media="screen" type="text/css">
	html {
		margin: 0;
		padding: 7vh 0;
		font-family: 'Roboto Mono', monospace;
	}
	h1 {
		font-family: 'Staatliches', cursive;
		text-align: center;
	}
	img {
		max-height: 50vh;
	}
	code {
		background: lightgray;
		margin: 0px 4px;
		padding: 2px 9px;
		border-radius: 4px;
	}
	p {
		text-align: center;
	}
	.body {
		width: 100%;
		height: 100%;
	}
	.center {
		display: block;
		margin-left: auto;
		margin-right: auto;
	}

	</style>
</head>
<body>
<div class="body">
	<div class="center">
		<h1>No tienes acceso a este recurso</h1>
		<p>¿Qué haces en <code id="enlace">${request.forwardURI}</code>?<br>¿Quién te dió permiso de venir aca?</p>
	</div>
	<div class="hidden" hidden>Hola de Martín</div>
	<asset:image src="nopass.jpg" class="center" alt="Image for 404"/>
</div>
</body>
</html>
