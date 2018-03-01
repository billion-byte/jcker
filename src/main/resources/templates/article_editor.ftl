<#include "header.ftl">
<link rel="stylesheet" href="/mdeditor/css/mdeditor.css">
<!-- Custom styles for this template -->
<style type="text/css">
    #mdeditor {
        margin-top: 100px;
    }
</style>
</head>

<body>

<div class="container">


    <form action="/admin/save_article" method="post">
        <div>
            <label>Title</label>
        <#if article??>
            <input type="hidden" name="id" value="${article.id}">
            <input type="text" name="title" value="${article.title}">
            <input type="submit" value="Save">
            <textarea name="content" id="mdeditor" cols="30" rows="30"
                      class="form-control">${article.content}</textarea>
        <#else >
            <input type="text" name="title" value="" placeholder="标题Topic">
            <input type="submit" value="Save">
            <textarea name="content" id="mdeditor" cols="30" rows="30"
                      class="form-control">请开始你的表演</textarea>
        </#if>
        </div>
    </form>

</div>
<script src="/js/jquery.min.js"></script>
<script src="/mdeditor/js/mdeditor.min.js"></script>
<script>
    var md = new MdEditor('#mdeditor', {
        status: false,
        toolbar: false,
        uploader: 'http://local.dev/Lab/MdEditor/app/upload.php',
        preview: true,
        images: [
            {id: '1.jpg', url: 'http://lorempicsum.com/futurama/200/200/1'},
            {id: '1.jpg', url: 'http://lorempicsum.com/futurama/200/200/2'},
            {id: '1.jpg', url: 'http://lorempicsum.com/futurama/200/200/3'},
            {id: '1.jpg', url: 'http://lorempicsum.com/futurama/200/200/4'}
        ]
    });
</script>
</body>
</html>
