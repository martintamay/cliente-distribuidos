<%@ page import="delivery.promotion.Promotion" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'promotion.label', default: 'Promotion')}" />
    <title>Agregar Promocion</title>
</head>
<body>
<a href="#create-promotion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div id="create-promotion" class="container padding-menu" role="main">
    <g:if test="${flash.message}">
        <div class="alert alert-info" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${promotionInstance}">
        <ul class="alert alert-danger" role="alert">
            <g:eachError bean="${promotionInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <div class="card">
        <div class="card-body">
            <h3>Crear Promoción</h3>
            <hr>
            <fieldset class="form">
                <g:render template="form"/>
            </fieldset>
        </div>
    </div>
</div>
</body>
</html>

