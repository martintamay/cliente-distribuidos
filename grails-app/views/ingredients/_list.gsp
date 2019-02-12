<table class="table table-striped">
    <thead class="thead-dark">
    <tr >

        <g:sortableColumn property="description" title="Descripcion" />

        <th></th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${ingredientsInstanceList}" status="i" var="ingredientsInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td>
                ${fieldValue(bean: ingredientsInstance, field: "description")}
            </td>


            <td>
                <g:link class="btn btn-outline-secondary" action="show" id="${ingredientsInstance?.id}"><i class="fa fa-eye"></i> </g:link>
                <g:link class="btn btn-outline-secondary" action="edit" id="${ingredientsInstance?.id}"><i class="fa fa-pencil"></i> </g:link>
                <g:link class="btn btn-outline-danger" action="delete" id="${ingredientsInstance?.id}"><i class="fa fa-trash-o"></i> </g:link>
            </td>
        </tr>

    </g:each>
    </tbody>
</table>