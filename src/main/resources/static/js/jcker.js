function commit_comment(articleId) {

    $('#comment_form').ajaxSubmit(function() {
        $('#comment_form').clearForm();
        location.reload();
    });
}