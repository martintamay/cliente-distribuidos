<table class="table table-striped">
    <thead class="thead-dark">
    <tr >

        <g:sortableColumn property="name" title="Nombre" />
        <g:sortableColumn property="available" title="Disponible" />
        <g:sortableColumn property="end_date" title="Fecha Final" />
        <th></th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${promotionInstanceList}" status="i" var="promotionInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td>
                ${fieldValue(bean: promotionInstance, field: "name")}
            </td>
            <td>
                ${fieldValue(bean: promotionInstance, field: "available")}
            </td>
            <td>
                ${fieldValue(bean: promotionInstance, field: "end_date")}
            </td>

            <td>
                <g:link class="btn btn-outline-secondary" action="show" id="${promotionInstance?.id}"><i class="fa fa-eye"></i> </g:link>
                <g:link class="btn btn-outline-secondary" action="edit" id="${promotionInstance?.id}"><i class="fa fa-pencil"></i> </g:link>
                <g:link class="btn btn-outline-danger" action="delete" id="${promotionInstance?.id}"><i class="fa fa-trash-o"></i> </g:link>
            </td>
        </tr>

    </g:each>
    </tbody>
</table>