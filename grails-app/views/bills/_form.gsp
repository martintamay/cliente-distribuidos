<div class="form-row">
    <div class="col">
        <div class="form-group master ${hasErrors(bean: billsInstance, field: 'fecha', 'error')} required">
            <label for="fecha">
                Fecha
                <span class="required-indicator">*</span>
            </label>
            <g:textField name="fecha" maxlength="50" required="" value="${billsInstance?.fecha}" class="form-control"/>
        </div>
    </div>
    <div class="col">
        <div class="form-group master ${hasErrors(bean: billsInstance, field: 'timbrado', 'error')} required">
            <label for="timbrado">
                Timbrado
                <span class="required-indicator">*</span>
            </label>
            <g:textField name="timbrado" maxlength="50" required="" value="${billsInstance?.timbrado}" class="form-control"/>
        </div>
    </div>
    <div class="col">
        <div class="form-group"><label for="numero">Número</label>
            <div id="numero" class="input-group number-bill-group">
                <div class="form-control master ${hasErrors(bean: billsInstance, field: 'num1', 'error')} required">
                    <g:textField name="num1" maxlength="50" required="" value="${billsInstance?.num1}" class="form-control"/>
                </div>
                <div class="form-control master ${hasErrors(bean: billsInstance, field: 'num2', 'error')} required">
                    <g:textField name="num2" maxlength="50" required="" value="${billsInstance?.num2}" class="form-control"/>
                </div>
                <div class="form-control master ${hasErrors(bean: billsInstance, field: 'num3', 'error')} required">
                    <g:textField name="num3" maxlength="50" required="" value="${billsInstance?.num3}" class="form-control"/>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="form-row">
    <div class="col">
        <div class="form-group master ${hasErrors(bean: billsInstance, field: 'nombre', 'error')} required">
            <label for="nombre">
                Nombre
                <span class="required-indicator">*</span>
            </label>
            <g:textField name="nombre" maxlength="50" required="" value="${billsInstance?.nombre}" class="form-control"/>
        </div>
    </div>

    <div class="col">
        <div class="form-group master ${hasErrors(bean: billsInstance, field: 'ruc', 'error')} required">
            <label for="ruc">
                Ruc
                <span class="required-indicator">*</span>
            </label>
            <g:textField name="ruc" maxlength="50" required="" value="${billsInstance?.ruc}" class="form-control"/>
        </div>
    </div>
    <div class="col">
        <div class="form-group master">
            <label for="direccion">Dirección</label>
            <g:textField name="direccion" maxlength="50" required="" value="${billsInstance?.direccion}" class="form-control"/>
        </div>
    </div>
</div>
<div class="master ${hasErrors(bean: billsInstance, field: 'order', 'error')} required" style="display: none">
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
    <g:set var="x" value="${0}"/>
    <button id="add" class="btn btn-sm btn-info float-right">+</button>

    <div class="table-responsive">
        <table id="myTable" class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Producto</th>
                    <th>Unitario</th>
                    <th>Cantidad</th>
                    <th>Total</th>
                    <th>10%</th>
                    <th>5%</th>
                    <th style="display: none">Exenta</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${billsInstance.billsDetails}" status="i" var="billsDetailsInstance">
                    <tr class="data">

                        <td style="display: none">
                            <g:textField labelFor="id"    name="id" labelClass="hide"
                                         inputMaxLength="10" value="${billsDetailsInstance?.id}" />
                        </td>
                        <td style="display: none">
                            <g:textField labelFor="id"    name="exenta" labelClass="hide"
                                         inputMaxLength="10" value="${billsDetailsInstance?.exenta}" />
                        </td>

                        <th scope="row">${++x}</th>
                        <td>
                            <g:select style="width: 200px" id="${x}" name="product" maxlength="50" from="${products}" optionKey="id" value="${billsDetailsInstance?.product?.id}" optionValue="name" required=""  class="form-control"/>

                        </td>

                        <td>
                            <g:field type="number" id="unitary${x}" name="unitary" class="form-control"
                                         inputMaxLength="10" value="${billsDetailsInstance?.product?.cost}" />
                        </td>

                        <td>
                            <g:field min="1" type="number" id="quantity${x}" name="quantity" class="form-control quantity"
                                         inputMaxLength="10" value="${billsDetailsInstance?.quantity}"/>
                        </td>
                        <td>
                            <g:textField id="total${x}" name="amount" class="form-control total"
                                         inputMaxLength="10" value="${billsDetailsInstance.amount}"/>
                        </td>
                        <td>
                            <g:textField id="iva10${x}" name="iva10" class="form-control"
                                         inputMaxLength="10" value="${billsDetailsInstance?.iva10}"/>
                        </td>
                        <td>
                            <g:textField id="iva5${x}" name="iva5" class="form-control"
                                         inputMaxLength="10" value="${billsDetailsInstance?.iva5}"/>
                        </td>
                        <td style="display: none"></td>
                        <td><button id="${billsDetailsInstance?.id}" class="btn btn-outline-warning delete" type="button"><i class="fa fa-remove"></i></button></td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </div>
</fieldset>
<br>

<span class="d-flex justify-content-end master ${hasErrors(bean: billsInstance, field: 'iva10', 'error')} required" style="display: none">
    <span for="ruc">
        Iva10
    </span>
    <span>
        <g:textField name="iva10" maxlength="50" required="" value="0" class="form-control"/>
    </span>
</span>
<span class="d-flex justify-content-end master ${hasErrors(bean: billsInstance, field: 'total', 'error')} required">
    <span for="ruc">
        Total
    </span>
    <span>
        <g:textField id="total" name="total" maxlength="50" required="" value="${billsInstance?.total}" class="form-control"/>
    </span>
</span>
<button id="save" class="btn btn-primary">Guardar</button>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<g:javascript>
    var id = ${++x};
    var json = JSON.parse('${json}')
    var products = {};
    console.log('${json}')
    for (var i = 0, emp; i < json.length; i++) {
       product = json[i];
       products[ product.id ] = product;
    }
    function calcular(id, selectVal){
        $("#unitary"+ id).val(products[selectVal].cost);
        var total = $("#unitary"+ id).val()*$("#quantity"+ id).val();
        $("#total"+ id).val(total);
        $("#iva10"+ id).val(0.1*total);
        $("#iva5"+ id).val(0.05*total);
        var total = 0;
        $('.total').each(function () {
            total += parseInt($(this).val());
        });
        $('#total').val(total);
    }
    console.log(products[17])
    function changeProduct() {
        $("select").change(function() {
            var pId = $(this).attr("id")
            calcular(pId,$(this).val())
        })
        $(".quantity").bind("keyup change", function() {
            var pId = $(this).attr("id").substr(8)
            console.log(pId)
            calcular(pId, $("#"+pId).val())
        })
    }
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
    changeProduct();
    setDeletes();
    $('#add').click(function () {
        var select = $("<select></select>").attr("name", "product").attr("class","form-control").attr("id",id);
           $.each(json,function(index,json){
            select.append($("<option></option>").attr("value", json.id).text(json.name));
           });
        var rowCount = $('#myTable tr').length;
        var campos =  '' +

            '<tr class="data">'+
'    <th scope="row">'+rowCount+'</th>'+
'    <td>'+select.prop('outerHTML')+'</td>'+
'    <td>' +
'       <input type="number" id="unitary'+id+'" name="unitary" value="'+products[$(select).val()].cost+'" class="form-control m-0 p-0">' +
'    </td>'+
'    <td>'+
'    <input type="number" id="quantity'+id+'" name="quantity" min="1" value="1" placeholder="Cantidad" class="form-control quantity m-0 p-0">'+'</td>'+
'    <td>' +
     '<input type="number" id="total'+id+'" name="amount" value="" class="form-control total m-0 p-0">' +
'    </td>'+
'    <td>' +
'    <input type="number" id="iva10'+id+'" name="iva10" value="" placeholder="Cantidad" class="form-control m-0 p-0">' +
'    </td>'+
'    <td>' +
'    <input type="number" id="iva5'+id+'" name="iva5" value="" class="form-control m-0 p-0">' +
'    </td>'+
'    <td style="display: none">' +
'    <input type="number" id="exenta'+id+'" name="exenta" value="0" class="form-control m-0 p-0">' +
'    </td>'+
'    <td class="p-1 m-1">' +
'       <button id="none" class="btn btn-outline-warning delete" type="button">' +
'           <i class="fa fa-remove"></i>' +
'       </button>' +
'    </td>'+
'    </tr>';
        console.log("campo agregado");
        $('tbody').append(campos);
        calcular(id, $(select).val());
        changeProduct();
        setDeletes();
        id++;
    });
    $('#save').click(function () {
        $('.alert').alert()
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
        master += '}'
        var rowCount = $('#myTable tr').length;
        console.log(rowCount)
        if(rowCount>1) {
            var details = ',"BillsDetails":[';
            $(".data").each(function () {
                details += '{';
                $(this).find('td').each(function () {
                    if($(this).find('input').attr("name") != undefined) {
                        details += '"'+$(this).find('input').attr("name")+'":';
                        details += '"'+$(this).find('input').val()+'",';
                    }else {
                        details += '"'+$(this).find('select').attr("name")+'":';
                        details += '"'+$(this).find('select').val()+'",';
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