
<div class="form-group ${hasErrors(bean: userInstance, field: 'firstName', 'error')} required">
    <label for="firstName">
        Nombres
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="firstName" maxlength="50" required="" value="${userInstance?.firstName}" class="form-control"/>
</div>

<div class="form-group ${hasErrors(bean: userInstance, field: 'lastName', 'error')} required">
    <label for="lastName">
        Apellidos
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="lastName" maxlength="50" required="" value="${userInstance?.lastName}" class="form-control"/>
</div>
<div class="form-group ${hasErrors(bean: userInstance, field: 'email', 'error')} required">
    <label for="email">
        Email
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="email" maxlength="50" required="" value="${userInstance?.email}" class="form-control"/>
</div>
<div class="form-group ${hasErrors(bean: userInstance, field: 'phoneNumber', 'error')} required">
    <label for="lastName">
        Phone Number
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="phoneNumber" maxlength="50" required="" value="${userInstance?.phoneNumber}" class="form-control"/>
</div>
<div class="form-group ${hasErrors(bean: userInstance, field: 'address', 'error')} required">
    <label for="address">
        Address
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="address" maxlength="50" required="" value="${userInstance?.address}" class="form-control"/>
</div>
<div class="form-group ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
    <label for="lastName">
        Password
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="password" maxlength="50" required="" value="${userInstance?.password}" class="form-control"/>
</div>

