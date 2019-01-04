
<div class="form-group ${hasErrors(bean: billsInstance, field: 'total', 'error')} required">
    <label for="total">
        Total
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="total" maxlength="50" required="" value="${billsInstance?.total}" class="form-control"/>
</div>



<div class="form-group ${hasErrors(bean: billsInstance, field: 'iva10', 'error')} required">
    <label for="iva10">
        Iva10
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="iva10" maxlength="50" required="" value="${billsInstance?.iva10}" class="form-control"/>
</div>




<div class="form-group ${hasErrors(bean: billsInstance, field: 'order', 'error')} required">
    <label for="order">
        Order
        <span class="required-indicator">*</span>
    </label>
    <g:select id="order" name="order" maxlength="50" from="${order}" optionKey="id" optionValue="orderNumber" required="" value="${billsInstance?.order?.id}" class="form-control"/>
</div>
