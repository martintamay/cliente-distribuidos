<div class="form-group master ${hasErrors(bean: promotionsIntance, field: 'name', 'error')} required">
    <label for="name">
       Nombre
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" maxlength="50" required="" value="${promotionInstance?.name}" class="form-control"/>
</div>

<div class="form-group master ${hasErrors(bean: promotionInstance, field: 'available', 'error')} required">
    <label for="available">
       Disponible
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="available" maxlength="50" required="" value="${promotionInstance?.available}" class="form-control"/>
</div>
<div class="well">
    <div id="datetimepicker1" class="input-append date">
        <div class="form-group master ${hasErrors(bean: promotionInstance, field: 'end_date', 'error')} required">
            <label for="end_date">
                Fecha de finalización
                <span class="required-indicator">*</span>
            </label>
            <g:field  name="end_date" type="date" value="${promotionInstance?.end_date}" class="form-control"/>
        </div>
        <span class="add-on">
            <i data-time-icon="icon-time" data-date-icon="icon-calendar">
            </i>
        </span>
    </div>
</div>
<div id="products" style="display: none">
    <g:select style="width: 150px" name="product" maxlength="50" from="${products}" optionKey="id" optionValue="name" required=""  class="form-control"/>
</div>
<fieldset class="form-group">
    <br>
    <h4>Detalles</h4>
    <g:set var="x" value="${1}"/>
    <button id="add" class="btn btn-sm btn-info">+</button>
    <table id="myTable">
        <thead>
        <tr>
            <th>#</th>
            <th>Producto</th>
            <th>Cantidad</th>
            <th>Precio</th>
            <th>Comentario</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${promotionInstance.productHasPromotions}" status="i" var="detailsInstance">
            <tr class="data">
                <th scope="row">${x++}</th>

                <td style="display: none;">
                    <g:textField labelFor="id"    name="id" labelClass="hide"
                                 inputMaxLength="10" value="${detailsInstance?.id}" />
                </td>

                <td class="col-2">
                    <g:select style="width: 150px" name="product" maxlength="50" from="${products}" optionKey="id" optionValue="description" value="${detailsInstance?.product}" required=""  class="form-control"/>

                </td>
                <td class="col-2">
                    <g:textField  name="cost" labelClass="hide"
                                 inputMaxLength="10" value="${detailsInstance?.cost}" />
                </td>
                <td class="col-2">
                    <g:textField  name="quantity" labelClass="hide"
                                  inputMaxLength="10" value="${detailsInstance?.quantity}" />
                </td>
                <td class="col-2">
                    <g:textField  name="comment" labelClass="hide"
                                  inputMaxLength="10" value="${detailsInstance?.comment}" />
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

<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<script src="js/bootstrap-datetimepicker.min.js"></script>

<!-- Minified JS library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Minified Bootstrap JS -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<g:javascript>
    function setDeletes(){
        $(".delete").click(function() {
            $(this).parent().parent().remove();
            url = "${createLink(controller: 'ProductHasPromotions', action: 'delete')}"
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
        '<td class="col-2">'+$("#products").html()+'</td>'+
        '<td class="col-2"><input type="text" name="quantity"></td>' +
        '<td class="col-2"><input type="text" name="cost"></td>' +
        '<td class="col-2"><input type="text" name="comment"></td>' +
        '<td><button id="none" class="btn btn-danger delete">x</button></td>' +
        '</tr>'
        $('tbody').append(campos);
        setDeletes();
    })
    $('#save').click(function () {
        var master = '{"promotion":{';
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
            var details = ',"productsHasPromotions":[';
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
            url= "/promotion/"+"${action}"+"/"+"${params.id}"
        }else {
            url= "/promotion/save"
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