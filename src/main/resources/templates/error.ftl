<#import "spring.ftl" as blog/>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="this blog page was powered by jcker.org">
    <meta name="author" content="Alan Turing">
    <title>Blog</title>
</head>

<body>
<nav class="navbar navbar-expand-md fixed-top  navbar-light  bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#containerNavbarCenter"
            aria-controls="containerNavbarCenter" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-md-center" id="containerNavbarCenter">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/">首页<span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <ul class="list-unstyled ztree" id="category">
            </ul>
        </div>
        <div class="col-md-6">
            <div id="groupinfo"></div>
            <div id="message"></div>
        </div>
    </div>
</div>
<footer class="footer">
    <div class="container">
        <p class="text-center">Copyright &copy; jcker.org 2017&nbsp;
            <button type="button" class="btn btn-link" data-toggle="modal" data-target="#exampleModal">
                登录
            </button>
        </p>
    </div>
</footer>
</body>

</html>
