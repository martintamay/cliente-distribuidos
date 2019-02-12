<table data="{tableName:'ordersDetails'}">
    <thead>
    <tr>
        <th>#</th>
        <th data="{required:true, name:'amount', placeholder:'Required'}">Amount</th>
        <th data="{required:true, name:'amount', placeholder:'Required'}">Iva</th>
        <th data="{editable:false}">&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <g:set var="x" value="${1}"/>
    <g:each in="${billsDetails}" status="i" var="billsDetailsInstance">
        <tr>
            <th scope="row">${x++}</th>

            <td class="col-md-3">
                <g:textField labelFor="amount"    name="amount" labelClass="hide"
                              inputMaxLength="10" inputValue="${billsDetailsInstance?.amount}" />
            </td>

            <td class="col-md-3">
                <g:textField labelFor="iva10"    name="iva10" labelClass="hide"
                              inputMaxLength="10" inputValue="${billsDetailsInstance?.iva10}"/>
            </td>

            <td>
                <button type="button" class="btn btn-default btn-sm td" id="${billsDetailsInstance?.id}">
                    <span class="glyphicon glyphicon-minus icon-large" aria-hidden="true"></span>
                </button>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>