<%@ page import="delivery.products.Products" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'products.label', default: 'Products')}" />
    <title>Lista de Productos</title>
</head>
<body>
<a href="#list-products" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div id="list-products" class="container padding-menu" role="main">
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
            <g:if test="${page>1}"> <g:link class="btn btn-secondary btn-sm pag-list " style="align: center;" action="list" id="${page-1}"><i class="fa fa-step-backward" aria-hidden="true"></i></g:link></g:if>
            <g:if test="${next>0}"><g:link class="btn btn-secondary btn-sm pag-list" style="align: center;" action="list" id="${page+1}"><i class="fa fa-step-forward" aria-hidden="true"></i></g:link></g:if>
            <button class="btn btn-secondary btn-sm pag-search fa fa-step-backward" id="search-back"></button>
            <button class="btn btn-secondary btn-sm pag-search fa fa-step-forward" id="search-next"></button>
            <div class="btn-group">
                <g:link class="btn btn-primary" action="create">Nuevo Producto</g:link>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script>
    $(document).ready(function(){
        var list = $('.form').html()
        var pag = 1
        $('.pag-search').hide()
        $('#search-next').click(function(){
            $('#search-back').show()
            pag += 1
            buscadorAjax(pag);
        });
        $('#search-back').click(function(){
            pag -= 1
            $('#search-next').show()
            if(pag == 1)
                $('#search-back').hide()
            buscadorAjax(pag);
        });
        $('#text').keyup(function(){
            pag = 1
            $('#search-back').hide()
            if ($('#text').val() == ''){
                $('.form').html(list)
                $('.pag-list').show()
                $('#search-next').hide()
            }else{
                $('.pag-list').hide()
                $('#search-next').show()
                buscadorAjax(pag);

            }
        });
        function buscadorAjax(pag) {
            $.ajax({
                url:"${createLink(controller: 'products', action: 'search')}",
                data:{
                    text:$('#text').val(),
                    page:pag
                },
                success: function(resp){
                    $('.form').html(resp)
                }
            });
        }
    });
</script>
</body>
</html>