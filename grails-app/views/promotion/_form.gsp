<div class="form-group ${hasErrors(bean: promotionsIntance, field: 'name', 'error')} required">
    <label for="name">
       Nombre
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" maxlength="50" required="" value="${promotionInstance?.name}" class="form-control"/>
</div>

<div class="form-group ${hasErrors(bean: promotionInstance, field: 'available', 'error')} required">
    <label for="available">
       Disponible
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="available" maxlength="50" required="" value="${promotionInstance?.available}" class="form-control"/>
</div>




<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<script src="js/bootstrap-datetimepicker.min.js"></script>

<body>
	<div class="well">
  <div id="datetimepicker1" class="input-append date">
  <div class="form-group ${hasErrors(bean: promotionInstance, field: 'end_date', 'error')} required">
      <label for="end_date">
         Disponible
          <span class="required-indicator">*</span>
      </label>
    <g:field  name="end_date" type="date" value="${promotionInstance?.end_date}" class="form-control"/>
    </div>
    <span class="add-on">
      <i data-time-icon="icon-time" data-date-icon="icon-calendar">
      </i>
    </span>
  </div>
</div>

<!-- Minified JS library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Minified Bootstrap JS -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>