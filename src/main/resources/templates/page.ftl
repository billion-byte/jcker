<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="">

    <title>${article.title}</title>

    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,400italic" rel="stylesheet">

    <link href="../jcker/css/toolkit-light.css" rel="stylesheet">
    <link href="../jcker/css/docs.css" rel="stylesheet">
    <link href="../jcker/css/application.css" rel="stylesheet">
    <link rel="stylesheet"
          href="../highlight/css/xcode.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script src="../highlight/js/highlight.pack.js"></script>

    <script>hljs.initHighlightingOnLoad();</script>
    <style>
        body {
            width: 1px;
            min-width: 100%;
        }

    </style>
</head>


<body>

<#include "common/header.ftl">

<div class="bw docs-content">
    <h1>${article.title}</h1>

${article.content}

    <a class="docs-top" style="display: none" href="#">回到顶部</a>
</div>

<#include "common/footer.ftl">
<script>
    // execute/clear BS loaders for docs
    $(function () {
        while (window.BS && window.BS.loader && window.BS.loader.length) {
            (window.BS.loader.pop())()
        }
    })
</script>
</body>
</html>

