<%@ page import="delivery.ingredients.Ingredients" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'ingredients.label', default: 'Ingredients')}" />
    <title>Agregar Ingrediente</title>
</head>
<body>
<a href="#create-ingredients" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div id="create-ingredients" class="container padding-menu" role="main">
    <g:if test="${flash.message}">
        <div class="alert alert-info" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${ingredientsInstance}">
        <ul class="alert alert-danger" role="alert">
            <g:eachError bean="${ingredientsInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <div class="card">
        <div class="card-body">
            <g:link class="btn btn-primary pull-right" action="list"><i class="fas fa fa-book"></i>Lista</g:link>
            <h3>Crear Ingredientes</h3>
            <hr>
            <g:form action="save" >
                <fieldset class="form">
                    <g:render template="form"/>
                </fieldset>
                <hr>
                <fieldset class="btn-group">
                    <g:submitButton name="create" class="btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" >Crear</g:submitButton>
                    <g:link class="btn btn-secondary" action="list">Lista de Ingredientes</g:link>
                </fieldset>
            </g:form>
        </div>
    </div>
</div>
</body>
</html>

