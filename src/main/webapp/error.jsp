<%
    request.setAttribute("basePath", request.getContextPath());
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="assets/img/favicon.ico">

    <title>Jcker</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${basePath}/assets/bootstrap/css/bootstrap.min.css">
    <link href="${basePath}/assets/commons/sticky-footer-navbar.css" rel="stylesheet">
    <style>

    </style>


    <script type='text/javascript'>
    </script>
</head>

<body>
<div class="navbar navbar-inverse">
    <div class="container-fluid">
        <!--Logo-->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mainNavBar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="http://jcker.org" class="navbar-brand">Jcker</a>
        </div>
        <!--menu list-->
        <nav class="collapse navbar-collapse" id="mainNavBar">
            <ul class="nav navbar-nav">
                <li class="home"><a href="${basePath}/">Home</a></li>
            </ul>
        </nav>
    </div>
</div>

<div class="container">

    <h1>Already Login QQ: ${userInfo.uin}</h1>

</div>

<script src="${basePath}/assets/popper/popper.min.js"></script>
<script src="${basePath}/assets/jquery/jquery.min.js"></script>
<script src="${basePath}/assets/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
