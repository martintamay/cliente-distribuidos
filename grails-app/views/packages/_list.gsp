<table class="table table-striped">
    <thead class="thead-dark">
    <tr >

        <g:sortableColumn property="Name" title="Name" />
        <g:sortableColumn property="Cost" title="Cost" />

        <th></th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${packagesInstanceList}" status="i" var="packagesInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td>
                ${fieldValue(bean: packagesInstance, field: "name")}
            </td>
            <td>
                ${fieldValue(bean: packagesInstance, field: "cost")}
            </td>

            <td>
                <g:link class="btn btn-outline-secondary" action="show" id="${packagesInstance?.id}"><i class="fa fa-eye"></i> </g:link>
                <g:link class="btn btn-outline-secondary" action="edit" id="${packagesInstance?.id}"><i class="fa fa-pencil"></i> </g:link>
                <g:link class="btn btn-outline-danger" action="delete" id="${packagesInstance?.id}"><i class="fa fa-trash-o"></i> </g:link>
            </td>
        </tr>

    </g:each>
    </tbody>
</table>