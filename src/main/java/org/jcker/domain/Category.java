package org.jcker.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2018-03-03 at 2:54 AM
 *
 * @version 1.0
 */
@Entity
@Table(name = "t_category")
public class Category extends BaseEntity {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
