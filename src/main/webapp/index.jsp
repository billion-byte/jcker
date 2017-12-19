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
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link href="assets/commons/sticky-footer-navbar.css" rel="stylesheet">
    <link href="assets/css/ztree.css" rel="stylesheet"/>
    <style rel="stylesheet">
        .boolean{color:red;}
        .number{color:green;}
        .string{color:green;}
        .key{color:yellow;}
        .null{color:blue;}

    </style>
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
                <a class="nav-link" href="/index.jsp">首页<span class="sr-only">(current)</span></a>
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

<!-- Bootstrap core JavaScript -->
<script src="assets/popper/popper.js"></script>
<script src="assets/jquery/jquery.js"></script>
<script src="assets/js/jquery.ztree.all.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script type='text/javascript'>
        var setting = {
            view: {
                showIcon: false,
                dblClickExpand: false
            },
            async: {
                enable: true,
                contentType: "application/json",
                dataType: "json",
                url: "${basePath}/blog/getPublishedBlog/false/false"
            },
            callback: {
                beforeClick: function(treeId, treeNode) {
                    var zTree = $.fn.zTree.getZTreeObj("category");
                    if (treeNode.isParent) {
                        zTree.expandNode(treeNode);
                        return false;
                    }
                }
            }
        };

        $(function () {
            $.fn.zTree.init($("#category"), setting, null);


            var ws = new WebSocket("ws://" + location.host + "${basePath}/websocket/qqmessage");
            ws.onopen = function () {
                console.log("websocket connected...");
            };
            ws.onmessage = function (event) {
                var message = JSON.parse(event.data);
                $("#message").html(ObjectToHtml(event.data));

                $.getJSON("${basePath}/smartqq/group/" + message.groupId, function (group) {
                    $("#groupinfo").html( group.name + '---'+group.owner);
                });
            };
            ws.onclose = function (event) {
                console.log(event.data);
            };
    });

    function ObjectToHtml(data) {
        // 若传入数值为json，则转换为字符串
        var txt = typeof data === 'string' ? data : JSON.stringify(data);
        // 转换为Object
        try {
            var obj = eval('(' + txt + ')');
        } catch (e) {
            alert('数据源语法错误,JSON格式化失败! 错误信息: ' + e.description, 'err');
            return
        }
        var line = '</br>', // 换行
            indentChar = '&nbsp;&nbsp;&nbsp;&nbsp;'; // 缩进量
        // 获取缩进字符
        var getTab = function (num) {
            for (var i = 0, tab = ''; i < num; i++) {
                tab += indentChar;
            }
            return tab;
        };
        // 检测递归
        var format = function (value, indent /*缩进*/, isLast /*是否数组或者对象最后*/, inArray /*是否在数组中*/) {
            var str = '';
            // 将处理为`[value,value]`，并将进入检测递归
            if (Object.prototype.toString.call(value) === '[object Array]') {
                str += '[';
                value.forEach(function (item, index) {
                    str += format(item, indent, index === (value.length - 1), true);
                });
                str += ']';
                // null，将处理为`<span class="null">null</span>`
            } else if (value === null) {
                str += '<span class="null">null</span>';
                // 对象Object，将处理为`{<span class="key">"key"</span>:value}`，并进入检测递归
            } else if (typeof value === 'object') {
                str += '{' + line + getTab(++indent);
                var keys = Object.keys(value);
                keys.forEach(function (key, index) {
                    str += '<span class="key">' + key + '</span>: ' + format(value[key], indent, index === (keys.length - 1));
                });
                str += '}';
                indent--;
                // true/false，将处理为`<span class="boolen">true/false</span>`
            } else if (typeof value === 'boolean') {
                str += '<span class="boolean">' + value + '</span>';
                // 字符串，将处理为`<span class="string">"string"</span>`
            } else if (typeof value === 'string') {
                str += '<span class="string">' + value + '</span>';
                // 数字Number，将处理为`<span class="number">1</span>`
            } else {
                str += '<span class="number">' + value + '</span>';
            }
            str += (isLast ? '' : ',') + (inArray ? '' : (line + getTab(isLast ? --indent : indent)));
            return str;
        }
        return ('<div class="json">' + format(obj, 0, true) + '</div>');
    }
</script>
</body>

</html>
