<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="this blog page was powered by jcker.org">
    <meta name="author" content="Alan Turing">
    <title>Blog</title>
    <link href="/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/assets/commons/sticky-footer-navbar.css" rel="stylesheet"/>
    <link href="/assets/css/ztree.css" rel="stylesheet"/>
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
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">扫描登录</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                </div>
                <div class="modal-footer">
                    <button type="reset" class="btn btn-secondary" data-dismiss="modal">重新加载</button>
                </div>
            </div>
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
<script type=“text/javascript” src="/assets/popper/popper.js"></script>
<script type=“text/javascript” src="/assets/jquery/jquery.js"></script>
<script type=“text/javascript” src="/assets/js/jquery.ztree.all.min.js"></script>
<script type=“text/javascript” src="/assets/bootstrap/js/bootstrap.min.js"></script>
<script type=“text/javascript” src="/assets/js/index.js"></script>
</body>
</html>
