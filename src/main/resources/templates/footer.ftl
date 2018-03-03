<footer id="footer" class="footer">
    <div>
        <hr>
        <div class="tooter-social" STYLE="text-align: center">
            <a class="social rss" target="blank" href="/feed">RSS</a>&nbsp;&nbsp;&nbsp;
            <a class="social zhihu" target="blank" href="https://www.zhihu.com/people/ZHIHU">知乎</a>&nbsp;&nbsp;
            <a class="social github" target="blank" href="https://github.com/jckerorg">Github</a>&nbsp;&nbsp;
            <a class="social twitter" target="blank" href="https://twitter.com/helloalanturing">Twitter</a>&nbsp;&nbsp;
            <a class="social csdn" target="blank" href="http://blog.csdn.net/u012137018">CSDN</a>
        </div>
        <hr>
        <div class="container">
            <div class="row">
                <div class="col-md-4 hidden-sm-down">
                    <div><a href="/" target="_blank"><img class="img-fluid" src="../images/logo.png"></a></div>
                    <div>
                        <p>内心强大到混蛋,让优秀成为一种习惯</p>
                    </div>
                    <p style="margin-bottom: 0;">Powered by <a href="https://www.github.com/jckerorg">JCKER</a></p>
                    <p style="margin-bottom: 0;">Copyright 2016 <a href="https://www.github.com/jckerorg">JCKER.ORG</a>
                    </p>
                </div>
                <div class="col-md-4 hidden-sm-down">
                    <label>友情链接</label>
                    <ul id="friend_links" class="list-group" style="list-style: none;">
                    <#if friendLinkList??>
                        <#list friendLinkList as friendLink>
                            <li id="${friendLink.id}"><a href="${friendLink.link}">${friendLink.name}</a></li>
                        </#list>
                    <#else >
                    </#if>
                    </ul>
                </div>
                <div class="col-md-4 hidden-sm-down">
                    欢迎关注微信公众号：
                    <img class="img-fluid" src="/images/wechat_qrcode.jpg" style="width: 155px;height: 155px;">
                </div>
            </div>
        </div>
    </div>
</footer>

<script src="/js/jquery.min.js"></script>
<script src="/highlight/js/highlight.pack.js"></script>
<script src="/js/tether.min.js"></script>
<script src="/js/datatables.min.js"></script>
<script src="https://cdn.jsdelivr.net/gh/jquery-form/form@4.2.2/dist/jquery.form.min.js" integrity="sha384-FzT3vTVGXqf7wRfy8k4BiyzvbNfeYjK+frTVqZeNDFl8woCbF0CYG6g2fMEFFo/i" crossorigin="anonymous"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.twbsPagination.min.js"></script>
<script src="/js/jcker.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-tagsinput/1.3.6/jquery.tagsinput.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/additional-methods.min.js"></script>
<script>
    hljs.initHighlightingOnLoad();


    $(function () {
    <#if pageObject??>
        $('#pagination').twbsPagination({
            startPage: ${pageObject.number},
            totalPages: ${pageObject.totalPages},
            visiblePages: 3,
            initiateStartPageClick: false,
            onPageClick: function (event, page) {
                window.location.href="/page/"+page;
            }

        });
    <#else >
        $('#menu_table').DataTable({
            ajax: "/admin/menuList",
            serverSide: true,
            processing: true,
            columns: [
                {data: "id"},
                {data: "name"},
                {data: "link"}
            ]
        });
    </#if>

        $.validator.setDefaults({
            submitHandler: function () {
                alert("submitted!");
            }
        });

        $("#comment_form").validate({
            rules: {
                author: {
                    required: true,
                    minlength: 2
                },
                email: {
                    required: true,
                    email: true
                },
                link: {
                    required: false,
                    url: true
                },
                content: {
                    required: true,
                    minlength: 5,
                    maxlength: 200
                }
            },
            messages: {
                author: {
                    required: "Please enter a username",
                    minlength: "Your username must consist of at least 2 characters"
                },
                email: "Please enter a valid email address",
                link: "Please enter a valid url",
                content: {
                    required: "Please enter your message",
                    minlength: "at least 5 characters",
                    maxlength: "at most 2000 characters"
                }
            },
            errorElement: "em",
            errorPlacement: function (error, element) {
                // Add the `help-block` class to the error element
                error.addClass("help-block");

                if (element.prop("type") === "checkbox") {
                    error.insertAfter(element.parent("label"));
                } else {
                    error.insertAfter(element);
                }
            },
            highlight: function (element, errorClass, validClass) {
                $(element).parents(".col-sm-5").addClass("has-error").removeClass("has-success");
            },
            unhighlight: function (element, errorClass, validClass) {
                $(element).parents(".col-sm-5").addClass("has-success").removeClass("has-error");
            }
        });
    });


</script>
