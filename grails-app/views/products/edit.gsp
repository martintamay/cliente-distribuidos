<%@ page import="delivery.products.Products" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'products.label', default: 'Products')}" />
    <title>Editar Producto</title>
</head>
<body>
<a href="#edit-products" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="edit-products" class="content scaffold-edit" role="main">
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
    <div class="card">
        <div class="card-body">
            <h3><g:message code="default.edit.label" args="[entityName]" /></h3>
            <hr>
            <g:form method="post" >
                <g:hiddenField name="id" value="${productsInstance?.id}" />
                <fieldset class="form">
                    <g:render template="form"/>
                </fieldset>
                <fieldset class="btn-group">
                    <g:actionSubmit class="btn btn-primary" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </div>
</div>
</body>
</html>
