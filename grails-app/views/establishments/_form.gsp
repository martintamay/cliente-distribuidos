<div class="form-group ${hasErrors(bean: establishmentsInstance, field: 'name', 'error')} required">
    <label for="name">
        Nombre
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" maxlength="50" required="" value="${establishmentsInstance?.name}" class="form-control"/>
</div>


<div class="form-group ${hasErrors(bean: establishmentsInstance, field: 'address', 'error')} required">
    <label for="address">
        Direccion
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="address" maxlength="50" required="" value="${establishmentsInstance?.address}" class="form-control"/>
</div>

<div class="form-group ${hasErrors(bean: establishmentsInstance, field: 'description', 'error')} required">
    <label for="description">
        Descripcion
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="description" maxlength="50" required="" value="${establishmentsInstance?.description}" class="form-control"/>
</div>


<div class="form-group ${hasErrors(bean: establishmentsInstance, field: 'email', 'error')} required">
    <label for="email">
        Email
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="email" maxlength="50" required="" value="${establishmentsInstance?.email}" class="form-control"/>
</div>
<div class="form-group ${hasErrors(bean: establishmentsInstance, field: 'phoneNumber', 'error')} required">
    <label for="phoneNumber">
        Phone Number
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="phoneNumber" maxlength="50" required="" value="${establishmentsInstance?.phoneNumber}" class="form-control"/>
</div>
<div class="form-group ${hasErrors(bean: establishmentsInstance, field: 'schedule', 'error')} required">
    <label for="schedule">
        Schedule
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="schedule" maxlength="50" required="" value="${establishmentsInstance?.schedule}" class="form-control"/>
</div>


