<table class="table table-striped">
    <thead>
    <tr >

        <g:sortableColumn property="name" title="Name" />
        <g:sortableColumn property="description" title="Description" />
        <g:sortableColumn property="cost" title="Cost" />
        <g:sortableColumn property="establishments" title="Establishments" />
        <th></th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${productsInstanceList}" status="i" var="productsInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td>
                ${fieldValue(bean: productsInstance, field: "name")}
            </td>



             <td>
                ${fieldValue(bean: productsInstance, field: "description")}
             </td>


            <td>
                ${fieldValue(bean: productsInstance, field: "cost")}
            </td>


            <td>
                 ${fieldValue(bean: productsInstance, field: "establishments.name")}
             </td>

            <td>
                <g:link class="btn btn-outline-secondary" action="edit" id="${productsInstance?.id}"><i class="fa fa-pencil"></i> </g:link>
                <g:link class="btn btn-outline-danger" action="delete" id="${productsInstance?.id}"><i class="fa fa-trash-o"></i> </g:link>
            </td>
        </tr>

    </g:each>
    </tbody>
</table>