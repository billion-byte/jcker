<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="this blog page was powered by jcker.org">
    <meta name="author" content="Alan Turing">
    <title>Blog</title>
    <!-- Bootstrap core CSS -->
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
    <div class="collapse navbar-collapse justify-content-md-left" id="containerNavbarCenter">

        <form class="form-inline mt-2 mt-md-0" method="POST" enctype="multipart/form-data" action="/upload">
            <label class="btn btn-default">
                <span class="btn-link">选择</span><input type="file" name="file" hidden>
            </label>
            <input class="btn btn-link" type="submit" value="上传"/>
        </form>
        <button type="button" class="btn btn-link" data-toggle="modal" data-target="#exampleModal">
            新增目录
        </button>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <ul class="list-unstyled ztree" id="published">
            </ul>
        </div>
        <div class="col-md-6">
            <ul class="list-unstyled ztree" id="unpublished">
            </ul>
        </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">新增目录</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input name="category" type="text" id="category" class="form-control" placeholder="Category Name" required autofocus>
                </div>
                <div class="modal-footer">
                    <button type="reset" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button id="createCategory" type="button" class="btn btn-primary">Create</button>
                </div>
            </div>
        </div>
    </div>
</div>
<footer class="footer">
    <div class="container">
        <p class="text-muted">Copyright &copy; jcker.org 2017</p>
    </div>
</footer>

<!-- Bootstrap core JavaScript -->
<script type=“text/javascript” src="/assets/popper/popper.js"></script>
<script type=“text/javascript” src="/assets/jquery/jquery.js"></script>
<script type=“text/javascript” src="/assets/js/jquery.ztree.all.min.js"></script>
<script type=“text/javascript” src="/assets/bootstrap/js/bootstrap.min.js"></script>
<script type=“text/javascript” src="/assets/js/admin.js"></script>
</body>

</html>
