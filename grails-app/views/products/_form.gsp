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

