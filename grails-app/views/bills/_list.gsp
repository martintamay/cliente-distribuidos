<table class="table table-striped">
     <thead class="thead-dark">
    <tr >

        <g:sortableColumn property="total" title="Total" />
        <g:sortableColumn property="iva10" title="Iva10" />
        <g:sortableColumn property="order" title="Order" />
        <g:sortableColumn property="ruc" title="Ruc" />
        <g:sortableColumn property="timbrado" title="Total" />
        <g:sortableColumn property="num1" title="Num1" />
        <g:sortableColumn property="num2" title="Num2" />
        <g:sortableColumn property="num3" title="Num3" />


        <th></th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${billsInstanceList}" status="i" var="billsInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td>
                ${fieldValue(bean: billsInstance, field: "total")}
            </td>



             <td>
                 ${fieldValue(bean: billsInstance, field: "iva10")}
             </td>


            <td>
                ${fieldValue(bean: billsInstance, field: "order.orderNumber")}
            </td>

            <td>
                ${fieldValue(bean: billsInstance, field: "ruc")}
            </td>
            <td>
                ${fieldValue(bean: billsInstance, field: "timbrado")}
            </td>
            <td>
                ${fieldValue(bean: billsInstance, field: "num1")}
            </td>
            <td>
                ${fieldValue(bean: billsInstance, field: "num2")}
            </td>
            <td>
                ${fieldValue(bean: billsInstance, field: "num3")}
            </td>

            <td>
                <g:link class="btn btn-outline-secondary" action="show" id="${billsInstance?.id}"><i class="fa fa-eye"></i> </g:link>
                <g:link class="btn btn-outline-secondary" action="edit" id="${billsInstance?.id}"><i class="fa fa-pencil"></i> </g:link>
                <g:link class="btn btn-outline-danger" action="delete" id="${billsInstance?.id}"><i class="fa fa-trash-o"></i> </g:link>
            </td>
        </tr>

    </g:each>
    </tbody>
</table>