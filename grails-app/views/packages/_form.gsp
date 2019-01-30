<div class="form-group ${hasErrors(bean: packagesInstance, field: 'name', 'error')} required">
    <label for="name">
        Nombre
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" maxlength="50" required="" value="${packagesInstance?.name}" class="form-control"/>
</div>


<div class="form-group ${hasErrors(bean: packagesInstance, field: 'cost', 'error')} required">
    <label for="cost">
        Costo
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="cost" maxlength="50" required="" value="${packagesInstance?.cost}" class="form-control"/>
</div>


