<!DOCTYPE html>
<html lang="en">
<head>
    ...
    <!--// OPTIONAL & CONDITIONAL CSS FILES //-->
    <!-- date picker css -->
    <link rel="stylesheet" href="${request.contextPath}/coreUI/css/datepicker.css?v=1">
    <!-- full calander css -->
    <link rel="stylesheet" href="${request.contextPath}/coreUI/css/fullcalendar.css?v=1">
    <!-- data tables extended CSS -->

    <asset:stylesheet src="application.css"/>
    <!-- Font Awesome -->
    <asset:stylesheet src="font-awesome.min.css"/>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <!-- ion icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500,700,900" rel="stylesheet">
    <!-- Simple line Icon -->
    <asset:stylesheet src="simple-line-icons.css"/>
    <!-- Themify Icon -->
    <asset:stylesheet src="themify-icons.css"/>
    <!-- Hover Effects -->
    <asset:stylesheet src="set1.css"/>
    <!-- Main CSS -->
    <asset:stylesheet src="style.css"/>
    ...
</head>
<body>
...
</aside>
<!-- aside end -->
<!-- main content -->
<div id="page-content">
    <g:layoutBody/>
</div>
<!-- end main content -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<!-- aside right on high res -->
<aside class="right">
    ...
    <script src="${request.contextPath}/coreUI/js/include/jquery.flot.cust.min.js"></script>
    <script src="${request.contextPath}/coreUI/js/include/jquery.flot.resize.min.js"></script>
    <script src="${request.contextPath}/coreUI/js/include/jquery.flot.tooltip.min.js"></script>
    <script src="${request.contextPath}/coreUI/js/include/jquery.flot.orderBar.min.js"></script>
    <script src="${request.contextPath}/coreUI/js/include/jquery.flot.fillbetween.min.js"></script>
    <script src="${request.contextPath}/coreUI/js/include/jquery.flot.pie.min.js"></script>
    </aside>
</body>
</html>