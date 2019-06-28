
<div class="form-row">
    <div class="col">
        <div class="form-group">
            <label for="fecha">Fecha</label>
            <input class="form-control" id="fecha" type="date" value="2019-05-05" required="">
        </div>
    </div>
    <div class="col">
        <div class="form-group">
            <label for="timbrado">Timbrado</label>
            <input class="form-control" type="text" id="timbrado" value="8457856" required="">
        </div>
    </div>
    <div class="col">
        <div class="form-group"><label for="numero">Número</label>
            <div id="numero" class="input-group number-bill-group">
                <input class="form-control" type="text" value="001" maxlength="3" minlength="3" required="">
                <input class="form-control" type="text" value="001" maxlength="3" minlength="3" required="">
                <input class="form-control" type="text" value="0000425" minlength="7" maxlength="7" required="">
            </div>
        </div>
    </div>
</div>
<div class="form-row">
    <div class="col">
        <div class="form-group">
            <label for="nombre">Nombre</label>
            <input id="nombre" class="form-control" type="text" value="Fulano Mengano" required="">
        </div>
    </div>
    <div class="col">
        <div class="form-group">
            <label for="ruc">RUC</label>
            <input id="ruc" class="form-control" type="text" value="4.315.943-0" required="">
        </div>
    </div>
    <div class="col">
        <div class="form-group">
            <label for="direccion">Dirección</label>
            <input id="direccion" class="form-control" type="text" required="" placeholder="Opcional">
        </div>
    </div>
</div>
<div class="master ${hasErrors(bean: billsInstance, field: 'order', 'error')} required">
    <label for="order">
        Orden
        <span class="required-indicator">*</span>
    </label>
    <g:select id="order" name="order" maxlength="50" from="${order}" optionKey="id" optionValue="orderNumber" required="" value="${billsInstance?.order?.id}" class="form-control"/>
</div>
<hr>

<fieldset class="form">
    <br>
<h4>Detalles</h4>
    <g:set var="x" value="${1}"/>
    <button id="add" class="btn btn-sm btn-info float-right">+</button>

    <div class="table-responsive">
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Producto</th>
                    <th>Unitario</th>
                    <th>Cantidad</th>
                    <th>Total</th>
                    <th>10%</th>
                    <th>5%</th>
                    <th>Exenta</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${billsInstance.details}" status="i" var="billsDetailsInstance">
                    <tr class="data">

                        <td>
                            <g:textField labelFor="id"    name="id" labelClass="hide"
                                         inputMaxLength="10" value="${billsDetailsInstance?.id}" />
                        </td>

                        <th scope="row">${x++}</th>
                        <td class="p-1 m-1"><input value="Cerveza" name="producto" placeholder="Producto" class="form-control m-0 p-0"/></td>
                        <td>4.500Gs</td>
                        <td class="p-1 m-1"><input type="number" max="100" min="1" value="6" placeholder="Cantidad" class="form-control m-0 p-0"></td>
                        <td>27.000Gs</td>
                        <td>2.454Gs</td>
                        <td></td>
                        <td></td>
                        <td><button id="${billsDetailsInstance?.id}" class="btn btn-outline-warning delete" type="button"><i class="fa fa-remove"></i></button></td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </div>
</fieldset>
<br>
<button id="save" class="btn btn-primary">Guardar</button>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<g:javascript>
    function setDeletes(){
        $(".delete").click(function() {
            $(this).parent().parent().remove();
            url = "${createLink(controller: 'BillsDetails', action: 'delete')}";
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
    setDeletes();
    $('#add').click(function () {
        var rowCount = $('#myTable tr').length;
        var campos =  '' +

            '<tr class="data">'+
'    <th scope="row">'+rowCount+'</th>'+
'    <td class="p-1 m-1"><input value="" placeholder="Producto" name="producto" class="form-control m-0 p-0"/></td>'+
'    <td></td>'+
'    <td class="p-1 m-1"><input type="number" max="100" min="1" value="" placeholder="Cantidad"
                                class="form-control m-0 p-0"></td>'+
'    <td></td>'+
'    <td></td>'+
'    <td></td>'+
'    <td></td>'+
'    <td class="p-1 m-1"><button id="none" class="btn btn-outline-warning delete" type="button"><i
        class="fa fa-remove"></i></button></td>'+
'</tr>';
        console.log("campo agregado");
        $('tbody').append(campos);
        setDeletes();
    });
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