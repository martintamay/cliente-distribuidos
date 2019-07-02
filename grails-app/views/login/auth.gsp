<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta name="layout" content="main" />
    %{-- <title><g:message code="Inicio de Sesion"/></title> --}%
    <asset:stylesheet src="login.min.css"/>
</head>
<body>

<div class="login-dark">
    <form class="form-signin form-horizontal" action='${postUrl}' method='POST' id='loginForm' autocomplete='off' name="f">
        <h2 class="sr-only">Iniciar Sesión</h2>

        <g:if test='${flash.message}'>
            <div class='login_message'>${flash.message}</div>
        </g:if>

        <div class="illustration"><i class="icon ion-ios-locked-outline"></i></div>

        <div class="form-group">
            <input class="form-control" type="text" id="username" name="username" placeholder="Usuario">
        </div>
        <div class="form-group">
            <input class="form-control" type="password" id="password" name="password" placeholder="Password">
        </div>
        <div id="form-group">
            <input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if> hidden="true"/>
        </div>

        <div class="form-group">
            <button class="btn btn-primary btn-block" type="submit" id="submit" value="Entrar">Iniciar Sesión</button>
        </div>
    </form>
</div>
</body>
</html>

