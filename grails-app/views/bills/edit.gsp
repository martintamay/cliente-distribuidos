<%@ page import="delivery.bills.Bills" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'bills.label', default: 'Bills')}" />
    <title>Editar Cuenta</title>
</head>
<body>
<a href="#edit-bills" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div id="edit-bills" class="content scaffold-edit" role="main">
    <g:if test="${flash.message}">
        <div class="alert alert-info" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${billsInstance}">
        <ul class="alert alert-danger" role="alert">
            <g:eachError bean="${billsInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <div class="card container">
        <div class="card-body">
            <g:link class="btn btn-primary pull-right" action="list"><i class="fas fa fa-book"></i>Lista</g:link>
            <h3><g:message code="default.edit.label" args="[entityName]" /></h3>
            <hr>
                <fieldset class="form">
                    <g:render template="form"/>
                </fieldset>
        </div>
    </div>
</div>
</body>
</html>
