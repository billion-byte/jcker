package org.jcker.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2018-02-25 at 9:37 PM
 *
 * @version 1.0
 */
@Entity
@Table(name = "sys_menu")
public class Menu {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
