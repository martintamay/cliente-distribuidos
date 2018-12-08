<table class="table table-striped">
    <thead>
    <tr >

        <g:sortableColumn property="firstName" title="First Name" />
        <g:sortableColumn property="lastName" title="Last Name" />
        <g:sortableColumn property="email" title="Email" />
        <g:sortableColumn property="phoneNumber" title="Phone Number" />
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
                <g:link class="btn btn-outline-secondary" action="edit" id="${userInstance?.id}"><i class="fa fa-pencil"></i> </g:link>
                <g:link class="btn btn-outline-danger" action="delete" id="${userInstance?.id}"><i class="fa fa-trash-o"></i> </g:link>
            </td>
        </tr>

    </g:each>
    </tbody>
</table>