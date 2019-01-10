<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'comments.label', default: 'Comments')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
<a href="#show-comments" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
        <div class="btn-group">
            <g:link class="btn btn-primary" action="create">Nuevo Comentario</g:link>
        </div>    </ul>
</div>
<div id="show-comments" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <f:display bean="comments" />
    <div class="form-group">
        <label>
            Titulo:
        </label>
        <p>${commentsInstance?.title} </p>
    </div>

    <div class="form-group">
        <label>
            Contenido:
        </label>
        <p>${commentsInstance?.content} </p>
    </div>
    <div class="form-group">
        <label>
            Borrado:
        </label>
        <p>${commentsInstance?.deleted} </p>
    </div>
    <div class="form-group">
        <label>
            Usuario:
        </label>
        <p>${commentsInstance?._user.firstName} </p>
    </div>
    <div class="form-group">
        <label>
            Restaurante:
        </label>
        <p>${commentsInstance?._establishments.name} </p>
    </div>
    <g:form resource="${this.comments}" method="DELETE">
        <fieldset class="buttons">
            <g:link class="btn btn-outline-secondary" action="edit" id="${commentsInstance?.id}"><i class="fa fa-pencil"></i> </g:link>
            <g:link class="btn btn-outline-danger" action="delete" id="${commentsInstance?.id}"><i class="fa fa-trash-o"></i> </g:link>                </fieldset>
    </g:form>
</div>
</body>
</html>
