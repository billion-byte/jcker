<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Markdown Editor</title>

    <!-- Bootstrap core CSS -->
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="../mdeditor/css/mdeditor.css">
    <!-- Custom styles for this template -->
    <style type="text/css">
        #mdeditor {
            margin-top: 100px;
        }
    </style>
</head>

<body>

<div class="container">

    <div class="starter-template">
        <form action="/admin/save_article" method="post">
            <div class="form-group">
                <label>Title</label>
                <input type="text" name="title" value="<#if article??>${article.title!''}<#else ></#if>">
                <input type="submit" value="Save">
                <textarea name="content" id="mdeditor" cols="30" rows="30" class="form-control">
                    <#if article??>${article.content!''}<#else ></#if>
                </textarea>
            </div>
        </form>
    </div>

</div><!-- /.container -->
<script src="/jqurey/jquery.min.js"></script>
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
