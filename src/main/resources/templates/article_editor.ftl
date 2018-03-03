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
            <input type="text" name="category" value="" placeholder="标题Topic">
            <input type="text" name="tags" id="tags" value="" placeholder="标签">
            <input type="submit" value="Save">
            <textarea name="content" id="mdeditor" cols="30" rows="30"
                      class="form-control" placeholder="请开始你的表演"></textarea>
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
    $(function () {
        var cities = new Bloodhound({
            datumTokenizer: Bloodhound.tokenizers.obj.whitespace('text'),
            queryTokenizer: Bloodhound.tokenizers.whitespace,
            prefetch: 'assets/cities.json'
        });
        cities.initialize();
        var elt = $("#tags");
        elt.tagsinput({
            tagClass: function(item) {
                switch (item.continent) {
                    case 'Europe'   : return 'label label-primary';
                    case 'America'  : return 'label label-danger label-important';
                    case 'Australia': return 'label label-success';
                    case 'Africa'   : return 'label label-default';
                    case 'Asia'     : return 'label label-warning';
                }
            },
            itemValue: 'value',
            itemText: 'text',
            typeaheadjs: {
                name: 'cities',
                displayKey: 'text',
                source: cities.ttAdapter()
            }
        });
        elt.tagsinput('add', { "value": 1 , "text": "Amsterdam"   , "continent": "Europe"    });
        elt.tagsinput('add', { "value": 4 , "text": "Washington"  , "continent": "America"   });
        elt.tagsinput('add', { "value": 7 , "text": "Sydney"      , "continent": "Australia" });
        elt.tagsinput('add', { "value": 10, "text": "Beijing"     , "continent": "Asia"      });
        elt.tagsinput('add', { "value": 13, "text": "Cairo"       , "continent": "Africa"    });
    });
</script>
</body>
</html>
