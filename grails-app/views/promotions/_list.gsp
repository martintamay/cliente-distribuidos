<table class="table table-striped">
    <thead class="thead-dark">
    <tr >

        <g:sortableColumn property="name" title="Nombres" />
        <g:sortableColumn property="available" title="Apellidos" />
        <g:sortableColumn property="end_date" title="Correo" />
        <th></th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${promotionsInstanceList}" status="i" var="promotionsInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td>
                ${fieldValue(bean: promotionsInstance, field: "name")}
            </td>
            <td>
                ${fieldValue(bean: userInstance, field: "available")}
            </td>
            <td>
                ${fieldValue(bean: userInstance, field: "end_date")}
            </td>

            <td>
                <g:link class="btn btn-outline-secondary" action="show" id="${promotionsInstance?.id}"><i class="fa fa-eye"></i> </g:link>
                <g:link class="btn btn-outline-secondary" action="edit" id="${promotionsInstance?.id}"><i class="fa fa-pencil"></i> </g:link>
                <g:link class="btn btn-outline-danger" action="delete" id="${promotionsInstance?.id}"><i class="fa fa-trash-o"></i> </g:link>
            </td>
        </tr>

    </g:each>
    </tbody>
</table>