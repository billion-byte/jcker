${prefix}

    <link href="/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/commons/sticky-footer-navbar.css" rel="stylesheet">
</head>
<body class='typora-export'>
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
        <div class="col-md-12">

            ${blog}

        </div>
    </div>
</div>
<footer class="footer">
    <div class="container">
        <p class="text-muted">Copyright &copy; jcker.org 2017</p>
    </div>
</footer>
<script src="/assets/popper/popper.js"></script>
<script src="/assets/jquery/jquery.js"></script>
<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
