<%@ page import="delivery.bills.Bills" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'bills.label', default: 'Bills')}" />
    <title>Lista de Facturas</title>
</head>
<body>
<a href="#list-bills" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div id="list-bills" class="container padding-menu" role="main">
    <div class="card">
        <div class="card-title p-3 mb-2 bg-primary text-white">
            <h3><g:message code="default.list.label" args="[entityName]" /></h3>
        </div>
        <div class="card-body">
            <g:if test="${flash.message}">
                <div class="alert alert-info" role="status">${flash.message}</div>
            </g:if>
            <div class="row">
                <div class="col">
                    <div class="input-group mb-3">
                        <div id="search_tagsugg">
                            <input type="text" class="search form-control" id="text" name="text" autocomplete="off" aria-describedby="search">
                        </div>
                    </div>
                </div>
            </div>
            <fieldset class="form">
                <g:render template="list"/>
            </fieldset>
            <div class="btn-group">
                <g:link class="btn btn-primary" action="create">Nueva Factura</g:link>
            </div>
            <g:if test="${page>1}"> <g:link style="align: center;" action="list" id="${page-1}">Back</g:link></g:if>
            <g:if test="${next>0}"><g:link style="align: center;" action="list" id="${page+1}">Next</g:link></g:if>
        </div>
    </div>
</div>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script>
    $(document).ready(function(){
        $('#text').keyup(function(){
            $.ajax({
                url:"${createLink(controller: 'bills', action: 'search')}",
                data:{
                    text:$('#text').val()
                },
                success: function(resp){
                    $('.form').html(resp)
                }

            });
        });
    });
</script>
</body>
</html>