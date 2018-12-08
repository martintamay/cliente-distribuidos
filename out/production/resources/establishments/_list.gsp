<table class="table table-striped">
    <thead>
    <tr >


        <g:sortableColumn property="name" title="Name" />
        <g:sortableColumn property="address" title="Address" />
                <g:sortableColumn property="description" title="Description" />
                <g:sortableColumn property="email" title="Email" />
         <g:sortableColumn property="phone_number" title="Phone Number" />
                 <g:sortableColumn property="schedule" title="Schedule" />


        <th></th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${establishmentsInstanceList}" status="i" var="establishmentsInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td>
                ${fieldValue(bean: establishmentsInstance, field: "name")}
            </td>


            <td>
                ${fieldValue(bean: establishmentsInstance, field: "address")}
            </td>


            <td>
                ${fieldValue(bean: establishmentsInstance, field: "description")}
            </td>

            <td>
                ${fieldValue(bean: establishmentsInstance, field: "email")}
            </td>

            <td>
                 ${fieldValue(bean: establishmentsInstance, field: "phone_number")}
            </td>
                        <td>
                            ${fieldValue(bean: establishmentsInstance, field: "schedule")}
                        </td>
            <td>
                <g:link class="btn btn-outline-secondary" action="edit" id="${establishmentsInstance?.id}"><i class="fa fa-pencil"></i> </g:link>
                <g:link class="btn btn-outline-danger" action="delete" id="${establishmentsInstance?.id}"><i class="fa fa-trash-o"></i> </g:link>
            </td>
        </tr>

    </g:each>
    </tbody>
</table>