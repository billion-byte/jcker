package org.jcker.domain;

import javax.persistence.*;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2018-02-23 at 3:16 PM
 *
 * @version 1.0
 */
@Entity
@Table(name = "t_comment")
public class Comment {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "article_id")
    private int articleId;
    private String author;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
