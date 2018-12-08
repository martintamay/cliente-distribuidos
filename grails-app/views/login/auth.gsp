<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    %{-- <title><g:message code="Inicio de Sesion"/></title> --}%
    <asset:stylesheet src="auth.css"/>
</head>
<body>
<div class="container login-page">
    <div class="card">
        <div class="card-title p-3 mb-2 bg-primary text-white">
            <h2> Iniciar Sesión</h2>
        </div>
        <div class="card-body">
            <form class="form-signin form-horizontal" action='${postUrl}' method='POST' id='loginForm' autocomplete='off' name="f">

                <g:if test='${flash.message}'>
                    <div class='login_message'>${flash.message}</div>
                </g:if>

                <div class="form-group">
                    <label for='username' class="col-sm-3 control-label">Usuario</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='username' id='username'/>
                    </div>
                </div>

                <div class="form-group">
                    <label for='password' class="col-sm-3 control-label">Contraseña</label>
                    <div class="col-sm-8">
                        <input type='password' class='form-control' name='password' id='password'/>
                    </div>
                </div>

                <p id="remember_me_holder">
                    <input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if> hidden="true"/>
                    <!--label for='remember_me'>Recuérdame</label-->
                </p>

                <p>
                    <input type='submit' id="submit" class ="btn btn-primary float-right" value='Entrar'/>
                </p>
            </form>
        </div>
    </div>

</div>

</body>
</html>

