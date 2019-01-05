<table class="table table-striped">
    <thead>
    <tr >

        <g:sortableColumn property="amount" title="Amount" />
        <g:sortableColumn property="iva10" title="Iva10" />
        <g:sortableColumn property="bills" title="Bills" />

        <th></th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${billsDetailsInstanceList}" status="i" var="billsDetailsInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td>
                ${fieldValue(bean: billsDetailsInstance, field: "amount")}
            </td>



             <td>
                            ${fieldValue(bean: billsDetailsInstance, field: "iva10")}
                        </td>


            <td>
                ${fieldValue(bean: billsDetailsInstance, field: "bills.total")}
            </td>

            <td>
                <g:link class="btn btn-outline-secondary" action="edit" id="${billsDetailsInstance?.id}"><i class="fa fa-pencil"></i> </g:link>
                <g:link class="btn btn-outline-danger" action="delete" id="${billsDetailsInstance?.id}"><i class="fa fa-trash-o"></i> </g:link>
            </td>
        </tr>

    </g:each>
    </tbody>
</table>