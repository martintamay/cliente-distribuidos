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

<div class="table-responsive">
    <table class="table table-striped table-bordered">
        <thead class="thead-dark">
            <tr>
                <th>Producto</th>
                <th>Costo</th>
                <th>Cantidad</th>
                <th>Total</th>
                <th>Comentario</th>
            </tr>
        </thead>

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
    </table>
</div>