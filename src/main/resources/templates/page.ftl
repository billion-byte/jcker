<#include "header.ftl">
<link rel="stylesheet" href="/css/page.css">
<link rel="stylesheet" href="/css/comment.css">
<link rel="stylesheet" href="/highlight/css/xcode.css">

<#include "nav.ftl">

    <div class="page page-content" style="margin: 0 auto; max-width: 700px;">
        <h1><a href="/article/${article.id}">${article.title}</a></h1>
        <hr>
    ${article.content}
    </div>
    <hr>
    <#include "comment.ftl">
</div>

<#include "footer.ftl">
