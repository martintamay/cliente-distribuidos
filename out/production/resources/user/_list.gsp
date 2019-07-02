<table class="table table-striped">
    <thead class="thead-dark">
    <tr >

        <g:sortableColumn property="firstName" title="Nombres" />
        <g:sortableColumn property="lastName" title="Apellidos" />
        <g:sortableColumn property="email" title="Correo" />
        <g:sortableColumn property="phoneNumber" title="Número de Teléfono" />
        <th></th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${userInstanceList}" status="i" var="userInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td>
                ${fieldValue(bean: userInstance, field: "firstName")}
            </td>
            <td>
                ${fieldValue(bean: userInstance, field: "lastName")}
            </td>
            <td>
                ${fieldValue(bean: userInstance, field: "email")}
            </td>
            <td>
                ${fieldValue(bean: userInstance, field: "phoneNumber")}
            </td>
            <td>
                <g:link class="btn btn-outline-secondary" action="show" id="${userInstance?.id}"><i class="fa fa-eye"></i> </g:link>
                <g:link class="btn btn-outline-secondary" action="edit" id="${userInstance?.id}"><i class="fa fa-pencil"></i> </g:link>
                <g:link class="btn btn-outline-danger" action="delete" id="${userInstance?.id}"><i class="fa fa-trash-o"></i> </g:link>
            </td>
        </tr>

    </g:each>
    </tbody>
</table>