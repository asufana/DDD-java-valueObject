package com.github.asufana.ddd;

import java.io.*;

import org.apache.commons.lang3.builder.*;

import com.github.asufana.ddd.funtions.*;

public abstract class AbstractValueObject implements Serializable {
    protected static final long serialVersionUID = 1L;
    
    @Override
    public boolean equals(final Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        return EqualsBuilder.reflectionEquals(this, other);
    }
    
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
    
    @Override
    public String toString() {
        return ToStringFunction.toString(this);
    }
    
}
