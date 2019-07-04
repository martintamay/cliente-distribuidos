<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'establishments.label', default: 'Establishments')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
<a href="#show-establishments" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="card container content scaffold-edit ">
    <div id="show-establishments" class="content scaffold-show" role="main">
        <h1><g:message code="default.show.label" args="[entityName]" /></h1>
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
        <f:display bean="establishments" />
        <g:link class="btn btn-primary pull-right" action="list"><i class="fas fa fa-book"></i>Lista</g:link>
        <g:link class="btn btn-primary pull-right" action="create" id="${establishmentsInstance?.id}"><i class="fas fa-plus-square"></i></g:link>

        <table class="table">

            <tbody>
            <th>Nombre</th> <td>${establishmentsInstance?.name}</td>
            <tr> <th>Direccion</th><td>${establishmentsInstance?.address}</td></tr>
            <tr> <th>Descripcion</th><td>${establishmentsInstance?.description}</td></tr>
            <tr> <th>Email</th> <td>${establishmentsInstance?.email}</td></tr>
            <tr> <th>Numero De telefono</th><td>${establishmentsInstance?.phoneNumber}</td></tr>
            <tr> <th>Estado</th> <td>${establishmentsInstance?. schedule}</td></tr>

            </tbody>

        </table>




        <g:form resource="${this.establishments}" method="DELETE">
            <fieldset class="buttons">
                <g:link class="btn btn-outline-secondary" action="edit" id="${establishmentsInstance?.id}"><i class="fa fa-pencil"></i> </g:link>
                <g:link class="btn btn-outline-danger" action="delete" id="${establishmentsInstance?.id}"><i class="fa fa-trash-o"></i> </g:link>

            </fieldset>
        </g:form>
    </div>
</div>
</body>
</html>
