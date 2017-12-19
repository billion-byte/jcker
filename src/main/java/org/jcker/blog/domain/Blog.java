package org.jcker.blog.domain;

import org.jcker.utils.BaseEntity;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2017-10-09 at 11:56 PM
 *
 * @version 1.0
 */
public class Blog extends BaseEntity {
    private String date;
    private String name;
    private String category;
    private String valid;
    private String personal;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }
}
