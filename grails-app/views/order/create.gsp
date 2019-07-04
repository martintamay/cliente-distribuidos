<%@ page import="delivery.order.Order" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'order.label', default: 'Order')}" />
    <title>Agregar Orden</title>
</head>
<body>
<a href="#create-order" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div id="create-order" class="container padding-menu" role="main">
    <g:if test="${flash.message}">
        <div class="alert alert-info" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${orderInstance}">
        <ul class="alert alert-danger" role="alert">
            <g:eachError bean="${orderInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <div class="container pb-5">
        <div class="card">
            <div class="card-body">
                <g:link class="btn btn-primary pull-right" action="list"><i class="fas fa fa-book"></i>Lista</g:link>
                <h3>Crear Orden</h3>
                <hr>
                <fieldset class="form">
                    <g:render template="form"/>
                </fieldset>
                <hr>
            </div>
        </div>
    </div>
</div>
</body>
</html>

