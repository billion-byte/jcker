<!DOCTYPE html>
<html lang="en">
<#include "header.ftl">
<body>
<#include "nav.ftl">
<div class="container" style="margin: 0 auto; max-width: 700px;">
    <div class="page page-content" style="margin: 0 auto; max-width: 700px;">
        <h1>
            <a href="/article/${article.id}">${article.title}</a>
            <small><a href="/category/${article.category}">&nbsp;&nbsp;#${article.category}</a></small>
        </h1>
        <hr style="border-top-style: dashed;">
    ${article.content}
    </div>
    <hr>
    <#include "comment.ftl">
</div>
<#include "footer.ftl">
</body>
</html>