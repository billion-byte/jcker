<#include "header.ftl">
<link rel="stylesheet" href="/css/index.css">
<link rel="stylesheet" href="/css/simplePagination.css">
<#include "nav.ftl">

<div class="container" style="margin: 0 auto; max-width: 700px;">
<#if pageObject??>
    <#list pageObject.content as article>
        <div class="article" id="article_${article.id}">
            <h3><a href="/article/${article.id}">${article.title}</a></h3>
            <p class="autor">
                <span class="" style="font-size: 12px;"><a href="/">Alan Turing</a></span>
                <span class="" style="font-size: 12px;">${article.createDate!'2016-06-02'}</span>
                <span class="" style="font-size: 12px;">浏览（<a href="#">${article.viewNum!'459'}</a>）</span>
                <span class="" style="font-size: 12px;">评论（<a
                        href="/article/${article.id}#comments">${article.commentNum!'31'}</a>）</span>
            </p>
        </div>
    </#list>
<#else >
</#if>
    <ul class="pagination-sm" id="pagination"></ul>
</div>

<#include "footer.ftl">
