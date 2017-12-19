<%
    request.setAttribute("basePath", request.getContextPath());
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="this blog page was powered by jcker.org">
    <meta name="author" content="Alan Turing">
    <title>Blog</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${basePath}/assets/bootstrap/css/bootstrap.min.css">
    <link href="${basePath}/assets/commons/sticky-footer-navbar.css" rel="stylesheet">
    <link href="assets/css/ztree.css" rel="stylesheet"/>

</head>
<body>
<nav class="navbar navbar-expand-md fixed-top  navbar-light  bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#containerNavbarCenter"
            aria-controls="containerNavbarCenter" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-md-left" id="containerNavbarCenter">

        <form class="form-inline mt-2 mt-md-0" method="POST" enctype="multipart/form-data" action="${basePath}/upload">
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
<script src="${basePath}/assets/popper/popper.min.js"></script>
<script src="${basePath}/assets/jquery/jquery.min.js"></script>
<script src="${basePath}/assets/js/jquery.ztree.all.min.js"></script>
<script src="${basePath}/assets/bootstrap/js/bootstrap.min.js"></script>
<script type='text/javascript'>
    var setting_published = {
        view: {
            dblClickExpand: false
        },
        async: {
            enable: true,
            contentType: "application/json",
            dataType: "json",
            url: "/blog/getPublishedBlog/true/true"
        },
        edit: {
            enable: true,
            drag: {
                isCopy: true,
                isMove: true,
                prev: true,
                inner: true,
                next: true
            },
            editNameSelectAll: true
        },
        callback: {
            beforeDrop: beforeDrop,
            beforeRemove: beforeRemove
/*            beforeRename: beforeRename,
            beforeEditName: beforeEditName,
            */

        }
    };
    var setting_unpublished = {
        view: {
            dblClickExpand: false
        },
        async: {
            enable: true,
            contentType: "application/json",
            dataType: "json",
            url: "/blog/getUnpublishedBlog/true"
        },
        edit: {
            enable: true,
            drag: {
                isCopy: true,
                isMove: true,
                prev: true,
                inner: true,
                next: true
            },
            editNameSelectAll: true
        },
        callback: {
            beforeDrop: beforeDrop,
            beforeRemove: beforeRemove
            /*            beforeRename: beforeRename,
                        beforeEditName: beforeEditName,
                        */

        }
    };

    $(function () {
        $.fn.zTree.init($("#published"), setting_published);
        $.fn.zTree.init($("#unpublished"), setting_unpublished);

        //createCategory
        $("#createCategory").click(function () {
            var category = $("#category");
            if(category.val().trim() === null || category.val().trim() === ""){
                alert('目录不能为空');
                return;
            }
            $.post( "/blog/createCategory/"+category.val().trim(), function(data) {
                $('#exampleModal').modal('hide');
                if(data) {
                    alert("create [" + category.val() +"] Succeed");
                }else{
                    alert("create [" + category.val() +"] Failed");
                }
                category.val(null);
            });
        });
    });

    function beforeDrop(treeId, treeNodes, targetNode, moveType) {
        for (var i = 0, l = treeNodes.length; i < l; i++) {
            if (treeNodes[i].isParent) {
                alert("only child node is draggable.");
                return false;
            }
        }

        $.post( "/blog/changeBlogCategory", {treeNode: JSON.stringify(treeNodes[0]), targetNode: JSON.stringify(targetNode)}, function( data ) {
            if(data) {
                alert("Change Succeed");
                return true;
            }else{
                alert("Change Failed");
                return false;
            }
        });

//        return targetNode ? targetNode.drop !== false : true;
    }

/*    function beforeEditName(treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("blog");
        zTree.selectNode(treeNode);
        setTimeout(function () {
            setTimeout(function () {
                zTree.editName(treeNode);
            }, 0);
        }, 0);
        return false;
    }*/

    function beforeRemove(treeId, treeNode) {
        if (treeNode.isParent && treeNode.children.length!==0) {
            alert('存在子节点,不允许删除');
            return;
        }
        if(!confirm("确认删除[" + treeNode.name + "]吗？")){
            return false;
        }
        var zTree = $.fn.zTree.getZTreeObj(treeId);
        zTree.selectNode(treeNode);
        $.post( "/blog/deleteBlog", {treeNode: JSON.stringify(treeNode)}, function(data) {
            if(data) {
                alert("Delete Succeed");
                return true;
            }else{
                alert("Delete Failed");
                return false;
            }
        });
    }

    /*function beforeRename(treeId, treeNode, newName, isCancel) {
        var zTree = $.fn.zTree.getZTreeObj("blog");
        if (newName.length == 0) {
            setTimeout(function () {
                zTree.cancelEditName();
                alert("节点名称不能为空.");
            }, 0);
            return false;
        }
        return true;
    }*/

</script>
</body>

</html>
