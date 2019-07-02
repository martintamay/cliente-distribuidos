

<div class="form-group ${hasErrors(bean: commentsInstance, field: 'title', 'error')} required">
    <label for="title">
        Titulos
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="title" maxlength="50" required="" value="${commentsInstance?.title}" class="form-control"/>
</div>


<div class="fieldcontain ${hasErrors(bean: commentsInstance, field: 'user', 'error')} required">
    <label for="user">
        Usuario
        <span class="required-indicator">*</span>
    </label>
    <g:select id="user" name="user" maxlength="50" from="${user}" optionKey="id" optionValue="firstName" required="" value="${commentsInstance?.user?.id}" class="form-control"/>
</div>

<div class="form-group ${hasErrors(bean: commentsInstance, field: 'title', 'error')} required">
    <label for="content">
        Contenido
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="content" maxlength="50" required="" value="${commentsInstance?.content}" class="form-control"/>
</div>
<div class="form-group ${hasErrors(bean: commentsInstance, field: 'deleted', 'error')} required">
    <label for="deleted">
        Eliminado
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="deleted" maxlength="50" required="" value="${commentsInstance?.deleted}" class="form-control"/>
</div>

<div class="form-group ${hasErrors(bean: commentsInstance, field: 'establishments', 'error')} required">
    <label for="establishments">
        Establecimiento
        <span class="required-indicator">*</span>
    </label>
    <g:select id="establishments" name="establishments" maxlength="50" from="${establishments}" optionKey="id" optionValue="name" required="" value="${commentsInstance?.establishments?.id}" class="form-control"/>
</div>

