<#include "header.ftl">
<link rel="stylesheet" href="/css/index.css">
<#include "nav.ftl">

<div class="container">
<#if articleList??>
    <#list articleList as article>
        <div class="article">
            <h3><a href="/article/${article.id}">${article.title}</a></h3>
            <p>
                nihaofalsdjfa;ldksfja;ksdfj;alksdjfetlkjhasdkfj<!--more-->
                asdfljasd;flja;sdf
            </p>
            <p class="autor">
                <span class="lm f_l"><a href="/">Alan Turing</a></span>
                <span class="dtime f_l">${article.createDate!'2016-06-02'}</span>
                <span class="viewnum f_r">浏览（<a href="#">${article.viewNum!'459'}</a>）</span>
                <span class="pingl f_r">评论（<a
                        href="/article/${article.id}#comments">${article.commentNum!'31'}</a>）</span>
            </p>
            <hr>
        </div>
    </#list>
<#else >
    <h1>There is no articles right.</h1>
</#if>
    <ul class="pagination" id="pagination"></ul>
</div>

<#include "footer.ftl">
