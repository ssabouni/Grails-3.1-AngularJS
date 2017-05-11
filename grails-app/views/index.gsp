<!doctype html>
<html lang="en" class="no-js">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>LSDDA BBC App</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <asset:stylesheet href="materialize/css/materialize.min.css"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <asset:stylesheet src="stylesheet/isteven-multi-select.css"/>
    <asset:stylesheet src="stylesheet/default.css"/>
    <asset:stylesheet src="stylesheet/default.date.css"/>
    <asset:stylesheet src="stylesheet/default.time.css"/>

    <script type="text/javascript">
        window.contextPath = "${request.contextPath}";
    </script>
</head>
<body ng-app="myapp">

<nav>
    <div class="container">
    <div class="nav-wrapper">
        <a href="#/" class="brand-logo">BBC</a>
    </div>
    </div>
</nav>
<div class="container">
    <div ng-view></div>

</div>
    <div class="footer" role="contentinfo"></div>
    <asset:javascript src="jquery/jquery.js"></asset:javascript>
    <asset:javascript src="materialize/js/materialize.min.js"></asset:javascript>
    <asset:javascript src="myapp/app" />
    <asset:javascript src="angular/isteven-multi-select.js"/>
    <asset:javascript src="angular/picker.js"/>
    <asset:javascript src="angular/picker.date.js"/>
    <asset:javascript src="angular/picket.time.js"/>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular-materialize/0.2.2/angular-materialize.min.js"></script>


<script>
    $(function(){
        $(".dropdown-button").dropdown();
    });

    $(document).ready(function() {
        $('select').material_select();
    });

    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 15 // Creates a dropdown of 15 years to control year
    });

</script>
</body>
</html>
