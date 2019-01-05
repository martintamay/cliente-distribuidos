<div class="form-group ${hasErrors(bean: billsDetailsInstance, field: 'amount', 'error')} required">
    <label for="amount">
        Cantidad
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="amount" maxlength="50" required="" value="${billsDetailsInstance?.amount}" class="form-control"/>
</div>



<div class="form-group ${hasErrors(bean: billsDetailsInstance, field: 'iva10', 'error')} required">
    <label for="iva10">
        Iva10
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="iva10" maxlength="50" required="" value="${billsDetailsInstance?.iva10}" class="form-control"/>
</div>




<div class="form-group ${hasErrors(bean: billsDetailsInstance, field: 'bills', 'error')} required">
    <label for="bills">
        Factura
        <span class="required-indicator">*</span>
    </label>
    <g:select id="bills" name="bills" maxlength="50" from="${bills}" optionKey="id" optionValue="total" required="" value="${billsDetailsInstance?.bills?.id}" class="form-control"/>
</div>
