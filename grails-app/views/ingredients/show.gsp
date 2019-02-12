<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'order.label', default: 'Order')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
<a href="#show-order" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="show-order" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <f:display bean="order" />
    <g:link class="btn btn-primary pull-right" action="create" id="${ingredientsInstance?.id}"><i class="fas fa-plus-square"></i></g:link>

    <table class="table">

        <tbody>
        <th>Description</th> <td>${ingredientsInstance?.description}</td>
        </tbody>

    </table>




    <g:form resource="${this.ingredients}" method="DELETE">
        <fieldset class="buttons">
            <g:link class="btn btn-outline-secondary" action="edit" id="${ingredientsInstance?.id}"><i class="fa fa-pencil"></i> </g:link>
            <g:link class="btn btn-outline-danger" action="delete" id="${ingredientsInstance?.id}"><i class="fa fa-trash-o"></i> </g:link>

        </fieldset>
    </g:form>
</div>
</body>
</html>
