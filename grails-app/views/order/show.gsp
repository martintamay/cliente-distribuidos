<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'order.label', default: 'Order')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
<a href="#show-order" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="card container content scaffold-edit ">
    <div id="show-order" class="content scaffold-show" role="main">
        <h1><g:message code="default.show.label" args="[entityName]" /></h1>
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
        <f:display bean="order" />
        <g:link class="btn btn-primary pull-right" action="list"><i class="fas fa fa-book"></i>Lista</g:link>
        <g:link class="btn btn-primary pull-right" action="create" id="${orderInstance?.id}"><i class="fas fa-plus-square"></i></g:link>

        <table class="table">

            <tbody>
            <th>Numero De Orden</th> <td>${orderInstance?.orderNumber}</td>
            <tr> <th>Direccion</th><td>${orderInstance?.address}</td></tr>
            <tr> <th>Numero de Contacto</th><td>${orderInstance?.contactNumber}</td></tr>
            <tr> <th>Restaurante</th> <td>${orderInstance?.establishments.name}</td></tr>
            <tr> <th>Estado</th><td>${orderInstance?.state}</td></tr>
            <tr> <th>Costo Total</th><td>${orderInstance?.totalCost}</td></tr>
            <tr> <th>Usuario Total</th><td>${orderInstance?.user.firstName}</td></tr>

            </tbody>

        </table>




        <g:form resource="${this.order}" method="DELETE">
            <fieldset class="buttons">
                <g:link class="btn btn-outline-secondary" action="edit" id="${orderInstance?.id}"><i class="fa fa-pencil"></i> </g:link>
                <g:link class="btn btn-outline-danger" action="delete" id="${orderInstance?.id}"><i class="fa fa-trash-o"></i> </g:link>

            </fieldset>
        </g:form>
    </div>
</div>
</body>
</html>
