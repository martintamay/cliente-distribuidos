<%@ page import="delivery.ingredients.Ingredients" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'order.label', default: 'Order')}" />
    <title>Editar Orden</title>
</head>
<body>
<a href="#edit-ingredients" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div id="edit-order" class="content scaffold-edit" role="main">
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
            <h3><g:message code="default.edit.label" args="[entityName]" /></h3>
            <hr>
            <g:form method="post" >
                <g:hiddenField name="id" value="${ingredientsInstance?.id}" />
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
