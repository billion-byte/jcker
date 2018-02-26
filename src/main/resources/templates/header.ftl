<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="">

    <title>
    <#if article??>${article.title}<#else>Jcker</#if>
    </title>

    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,400italic" rel="stylesheet">
    <link rel="stylesheet" href="/highlight/css/xcode.css">
    <link rel="stylesheet" href="/css/page.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script src="/highlight/js/highlight.pack.js"></script>

    <script>hljs.initHighlightingOnLoad();</script>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light rounded">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample10" aria-controls="navbarsExample10" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-md-center" id="navbarsExample10">
        <ul class="navbar-nav">
            <#if menuList??>
                <#list menuList as menu>
                    <li class="nav-item">
                        <a class="nav-link" href="${menu.link}">${menu.name}</a>
                    </li>
                </#list>
            <#else>
                <li class="nav-item active">
                    <a class="nav-link" href="/">首页</a>
                </li>
            </#if>
        </ul>
    </div>
</nav>