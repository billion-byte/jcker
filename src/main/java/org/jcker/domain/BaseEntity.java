package org.jcker.domain;

import org.apache.commons.lang3.builder.*;

import java.io.Serializable;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2018-03-03 at 2:00 AM
 *
 * @version 1.0
 */
public class BaseEntity implements Serializable, Cloneable {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
