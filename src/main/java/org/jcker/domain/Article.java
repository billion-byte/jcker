package org.jcker.domain;

import javax.persistence.*;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2018-02-23 at 3:13 PM
 *
 * @version 1.0
 */
@Entity
@Table(name = "t_article")
public class Article extends BaseEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String title;
    private String url;
    @Column(name = "create_date")
    private String createDate;
    @Column(name = "view_num")
    private int viewNum;
    @Column(name = "comment_num")
    private int commentNum;
    private String category;
    @Transient
    private String preview;

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getViewNum() {
        return viewNum;
    }

    public void setViewNum(int viewNum) {
        this.viewNum = viewNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
