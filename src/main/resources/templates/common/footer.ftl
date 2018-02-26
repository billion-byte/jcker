<footer id="footer" class="footer">
    <div class="container">
        <hr>
        <div class="tooter-social" STYLE="text-align: center">
            <a class="social rss" target="blank" href="/feed">RSS</a>&nbsp;&nbsp;&nbsp;
            <a class="social zhihu" target="blank" href="https://www.zhihu.com/people/ZHIHU">知乎</a>&nbsp;&nbsp;
            <a class="social github" target="blank" href="https://github.com/jckerorg">Github</a>&nbsp;&nbsp;
            <a class="social twitter" target="blank" href="https://twitter.com/mrblabla2013">Twitter</a>
        </div>
        <hr>
        <div class="row">
            <div class="col-sm-4">
                <div class="ftlogo"><a href="#" target="_blank"><img src="../images/logo.png"></a></div>
                <div class="ft-title">
                    <p>内心强大到混蛋,让优秀成为一种习惯</p>
                </div>
                <p class="ft-copyright">Powered by <a href="https://www.github.com/jckerorg">JCKER</a></p>
                <p class="ft-copyright">Copyright 2016 <a href="https://www.github.com/jckerorg">JCKER.ORG</a></p>
            </div>
            <div class="col-sm-4">

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
                        <#list friendLinkList as friendLink>
                            <li id="${friendLink.id}"><a href="${friendLink.link}">${friendLink.name}</a> </li>
                        </#list>
                    </ul>
                </#if>

            </div>
            <div class="col-sm-4">
                欢迎关注微信公众号：
                <img src="../images/wechat_qrcode.jpg" style="width: 155px;height: 155px;">
            </div>
        </div>


    </div>
    <div id="tbox"><a id="togbook" href="/"></a> <a id="gotop" href="javascript:void(0)"></a></div>


    <#--<script src="../jquery/jquery.min.js"></script>-->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</footer>
</body>
</html>