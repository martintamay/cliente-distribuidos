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
    </ul>
</div>
<div id="show-comments" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <f:display bean="comments" />
    <g:link class="btn btn-primary pull-right" action="create" id="${commentsInstance?.id}"><i class="fas fa-plus-square"></i></g:link>

    <table class="table">

        <tbody>
    <th>Titulo</th> <td>${commentsInstance?.title}</td>
   <tr> <th>Contenido</th><td>${commentsInstance?.content}</td></tr>
    <tr> <th>Borrado</th><td>${commentsInstance?.deleted}</td></tr>
    <tr> <th>Nombre</th> <td>${commentsInstance?._user.firstName}</td></tr>
    <tr> <th>Restaurante</th><td>${commentsInstance?._establishments.name}</td></tr>
    </tbody>

    </table>




    <g:form resource="${this.comments}" method="DELETE">
        <fieldset class="buttons">
            <g:link class="btn btn-outline-secondary" action="edit" id="${commentsInstance?.id}"><i class="fa fa-pencil"></i> </g:link>
            <g:link class="btn btn-outline-danger" action="delete" id="${commentsInstance?.id}"><i class="fa fa-trash-o"></i> </g:link>

        </fieldset>
    </g:form>
</div>
</body>
</html>
