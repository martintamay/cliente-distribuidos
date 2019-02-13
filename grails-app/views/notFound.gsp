<!doctype html>
<html lang="es" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>No Encontramos lo que busca (404)</title>
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
            max-width: 100vw;
            max-height: 80vh;
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
            width: 50%;
        }

        </style>
    </head>
    <body>
        <div class="body">
            <div class="center">
                <h1>No hemos podido encontrar lo que busca (404)</h1>
                <p>No hemos podido encontrar la página con el enlace <code id="enlace">${request.forwardURI}</code>  <br>¿Está seguro que vino al lugar correcto?</p>
            </div>

            <asset:image src="holmes.jpg" class="center" alt="Image for 404"/>
        </div>
    </body>
</html>
