<#include "header.ftl">
<link rel="stylesheet" href="/css/index.css">
<link rel="stylesheet" href="/css/simplePagination.css">
<#include "nav.ftl">

<div class="container" style="margin: 0 auto; max-width: 700px;">
<#if articleList??>
    <#list articleList as article>
    <div style="margin: 0 auto; max-width: 700px;">
        <div class="col-md-12" id="article_${article.id}" style="box-shadow: 0 1px 4px rgba(0, 0, 0, 0.4)">
            <h3><a href="/article/${article.id}">${article.title}</a></h3>
            <p class="autor">
                <span class="lm f_l"><a href="/">Alan Turing</a></span>
                <span class="dtime f_l">${article.createDate!'2016-06-02'}</span>
                <span class="viewnum f_r">浏览（<a href="#">${article.viewNum!'459'}</a>）</span>
                <span class="pingl f_r">评论（<a
                        href="/article/${article.id}#comments">${article.commentNum!'31'}</a>）</span>
            </p>
            <hr>
        </div>
    </div>
    </#list>
<#else >
    <h1>There is no articles right now.</h1>
</#if>
    <ul class="pagination pagination-sm" id="pagination"></ul>
</div>

<#include "footer.ftl">
