<div class="form-row">
    <div class="col">
        <div class="form-group master ${hasErrors(bean: orderInstance, field: 'orderNumber', 'error')} required">
            <label for="orderNumber">
                Numero de Orden
                <span class="required-indicator">*</span>
            </label>
            <g:textField name="orderNumber" maxlength="50" required="" value="${orderInstance?.orderNumber}" class="form-control"/>
        </div>
    </div>

    <div class="col">
        <div class="form-group master ${hasErrors(bean: orderInstance, field: 'address', 'error')} required">
            <label for="address">
               Direccion
                <span class="required-indicator">*</span>
            </label>
            <g:textField name="address" maxlength="50" required="" value="${orderInstance?.address}" class="form-control"/>
        </div>
    </div>

    <div class="col">
        <div class="form-group master ${hasErrors(bean: orderInstance, field: 'state', 'error')} required">
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
        <div class="form-group master ${hasErrors(bean: orderInstance, field: 'establishments', 'error')} required">
            <label for="establishment">
                Establecimiento
                <span class="required-indicator">*</span>
            </label>
            <g:select id="establishment" name="establishments" maxlength="50" from="${establishments}" optionKey="id" optionValue="name" required="" value="${orderInstance?.establishments?.id}" class="form-control"/>
        </div>
    </div>
    <div class="col">
        <div class="form-group master ${hasErrors(bean: orderInstance, field: 'user', 'error')} required">
            <label for="user">
                Usuario
                <span class="required-indicator">*</span>
            </label>
            <g:select id="user" name="user" maxlength="50" from="${user}" optionKey="id" optionValue="firstName" required="" value="${orderInstance?.user?.id}" class="form-control"/>
        </div>
    </div>

    <div class="col">
        <div class="form-group master ${hasErrors(bean: orderInstance, field: 'contactNumber', 'error')} required">
            <label for="contactNumber">
               Numero de Contacto
                <span class="required-indicator">*</span>
            </label>
            <g:textField name="contactNumber" maxlength="50" required="" value="${orderInstance?.contactNumber}" class="form-control"/>
        </div>
    </div>
</div>

<div class="form-group master ${hasErrors(bean: orderInstance, field: 'totalCost', 'error')} required">
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
            <tbody>
                <g:each in="${orderInstance.details}" status="i" var="orderDetailsInstance">
                    <tr id="row-${++x}" class="data">
                        <g:hiddenField labelFor="id" name="id"
                                     inputMaxLength="10" value="${orderDetailsInstance?.id}" />


                        <th scope="row">${x}</th>
                        <td class="p-1 m-1">
                            <g:if test="${ orderDetailsInstance.product != null }">
                                <select value="1:${orderDetailsInstance.product.id}" type="text" autocomplete="off"
                                       name="option" placeholder="Escriba para buscar"
                                        class="select-box form-control m-0 p-0" onchange="productSelected">
                                    <option cost="${orderDetailsInstance.product.cost}" value="1:${orderDetailsInstance.product.id}">${orderDetailsInstance.product.name}</option>
                                </select>
                                <g:hiddenField id="option" name="productId" value="${orderDetailsInstance.product.id}" />
                            </g:if>
                            <g:elseif test="${ orderDetailsInstance.promotion != null }">
                                <select value="${orderDetailsInstance.promotion.id}" type="text" autocomplete="off"
                                       name="option" placeholder="Escriba para buscar"
                                       class="select-box form-control m-0 p-0">
                                    <option cost="0" value="1:${orderDetailsInstance.promotion.id}">${orderDetailsInstance.promotion.name}</option>
                                </select>
                                <g:hiddenField id="option" name="promotionId" value="${orderDetailsInstance.promotion.id}" />
                            </g:elseif>
                            <g:elseif test="${ orderDetailsInstance.packageB != null }">
                                <select value="${orderDetailsInstance.packageB.name}" type="text"
                                       autocomplete="off" name="option" placeholder="Escriba para buscar"
                                       class="select-box form-control m-0 p-0">
                                    <option cost="${orderDetailsInstance.packageB.cost}" value="1:${orderDetailsInstance.packageB.id}">${orderDetailsInstance.packageB.name}</option>
                                </select>
                                <g:hiddenField id="option" name="packageId" value="${orderDetailsInstance.packageB.id}" />
                            </g:elseif>
                        </td>
                        <td class="cost-col">
                            <label><g:formatNumber number="${orderDetailsInstance.cost}" type="number" maxFractionDigits="0" />Gs</label>
                            <g:hiddenField name="cost" value="${orderDetailsInstance.cost}" autocomplete="off" />
                        </td>
                        <td class="p-1 m-1">
                            <input type="number" autocomplete="off" rowId="${x}" max="100" min="1" value="${orderDetailsInstance.quantity}" placeholder="Cantidad" name="quantity" class="form-control cant-input m-0 p-0">
                        </td>
                        <td class="total-col">
                            <g:formatNumber number="${orderDetailsInstance.quantity * orderDetailsInstance.cost}" type="number" maxFractionDigits="0" />Gs
                        </td>
                        <td>
                            <input value="${orderDetailsInstance.comment}" name="comment" placeholder="Comentario" class="form-control m-0 p-0"/>
                        </td>
                        <td>
                            <button id="${orderDetailsInstance?.id}" class="btn btn-outline-warning delete" type="button">
                                <i class="fa fa-remove"></i>
                            </button>
                        </td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </div>
</fieldset>


<br>
<button id="save" class="btn btn-primary">Guardar</button>
<g:javascript>
    $(document).ready(function() {
        initChosen();
        setTotales();
        setDeletes();
    });

    function productSelected(event) {
        var types = {"1": "productId", "2": "promotionId", "3": "packageId"};
        var  target = $(event.target);
        var selected = target.val().split(":");
        var field = target.parent().find("#option")[0];
        field.name = types[selected[0]];
        field.value = selected[1];

        //se trae el precio
        var precio = "";
        $(".select-box").find("option").each(function(ind, ele) {
            if (ele.value == target.val()){
                precio = ele.attributes.cost.value;
            }
        });

        var colCost = $(event.target).parentsUntil("tbody").find(".cost-col");
        var cant = $(event.target).parentsUntil("tbody").find(".cant-input")[0];
        var totalCol = $(event.target).parentsUntil("tbody").find(".total-col")[0];
        console.log("colCost", colCost);
        colCost.find("label")[0].innerText = format(precio)+"Gs";
        colCost.find("input")[0].value = precio;
        totalCol.innerHTML = format(cant.valueAsNumber * precio)+"Gs";
        setTotales()
    }

    function initChosen(){
        $(".select-box").chosen();
        $('.chosen-search input').autocomplete({
            source: function( request, response ) {
                $.ajax({
                    url: "/order/options?q="+request.term,
                    dataType: "json",
                    success: function( data ) {
                        var selectBox = $('.chosen-search input:focus').parentsUntil("tr").find('.select-box');
                        var cambio = false;
                        if(data.length > 0){
                            response( $.map( data, function( item ) {
                                var yaesta = false;
                                selectBox.find("option").each(function(ind, ele) {
                                    if (ele.value == item.value){
                                        yaesta = true;
                                        console.log("ya estaba");
                                    }
                                });
                                if (!yaesta){
                                    selectBox.append('<option cost="'+item.cost+'" value="'+item.value+'">' + item.text + '</option>');
                                    cambio = true;
                                }
                            }));
                        }

                        if (cambio)
                            selectBox.trigger("chosen:updated");
                    }
                });
            }
        });
        $(".select-box").chosen().change(productSelected);
    }

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
                var colCost = $(evt.target).parentsUntil("tbody").find(".cost-col input")[0];
                var cant = $(evt.target).parentsUntil("tbody").find(".cant-input")[0];
                var totalCol = $(evt.target).parentsUntil("tbody").find(".total-col")[0];
                console.log("cost", colCost);
                console.log("cant", cant);
                console.log("total", totalCol);
                totalCol.innerHTML = format(parseInt(cant.value) * parseInt(colCost.value))+"Gs";
            };
        });
    }

    $('#add').click(function () {
        var rowCount = $('#detail-table tr').length;
        var campos = '' +
            '<tr id="row-' + rowCount + '" class="data">'+
            '    <th scope="row">' + rowCount + '</th>'+
            '    <td class="p-1 m-1">'+
            '        <select value="" type="text" autocomplete="off" name="option" placeholder="Escriba para buscar" class="select-box form-control m-0 p-0">'+
            '           <option value="" disabled>Escriba para buscar un producto</option> '+
            '        </select>'+
            '        <input type="hidden" name="productId" value="" id="option" />'+
            '    </td>'+
            '    <td class="cost-col">'+
            '        <label></label><input  type="hidden" value="0" name="cost" />'+
            '    </td>'+
            '    <td class="p-1 m-1">'+
            '        <input type="number" name="quantity" rowId="' + rowCount + '" max="100" min="1" value="1" placeholder="Cantidad" class="form-control cant-input m-0 p-0">'+
            '    </td>'+
            '    <td class="total-col">'+
            '   </td>'+
            '   <td>'+
            '       <input value="" name="comment" placeholder="Comentario" class="form-control m-0 p-0"/>'+
            '    </td>'+
            '    <td>'+
            '        <button class="btn btn-outline-warning delete" type="button">'+
            '            <i class="fa fa-remove"></i>'+
            '        </button>'+
            '    </td>'+
            '</tr>';
        console.log("campo agregado");
        $('tbody').append(campos);
        initChosen();
        setDeletes();
        setTotales();
    });
    $('#save').click(function () {
        var orderData = {};
        var details = [];

        $('.master').each(function () {
            if($(this).find('input').attr("name") != undefined) {
                orderData[$(this).find('input').attr("name")] = $(this).find('input').val();
            }else {
                orderData[$(this).find('select').attr("name")] = $(this).find('select').val();
            }
        });

        var rowCount = $('#detail-table tr').length;
        if(rowCount>1) {
            $(".data").each( function() {
                var detail = {};
                $(this).find("input").each(function(pos, ele){
                    detail[ele.name] = ele.value;
                });
                details.push(detail);
            });
        }

        var sendData = JSON.stringify({ order: orderData, details: details});
        console.log("final data", sendData);
        console.log("ACTION", "${action}");
        if("${action}" == "update"){
            $.ajax({
                method:'post',
                contentType:'application/json; charset=utf-8',
                dataType: "json",
                url:"/order/update/${params.id}",
                data: sendData,
                success: handleSuccess,
                error: handleError
            });
        }else {
            $.ajax({
                method:'post',
                contentType:'application/json; charset=utf-8',
                dataType: "json",
                url: "/order/save",
                data:sendData,
                success: handleSuccess,
                error: handleError
            });
        }
    });

    function handleSuccess(response) {
        console.log("Response", response);
    }
    function handleError(response) {
        console.log("error", response.responseJSON);
    }
</g:javascript>