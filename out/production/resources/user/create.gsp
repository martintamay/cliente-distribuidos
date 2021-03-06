<%@ page import="delivery.user.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
    <title>Agregar Usuario</title>
</head>
<body>
<a href="#create-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div id="create-user" class="container padding-menu" role="main">
    <g:if test="${flash.message}">
        <div class="alert alert-info" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${userInstance}">
        <ul class="alert alert-danger" role="alert">
            <g:eachError bean="${userInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <h3>Crear Usuario</h3>
                <hr>
                <g:form action="save" >
                    <fieldset class="form">
                        <g:render template="form"/>
                    </fieldset>
                    <hr>
                    <fieldset class="btn-group">
                        <g:submitButton name="create" class="btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" >Crear</g:submitButton>
                        <g:link class="btn btn-secondary" action="list">Lista de Usuarios</g:link>
                    </fieldset>
                </g:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

