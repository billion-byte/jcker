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
public class Article {
    @Id
    @GeneratedValue
    private int id;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String title;

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

    @Override
    public String toString() {
        return title;
    }
}
