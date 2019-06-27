<table class="table table-striped">
    <thead class="thead-dark">
    <tr >

        <g:sortableColumn property="orderNumber" title="Numero de Orden" />
        <g:sortableColumn property="address" title="Direccion" />
        <g:sortableColumn property="state" title="Estado" />
        <g:sortableColumn property="contactNumber" title="Numero De Contacto" />
        <g:sortableColumn property="totalCost" title="Costo Total" />
        <g:sortableColumn property="user" title="User" />
        <g:sortableColumn property="establishments" title="Establishments" />

        <th></th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${orderInstanceList}" status="i" var="orderInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td>
                ${fieldValue(bean: orderInstance, field: "orderNumber")}
            </td>
            <td>
                ${fieldValue(bean: orderInstance, field: "address")}
            </td>
            <td>
                ${fieldValue(bean: orderInstance, field: "state")}
            </td>
            <td>
                ${fieldValue(bean: orderInstance, field: "contactNumber")}
            </td>

             <td>
                            ${fieldValue(bean: orderInstance, field: "totalCost")}
                        </td>


             <td>
                     ${fieldValue(bean: orderInstance, field: "user.firstName")}
             </td>

             <td>
                     ${fieldValue(bean: orderInstance, field: "establishments.name")}
             </td>
            <td>
                <g:link class="btn btn-outline-secondary" action="show" id="${orderInstance?.id}"><i class="fa fa-eye"></i> </g:link>
                <g:link class="btn btn-outline-secondary" action="edit" id="${orderInstance?.id}"><i class="fa fa-pencil"></i> </g:link>
                <g:link class="btn btn-outline-danger" action="delete" id="${orderInstance?.id}"><i class="fa fa-trash-o"></i> </g:link>
            </td>
        </tr>

    </g:each>
    </tbody>
</table>