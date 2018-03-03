<div class="comment-pannel" style="margin: 0 auto; max-width: 700px;">
    <form id="comment_form" action="/add_comment" method="post">
        <input type="hidden" name="articleId" value="${article.id}">
        <div class="row">
            <div class="col-md-4"><input type="text" name="author" value="" placeholder="姓名(*)"></div>
            <div class="col-md-4"><input type="text" name="email" value="" placeholder="邮箱(*)"></div>
            <div class="col-md-4"><input type="text" name="link" value="" placeholder="网址(http://)"></div>
        </div>
        <div class="row" style="margin: 0 auto; max-width: 700px;">
            <div>
                <textarea name="content" cols="100" placeholder="给大佬留言(*)" minlength="5" maxlength="2000"
                          style=""></textarea>
                <input type="button" class="btn btn-outline-primary btn-sm" value="提交" onclick="commit_comment();"
                       style="float: right;">
            </div>
        </div>
    </form>

<#list commentList as comment>
    <div class="comment" id="comment_${comment.id}">
        <div>
            <img class="figure-img" src="/images/ico_07_1.jpg">
            <a class="comment-author" href="${comment.link!'#'}">${comment.author}</a>
            <small class="comment-date">${comment.createDate}</small>
        </div>
        <div><p class="comment-content">${comment.content}</p></div>
    </div>
    <hr style="border-top-style: dashed">
</#list>
</div>


