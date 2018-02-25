package org.jcker.domain;

import javax.persistence.*;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2018-02-23 at 4:34 PM
 *
 * @version 1.0
 */
@Entity
@Table(name = "sys_user")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private String alias;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
