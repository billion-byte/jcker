
<div class="comments" style="margin: 0 auto; max-width: 700px;">
    <form action="/add_comment" method="post">
        <div class="row" style="margin: 0 auto; max-width: 700px;">
                <div class="col-md-4"><input type="text" value="" required placeholder="姓名(*)"></div>
                <div class="col-md-4"><input type="text" value="" required placeholder="邮箱(*)"></div>
                <div class="col-md-4"><input type="text" value="" placeholder="网址"></div>
        </div>
        <div class="row" style="margin: 0 auto; max-width: 700px;">
            <div>
                <textarea name="comment_content" cols="100" placeholder="给大佬留言" required minlength="5" maxlength="2000" style=""></textarea>
                <input type="submit" value="提交" style="float: right;">
            </div>
        </div>
    </form>

<#list commentList as comment>
        <div class="comment" id="comment_${comment.id}" style="box-shadow: 0 1px 4px rgba(0, 0, 0, 0.4);">
            <div>${comment.author}</div>
            <div>${comment.content}</div>
            <div>${comment.createDate}</div>
        </div>
    </#list>
</div>


