<%@ page import="delivery.products.Products" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'products.label', default: 'Products')}" />
    <title>Agregar Productos</title>
</head>
<body>
<a href="#create-products" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div id="create-products" class="container padding-menu" role="main">
    <g:if test="${flash.message}">
        <div class="alert alert-info" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${productsInstance}">
        <ul class="alert alert-danger" role="alert">
            <g:eachError bean="${productsInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <div class="card container">
        <div class="card-body ">
            <g:link class="btn btn-primary pull-right" action="list"><i class="fas fa fa-book"></i>Lista</g:link>
            <h3>Crear Producto</h3>
            <fieldset class="form">
                <g:render template="form"/>
            </fieldset>
        </div>
    </div>
</div>
</body>
</html>
