<#include "header.ftl">

<div class="container">
    <div class="page">
        <h1><a href="/article/${article.id}">${article.title}</a></h1>
        ${article.content}
        <a class="docs-top" style="display: none" href="#">回到顶部</a>
    </div>
</div>

<#include "footer.ftl">
