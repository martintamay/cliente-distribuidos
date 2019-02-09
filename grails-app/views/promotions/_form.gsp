<div class="form-group ${hasErrors(bean: promotionsInstance, field: 'name', 'error')} required">
    <label for="name">
       Nombre
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" maxlength="50" required="" value="${promotionsInstance?.name}" class="form-control"/>
</div>

<div class="form-group ${hasErrors(bean: promotionsInstance, field: 'available', 'error')} required">
    <label for="available">
       Disponible
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="available" maxlength="50" required="" value="${promotionsInstance?.available}" class="form-control"/>
</div>
<div class="form-group ${hasErrors(bean: promotionsInstance, field: 'end_date', 'error')} required">
    <label for="end_date">
        Fecha Final
        <span class="required-indicator">*</span>
    </label>
<g:datePicker name="end_date" value="${promotionsInstance?.end_date}"
               class="form-control"/></div>