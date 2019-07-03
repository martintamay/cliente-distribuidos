<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'bills.label', default: 'Bills')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<br>
<div class="card container content scaffold-edit ">
    <div class="card-body">
        <h1>Factura</h1>
        <div class="form-row">
            <div class="col">
                <div class="form-group master ${hasErrors(bean: billsInstance, field: 'fecha', 'error')} required">
                    <label>
                        Fecha
                    </label>
                    <p>${billsInstance?.fecha}</p>
                </div>
            </div>
            <div class="col">
                <div class="form-group master ${hasErrors(bean: billsInstance, field: 'timbrado', 'error')} required">
                    <label>
                        Timbrado
                    </label>
                    <p> ${billsInstance?.timbrado}<p/>
                </div>
            </div>
            <div class="col">
                <div class="form-group"><label for="numero">Número</label>
                    <div id="numero" class="input-group number-bill-group">
                        <div class="form-control master ${hasErrors(bean: billsInstance, field: 'num1', 'error')} required">
                            ${billsInstance?.num1}
                        </div>
                        <div class="form-control master ${hasErrors(bean: billsInstance, field: 'num2', 'error')} required">
                            ${billsInstance?.num2}
                        </div>
                        <div class="form-control master ${hasErrors(bean: billsInstance, field: 'num3', 'error')} required">
                            ${billsInstance?.num3}
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <div class="form-group master ${hasErrors(bean: billsInstance, field: 'nombre', 'error')} required">
                    <label>
                        Nombre
                    </label>
                    <p>${billsInstance?.nombre}</p>
                </div>
            </div>
            <div class="col">
                <div class="form-group master">
                    <label>
                        Direccion
                    </label>
                    <p>
                        ${billsInstance?.direccion}
                    </p>
                </div>
            </div>
            <div class="col">
                <div class="form-group master ${hasErrors(bean: billsInstance, field: 'ruc', 'error')} required">
                    <label>
                        RUC
                    </label>
                    <p>
                        ${billsInstance?.ruc}
                    </p>
                </div>
            </div>
        </div>
        <div class="master ${hasErrors(bean: billsInstance, field: 'order', 'error')} required" style="display: none">
            <label for="order">
                Orden
                <span class="required-indicator">*</span>
            </label>
            <g:select id="order" name="order" maxlength="50" from="${order}" optionKey="id" optionValue="orderNumber" required="" value="${billsInstance?.order?.id}" class="form-control"/>
        </div>
        <hr>
        <fieldset class="form">
            <br>
            <h4>Detalles</h4>
            <g:set var="x" value="${0}"/>

            <div class="table-responsive">
                <table id="myTable" class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Producto</th>
                        <th>Unitario</th>
                        <th>Cantidad</th>
                        <th>Total</th>
                        <th>10%</th>
                        <th>5%</th>
                        <th style="display: none">Exenta</th>
                    </tr>
                    </thead>
                    <tbody>
                    <g:each in="${billsInstance.billsDetails}" status="i" var="billsDetailsInstance">
                        <tr class="data">

                            <td style="display: none">
                                <g:textField labelFor="id"    name="id" labelClass="hide"
                                             inputMaxLength="10" value="${billsDetailsInstance?.id}" />
                            </td>
                            <td style="display: none">
                                <g:textField labelFor="id"    name="exenta" labelClass="hide"
                                             inputMaxLength="10" value="${billsDetailsInstance?.exenta}" />
                            </td>

                            <th scope="row">${++x}</th>
                            <td>
                                ${billsDetailsInstance?.product?.name}
                            </td>

                            <td>
                                ${billsDetailsInstance?.product?.cost}
                            </td>

                            <td>
                                ${billsDetailsInstance?.quantity}
                            </td>
                            <td>
                                ${billsDetailsInstance.amount}
                            </td>
                            <td>
                                ${billsDetailsInstance?.iva10}
                            </td>
                            <td>
                                ${billsDetailsInstance?.iva5}
                            </td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
        </fieldset>
        <span class="d-flex justify-content-end master ${hasErrors(bean: billsInstance, field: 'total', 'error')} required">
            <span>
                Total:
            </span>
            <span class="ml-2">
                ${billsInstance?.total}
            </span>
        </span>
    </div>
</div>
</html>
