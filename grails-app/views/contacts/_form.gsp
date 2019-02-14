
<div class="form-group ${hasErrors(bean: contactsInstance, field: 'fullname', 'error')} required">
    <label for="fullname">
        Su Nombre Completo
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="fullname" maxlength="50" required="" value="${contactsInstance?.fullname}" class="form-control"/>
</div>

<div class="form-group ${hasErrors(bean: contactsInstance, field: 'from', 'error')} required">
    <label for="from">
        Su Correo
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="from" maxlength="50" required="" value="${contactsInstance?.from}" class="form-control"/>
</div>

<div class="form-group ${hasErrors(bean: contactsInstance, field: 'phoneNumber', 'error')} required">
    <label for="phoneNumber">
        Su teléfono
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="phoneNumber" maxlength="50" required="" value="${contactsInstance?.phoneNumber}" class="form-control"/>
</div>

<div class="form-group ${hasErrors(bean: contactsInstance, field: 'message', 'error')} required">
    <label for="message">
        Descipcion
        <span class="required-indicator">*</span>
    </label>
    <g:textArea name="message" maxlength="50" required="" value="${contactsInstance?.message}" class="form-control"/>
</div>


