<%@ page import="delivery.establishments.Establishments" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'establishments.label', default: 'Establishments')}" />
    <title>Lista de Establecimientos</title>
</head>
<body>
<a href="#list-establishments" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div id="list-establishments" class="container padding-menu" role="main">
    <div class="card">
        <div class="card-title p-3 mb-2 bg-primary text-white">
            <h3><g:message code="default.list.label" args="[entityName]" /></h3>
        </div>
        <div class="card-body">
            <g:if test="${flash.message}">
                <div class="alert alert-info" role="status">${flash.message}</div>
            </g:if>
            <span id="search_tagsugg" style="float:left">
                <input type="text" class="search" id="text" name="text" autocomplete="off">
            </span>
            <button id="search" class="search_button" >buscar</button>
            <fieldset class="form">
                <g:render template="list"/>
            </fieldset>
            <div class="btn-group">
                <g:link class="btn btn-primary" action="create">Nuevo Establecimiento</g:link>
            </div>
            <g:if test="${page>1}"> <g:link style="align: center;" action="list" id="${page-1}">Back</g:link></g:if>
            <g:if test="${next>0}"><g:link style="align: center;" action="list" id="${page+1}">Next</g:link></g:if>
        </div>
    </div>
</div>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script>
    $(document).ready(function(){
        $('#search').click(function(){
            $.ajax({
                url:"${createLink(controller: 'establishments', action: 'search')}",
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