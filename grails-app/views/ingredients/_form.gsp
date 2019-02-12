
<div class="form-group ${hasErrors(bean: ingredientsInstance, field: 'description', 'error')} required">
    <label for="description">
       Descipcion
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="description" maxlength="50" required="" value="${ingredientsInstance?.description}" class="form-control"/>
</div>

