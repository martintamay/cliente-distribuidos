<div class="form-row">
    <div class="col">
        <div class="form-group ${hasErrors(bean: orderInstance, field: 'orderNumber', 'error')} required">
            <label for="orderNumber">
                Numero de Orden
                <span class="required-indicator">*</span>
            </label>
            <g:textField name="orderNumber" maxlength="50" required="" value="${orderInstance?.orderNumber}" class="form-control"/>
        </div>
    </div>

    <div class="col">
        <div class="form-group ${hasErrors(bean: orderInstance, field: 'address', 'error')} required">
            <label for="address">
               Direccion
                <span class="required-indicator">*</span>
            </label>
            <g:textField name="address" maxlength="50" required="" value="${orderInstance?.address}" class="form-control"/>
        </div>
    </div>

    <div class="col">
        <div class="form-group ${hasErrors(bean: orderInstance, field: 'state', 'error')} required">
            <label for="state">
                Estado
                <span class="required-indicator">*</span>
            </label>
            <g:textField name="state" maxlength="50" required="" value="${orderInstance?.state}" class="form-control"/>
        </div>
    </div>

</div>


<div class="form-row">
    <div class="col">
        <div class="form-group ${hasErrors(bean: orderInstance, field: 'establishments', 'error')} required">
            <label for="establishments">
                Establecimiento
                <span class="required-indicator">*</span>
            </label>
            <g:select id="establishments" name="establishments" maxlength="50" from="${establishments}" optionKey="id" optionValue="name" required="" value="${orderInstance?.establishments?.id}" class="form-control"/>
        </div>
    </div>
    <div class="col">
        <div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'user', 'error')} required">
            <label for="user">
                Usuario
                <span class="required-indicator">*</span>
            </label>
            <g:select id="user" name="user" maxlength="50" from="${user}" optionKey="id" optionValue="firstName" required="" value="${orderInstance?.user?.id}" class="form-control"/>
        </div>
    </div>

    <div class="col">
        <div class="form-group ${hasErrors(bean: orderInstance, field: 'contactNumber', 'error')} required">
            <label for="contactNumber">
               Numero de Contacto
                <span class="required-indicator">*</span>
            </label>
            <g:textField name="contactNumber" maxlength="50" required="" value="${orderInstance?.contactNumber}" class="form-control"/>
        </div>
    </div>
</div>

<div class="form-group ${hasErrors(bean: orderInstance, field: 'totalCost', 'error')} required">
    <label for="totalCost">
        Costo total
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="totalCost" maxlength="50" required="" value="${orderInstance?.totalCost}" class="form-control"/>
</div>

<fieldset class="form">
    <br>
    <h4>Detalle</h4>

    <button id="add" class="btn btn-sm btn-info float-right">+</button>

    <div class="table-responsive">
        <table class="table table-striped table-bordered" id="detail-table">
            <thead class="thead-dark">
                <tr>
                    <th>#</th>
                    <th>Producto</th>
                    <th>Costo</th>
                    <th>Cantidad</th>
                    <th>Total</th>
                    <th>Comentario</th>
                    <th></th>
                </tr>
            </thead>

            <g:set var="x" value="${0}"/>
            <g:each in="${orderInstance.details}" status="i" var="billsDetailsInstance">
                <tr id="row-${++x}" class="data">
                    <g:hiddenField labelFor="id" name="id"
                                 inputMaxLength="10" value="${billsDetailsInstance?.id}" />


                    <th scope="row">${x}</th>
                    <td class="p-1 m-1">
                        <g:if test="${ billsDetailsInstance.product != null }">
                            <input value="${billsDetailsInstance.product.name}" type="product" autocomplete="off" name="producto" placeholder="Producto" class="form-control m-0 p-0"/>
                            <g:set var="cost" value="${ billsDetailsInstance.product.cost }" />
                        </g:if>
                        <g:elseif test="${ billsDetailsInstance.promotion != null }">
                            <input value="${billsDetailsInstance.promotion.name}" type="promotion" autocomplete="off" name="producto" placeholder="Producto" class="form-control m-0 p-0"/>
                            <g:set var="cost" value="0" />
                        </g:elseif>
                        <g:elseif test="${ billsDetailsInstance.packageB != null }">
                            <input value="${billsDetailsInstance.packageB.name}" type="package" autocomplete="off" name="producto" placeholder="Producto" class="form-control m-0 p-0"/>
                            <g:set var="cost" value="${ billsDetailsInstance.packageB.cost }" />
                        </g:elseif>
                    </td>
                    <td class="cost-col">
                        <g:formatNumber number="${cost}" type="number" maxFractionDigits="0" />Gs
                    </td>
                    <td class="p-1 m-1">
                        <input type="number" autocomplete="off" rowId="${x}" max="100" min="1" value="${billsDetailsInstance.quantity}" placeholder="Cantidad" class="form-control cant-input m-0 p-0">
                    </td>
                    <td class="total-col">
                        <g:formatNumber number="${billsDetailsInstance.quantity * billsDetailsInstance.product.cost}" type="number" maxFractionDigits="0" />Gs
                    </td>
                    <td>
                        <input value="${billsDetailsInstance.comment}" name="comentario" placeholder="Comentario" class="form-control m-0 p-0"/>
                    </td>
                    <td>
                        <button id="${billsDetailsInstance?.id}" class="btn btn-outline-warning delete" type="button">
                            <i class="fa fa-remove"></i>
                        </button>
                    </td>
                </tr>
            </g:each>
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
            url = "${createLink(controller: 'OrdersDetails', action: 'delete')}";
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

    // fuente: https://tydw.wordpress.com/2008/07/03/javascript-como-formatear-un-numero-con-separador-de-miles/
    function format(num) {
        var num = num.toString().replace(/\./g,'');

        num = num.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g,'$1.');
        num = num.split('').reverse().join('').replace(/^[\.]/,'');
        return num;
    }
    function setTotales(){
        $(".cant-input").each(function ( pos, td ){
            var rowId = "#row-"+td.attributes["rowId"].value;
            td.onchange = function(evt) {
                console.log("evento activado", evt);
                console.log("search id", rowId+" .total-col");
                var sCosto = $(rowId+" .cost-col")[0].innerHTML.trim();
                var cost = parseInt(sCosto.substr(0, sCosto.length - 2).replace(".", ""));
                console.log(evt);
                $(rowId+" .total-col")[0].innerHTML = format(cost*evt.target.valueAsNumber)+'Gs';
            };
            console.log(rowId, td);
        });
    }
    setTotales();

    $('#add').click(function () {
        var rowCount = $('#detail-table tr').length;
        var campos = '' +
            '<tr id="row-' + rowCount + '" class="data">'+
            '    <input type="hidden" name="id" value="none" />'+
            '    <th scope="row">' + rowCount + '</th>'+
            '    <td class="p-1 m-1">'+
            '        <input value="" name="producto" placeholder="Producto" class="form-control m-0 p-0"/>'+
            '    </td>'+
            '    <td class="cost-col">'+
            '    </td>'+
            '    <td class="p-1 m-1">'+
            '        <input type="number" rowId="' + rowCount + '" max="100" min="1" value="1" placeholder="Cantidad" class="form-control cant-input m-0 p-0">'+
            '    </td>'+
            '    <td class="total-col">'+
            '   </td>'+
            '   <td>'+
            '       <input value="" name="comentario" placeholder="Comentario" class="form-control m-0 p-0"/>'+
            '    </td>'+
            '    <td>'+
            '        <button class="btn btn-outline-warning delete" type="button">'+
            '            <i class="fa fa-remove"></i>'+
            '        </button>'+
            '    </td>'+
            '</tr>';
        console.log("campo agregado");
        $('tbody').append(campos);
        setDeletes();
        setTotales();
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