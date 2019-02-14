<div class="form-group ${hasErrors(bean: productsInstance, field: 'name', 'error')} required">
    <label for="name">
        Nombre
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" maxlength="50" required="" value="${productsInstance?.name}" class="form-control"/>
</div>

<div class="form-group ${hasErrors(bean: productsInstance, field: 'description', 'error')} required">
    <label for="description">
        Descripcion
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="description" maxlength="50" required="" value="${productsInstance?.description}" class="form-control"/>
</div>
<div class="form-group ${hasErrors(bean: productsInstance, field: 'cost', 'error')} required">
    <label for="cost">
        Costo
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="cost" maxlength="50" required="" value="${productsInstance?.cost}" class="form-control"/>
</div>

<div class="form-group ${hasErrors(bean: productsInstance, field: 'establishments', 'error')} required">
    <label for="establishments">
        Establecimiento
        <span class="required-indicator">*</span>
    </label>
    <g:select id="establishments" name="establishments" maxlength="50" from="${establishments}" optionKey="id" optionValue="name" required="" value="${productsInstance?.establishments?.id}" class="form-control"/>
</div>



<fieldset class="form">
    <br>
    <h4>Detalles</h4>
    <g:set var="x" value="${1}"/>
    <button id="add" class="btn btn-sm btn-info">+</button>
    <table id="myTable">
        <thead>
        <tr>
            <th>#</th>
            <th>Amount</th>
            <th>Product</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${billsInstance.details}" status="i" var="billsDetailsInstance">
            <tr class="data">
                <th scope="row">${x++}</th>

                <td style="display: none;">
                    <g:textField labelFor="id"    name="id" labelClass="hide"
                                 inputMaxLength="10" value="${billsDetailsInstance?.id}" />
                </td>

                <td>
                    <g:textField labelFor="detail[amount]"    name="amount" labelClass="hide"
                                 inputMaxLength="10" value="${billsDetailsInstance?.amount}" />
                </td>

                <td>
                    <g:textField labelFor="detail[iva]"    name="iva" labelClass="hide"
                                 inputMaxLength="10" value="${billsDetailsInstance?.iva10}"/>
                </td>
                <td>
                    <button id="${billsDetailsInstance?.id}"  class="btn btn-danger delete">x</button>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
</fieldset>
<br>
<button id="save" class="btn btn-primary">Guardar</button>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<g:javascript>
    function setDeletes(){
        $(".delete").click(function() {
            $(this).parent().parent().remove();
            url = "${createLink(controller: 'BillsDetails', action: 'delete')}"
            if($(this).attr('id') != "none"){
                url += "/"+$(this).attr('id');
                $.ajax({
                    method:'get',
                    contentType:'application/json; charset=utf-8',
                    dataType: "json",
                    url: url,
                    success: function(resp){
                    }
                });
            }
        })
    }
    setDeletes()
    $('#add').click(function () {
        var rowCount = $('#myTable tr').length;
        var campos =  '' +
            '<tr class="data">' +
'<th scope="row">'+rowCount+'</th>' +
'<td class="col-md-3"><input type="text" name="amount"></td>' +
'<td class="col-md-3"><input type="text" name="iva"></td>' +
'<td><button id="none" class="btn btn-danger delete">x</button></td>' +
'</tr>'
        console.log("campo agregado");
        $('tbody').append(campos);
        setDeletes();
    })
    $('#save').click(function () {
        var master = '{"bill":{';
        $('.master').each(function () {
            if($(this).find('input').attr("name") != undefined) {
                master += '"'+$(this).find('input').attr("name")+'":';
                master += '"'+$(this).find('input').val()+'",';
            }else {
                master += '"'+$(this).find('select').attr("name")+'":';
                master += '"'+$(this).find('select').val()+'",';
            }
        });
        master = master.substring(0,master.length-1);
        master += '}';
        var rowCount = $('#myTable tr').length;
        if(rowCount>1) {
            var details = ',"BillsDetails":[';
            $(".data").each(function () {
                details += '{';
                $(this).find('td').each(function () {
                    details += '"' + $(this).find('input').attr("name") + '":';
                    details += '"' + $(this).find('input').val() + '",';
                });
                details = details.substring(0, details.length - 1) + '},';
            });
            details = details.substring(0, details.length - 1);
            details += ']}';
            master += details;
        }else {
            master += '}'
        }
        console.log(master);
        var url;
        if("${action}" == "update"){
            url= "/bills/"+"${action}"+"/"+"${params.id}"
        }else {
            url= "/bills/save"
        }
        $.ajax({
            method:'post',
            contentType:'application/json; charset=utf-8',
            dataType: "json",
            url:url,
            data:master,
            success: function(resp){
            }
        });
    });
</g:javascript>
