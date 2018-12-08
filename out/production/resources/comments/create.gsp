<%@ page import="delivery.comments.Comments" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'comments.label', default: 'Comments')}" />
    <title>Agregar Comentario</title>
</head>
<body>
<a href="#create-comments" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div id="create-comments" class="container padding-menu" role="main">
    <g:if test="${flash.message}">
        <div class="alert alert-info" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${commentsInstance}">
        <ul class="alert alert-danger" role="alert">
            <g:eachError bean="${commentsInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <div class="card">
        <div class="card-body">
            <h3>Crear Comentario</h3>
            <hr>
            <g:form action="save" >
                <fieldset class="form">
                    <g:render template="form"/>
                </fieldset>
                <hr>
                <fieldset class="btn-group">
                    <g:submitButton name="create" class="btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" >Crear</g:submitButton>
                    <g:link class="btn btn-secondary" action="list">Lista de Comentarios</g:link>
                </fieldset>
            </g:form>
        </div>
    </div>
</div>
</body>
</html>

