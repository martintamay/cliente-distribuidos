<div class="form-group master ${hasErrors(bean: productsInstance, field: 'name', 'error')} required">
    <label for="name">
        Nombre
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" maxlength="50" required="" value="${productsInstance?.name}" class="form-control"/>
</div>

<div class="form-group master ${hasErrors(bean: productsInstance, field: 'description', 'error')} required">
    <label for="description">
        Descripcion
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="description" maxlength="50" required="" value="${productsInstance?.description}" class="form-control"/>
</div>
<div class="form-group master ${hasErrors(bean: productsInstance, field: 'cost', 'error')} required">
    <label for="cost">
        Costo
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="cost" maxlength="50" required="" value="${productsInstance?.cost}" class="form-control"/>
</div>

<div class="form-group master ${hasErrors(bean: productsInstance, field: 'establishments', 'error')} required">
    <label for="establishments">
        Establecimiento
        <span class="required-indicator">*</span>
    </label>
    <g:select id="establishments" name="establishments" maxlength="50" from="${establishments}" optionKey="id" optionValue="name" required="" value="${productsInstance?.establishments?.id}" class="form-control"/>
</div>

    <div id="ingredients" style="display: none">
        <g:select style="width: 200px" id="ingredient" name="ingredient" maxlength="50" from="${ingredients}" optionKey="id" optionValue="description" required=""  class="form-control"/>
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
            <th>Ingrediente</th>
            <th>Cantidad</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${productsInstance.ingredientsProducts}" status="i" var="detailsInstance">
            <tr class="data">
                <th scope="row">${x++}</th>

                <td style="display: none;">
                    <g:textField labelFor="id"    name="id" labelClass="hide"
                                 inputMaxLength="10" value="${detailsInstance?.id}" />
                </td>

                <td class="col-2">
                    <g:select style="width: 200px" id="ingredient" name="ingredient" maxlength="50" from="${ingredients}" optionKey="id" optionValue="description" value="${detailsInstance?.ingredient}" required=""  class="form-control"/>

                </td>
                <td class="col-2">
                    <g:textField labelFor="detail[amount]"    name="amount" labelClass="hide"
                                 inputMaxLength="10" value="${detailsInstance?.amount}" />
                </td>

                <td>
                    <button id="${detailsInstance?.id}"  class="btn btn-danger delete">x</button>
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
            url = "${createLink(controller: 'IngredientsProducts', action: 'delete')}"
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
            '<td class="col-2">'+$("#ingredients").html()+'</td>'+
            '<td class="col-2"><input type="text" name="amount"></td>' +
            '<td><button id="none" class="btn btn-danger delete">x</button></td>' +
            '</tr>'
        $('tbody').append(campos);
        setDeletes();
    })
    $('#save').click(function () {
        var master = '{"Product":{';
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
            var details = ',"IngredientsProducts":[';
            $(".data").each(function () {
                details += '{';
                $(this).find('td').each(function () {
                    if($(this).find('input').attr("name") != undefined) {
                    details += '"' + $(this).find('input').attr("name") + '":';
                    details += '"' + $(this).find('input').val() + '",';
                    }else{
                    details += '"' + $(this).find('select').attr("name") + '":';
                    details += '"' + $(this).find('select').val() + '",';
                    }
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
            url= "/products/"+"${action}"+"/"+"${params.id}"
        }else {
            url= "/products/save"
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
