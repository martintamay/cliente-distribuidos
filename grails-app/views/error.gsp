<!doctype html>
<html>
    <head>
        <title><g:if env="development">Grails Runtime Exception</g:if><g:else>Algo parece haber ido mal</g:else></title>

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
            code {
                margin: 0px 4px;
                padding: 2px 9px;
            }
            code::before {
                content: "\A";
                white-space: pre;
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
            .errors-container {
                margin: 10vh 10vw;
                border: 1px solid;
                padding: 40px;
                border-radius: 18px;
            }
            small {
                margin-top: 20px;
            }
        </style>
    </head>
    <body>
        <div class="body">
            <div class="center">
                <h1>Algo parece haber ido mal</h1>
                <p>Parece que ha ocurrido un error inesperado, no te preocupes, seguro ya estamos trabajando en ello</p>
            </div>
            <asset:image src="explosion.png" alt="Error 500 image" class="center"/>
        </div>
        <div class="errors-container">
            <h1>Eres "nosotros" eh? Aca tenés error para que lo arregles</h1>
            <g:if env="development">
                <g:if test="${Throwable.isInstance(exception)}">
                    <g:renderException exception="${exception}" />
                </g:if>
                <g:elseif test="${request.getAttribute('javax.servlet.error.exception')}">
                    <g:renderException exception="${request.getAttribute('javax.servlet.error.exception')}" />
                </g:elseif>
                <g:else>
                    <ul class="errors">
                        <li>An error has occurred</li>
                        <li>Exception: ${exception}</li>
                        <li>Message: ${message}</li>
                        <li>Path: ${path}</li>
                    </ul>
                </g:else>
            </g:if>
            <small>suerte con eso o.o</small>
        </div>
    </body>
</html>
