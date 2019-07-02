<table class="table table-striped">
     <thead class="thead-dark">
    <tr >

        <g:sortableColumn property="title" title="Title" />
        <g:sortableColumn property="user" title="User" />
        <g:sortableColumn property="content" title="Content" />
        <g:sortableColumn property="deleted" title="Deleted" />
        <g:sortableColumn property="establishments" title="Establishments" />
        <th></th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${commentsInstanceList}" status="i" var="commentsInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td>
                ${fieldValue(bean: commentsInstance, field: "title")}
            </td>



             <td>
                            ${fieldValue(bean: commentsInstance, field: "user.firstName")}
                        </td>


            <td>
                ${fieldValue(bean: commentsInstance, field: "content")}
            </td>
            <td>
                ${fieldValue(bean: commentsInstance, field: "deleted")}
            </td>

            <td>
                 ${fieldValue(bean: commentsInstance, field: "establishments.name")}
             </td>

            <td>
                <g:link class="btn btn-outline-secondary" action="show" id="${commentsInstance?.id}"><i class="fa fa-eye"></i> </g:link>
                <g:link class="btn btn-outline-secondary" action="edit" id="${commentsInstance?.id}"><i class="fa fa-pencil"></i> </g:link>
                <g:link class="btn btn-outline-danger" action="delete" id="${commentsInstance?.id}"><i class="fa fa-trash-o"></i> </g:link>

            </td>
        </tr>

    </g:each>
    </tbody>
</table>