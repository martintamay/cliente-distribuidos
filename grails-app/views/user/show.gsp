<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
<a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="show-user" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <f:display bean="user" />
    <div class="form-group">
        <label>
            Name:
        </label>
        <p>${userInstance?.firstName} </p>
    </div>

    <div class="form-group">
        <label>
            Last Name:
        </label>
        <p>${userInstance?.lastName} </p>
    </div>
    <div class="form-group">
        <label>
            Email:
        </label>
        <p>${userInstance?.email} </p>
    </div>
    <div class="form-group">
        <label>
            Phone Number
        </label>
        <p>${userInstance?.phoneNumber} </p>
    </div>
    <div class="form-group">
        <label>
            Address
        </label>
        <p>${userInstance?.address} </p>
    </div>
    <g:form resource="${this.user}" method="DELETE">
        <fieldset class="buttons">
            <g:link class="btn btn-outline-secondary" action="edit" id="${userInstance?.id}"><i class="fa fa-pencil"></i> </g:link>
            <g:link class="btn btn-outline-danger" action="delete" id="${userInstance?.id}"><i class="fa fa-trash-o"></i> </g:link>                </fieldset>
    </g:form>
</div>
</body>
</html>
