<div class="form-group ${hasErrors(bean: orderInstance, field: 'orderNumber', 'error')} required">
    <label for="orderNumber">
        Numero de Orden
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="orderNumber" maxlength="50" required="" value="${orderInstance?.orderNumber}" class="form-control"/>
</div>

<div class="form-group ${hasErrors(bean: orderInstance, field: 'address', 'error')} required">
    <label for="address">
       Direccion
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="address" maxlength="50" required="" value="${orderInstance?.address}" class="form-control"/>
</div>
<div class="form-group ${hasErrors(bean: orderInstance, field: 'state', 'error')} required">
    <label for="state">
        Estado
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="state" maxlength="50" required="" value="${orderInstance?.state}" class="form-control"/>
</div>
<div class="form-group ${hasErrors(bean: orderInstance, field: 'contactNumber', 'error')} required">
    <label for="contactNumber">
       Numero de Contacto
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="contactNumber" maxlength="50" required="" value="${orderInstance?.contactNumber}" class="form-control"/>
</div>
<div class="form-group ${hasErrors(bean: orderInstance, field: 'totalCost', 'error')} required">
    <label for="totalCost">
        Costo total
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="totalCost" maxlength="50" required="" value="${orderInstance?.totalCost}" class="form-control"/>
</div>

