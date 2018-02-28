<footer id="footer" class="footer">
    <div>
        <hr>
        <div class="tooter-social" STYLE="text-align: center">
            <a class="social rss" target="blank" href="/feed">RSS</a>&nbsp;&nbsp;&nbsp;
            <a class="social zhihu" target="blank" href="https://www.zhihu.com/people/ZHIHU">知乎</a>&nbsp;&nbsp;
            <a class="social github" target="blank" href="https://github.com/jckerorg">Github</a>&nbsp;&nbsp;
            <a class="social twitter" target="blank" href="https://twitter.com/mrblabla2013">Twitter</a>
        </div>
        <hr>
        <div class="container">
            <div class="row">
            <div class="col-md-4 hidden-sm-down">
                <div ><a href="#" target="_blank"><img class="img-fluid" src="../images/logo.png"></a></div>
                <div >
                    <p>内心强大到混蛋,让优秀成为一种习惯</p>
                </div>
                <p >Powered by <a href="https://www.github.com/jckerorg">JCKER</a></p>
                <p >Copyright 2016 <a href="https://www.github.com/jckerorg">JCKER.ORG</a></p>
            </div>
            <div class="col-md-4 ">
                <#if recent_articles??>
                    <label>最新文章</label>
                    <ul id="recent_articles" class="list-group" style="list-style: none;">
                    <#list recent_articles as article>
                        <li id="${article.id}"><a href="/article/${article.id}">${article.title}</a> </li>
                    </#list>
                    </ul>
                <#else>
                    <label>友情链接</label>
                    <ul id="friend_links" class="list-group" style="list-style: none;">
                    <#if friendLinkList??>
                        <#list friendLinkList as friendLink>
                            <li id="${friendLink.id}"><a href="${friendLink.link}">${friendLink.name}</a> </li>
                        </#list>
                    <#else >
                    </#if>
                    </ul>
                </#if>
            </div>
            <div class="col-md-4 hidden-sm-down">
                欢迎关注微信公众号：
                <img class="img-fluid" src="/images/wechat_qrcode.jpg" style="width: 155px;height: 155px;">
            </div>
        </div>
        </div>
    </div>
</footer>

<script src="/js/jquery.min.js"></script>
<script src="/highlight/js/highlight.pack.js"></script>
<script src="/js/tether.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script>
    hljs.initHighlightingOnLoad();
</script>
</body>
</html>