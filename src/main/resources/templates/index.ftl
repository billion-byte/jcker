<#include "common/header.ftl">
<div class="container">
    <article>
        <#if articleList??>
            <#list articleList as article>
            <div class="blogs">
                <h3><a href="/article/${article.id}">${article.title}</a></h3>
                <p>
                    nihaofalsdjfa;ldksfja;ksdfj;alksdjfetlkjhasdkfj<!--more-->
                    asdfljasd;flja;sdf
                    asdf;kjotiadf;alsdfkj
                    sdf;kjetiapdkfj
                </p>
                <p class="autor">
                    <span class="lm f_l"><a href="/">Alan Turing</a></span>
                    <span class="dtime f_l">${article.createDate!'2016-06-02'}</span>
                    <span class="viewnum f_r">浏览（<a href="#">${article.viewNum!'459'}</a>）</span>
                    <span class="pingl f_r">评论（<a href="/article/${article.id}#comments">${article.commentNum!'31'}</a>）</span>
                </p>
            </div>
            </#list>
        <#else >
            <h1>There is no articles right.</h1>
        </#if>
    </article>
</div>
<#include "common/footer.ftl">
