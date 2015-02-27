package com.github.asufana.ddd;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

public class VoEqualsTest {
    
    @Test
    public void testEquals() {
        //nullと値の評価
        assertThat(new ValueObject(null).equals(new ValueObject("foo")),
                   is(false));
        //異なる値の評価
        assertThat(new ValueObject("foo").equals(new ValueObject("bar")),
                   is(false));
        //同じ値の評価
        assertThat(new ValueObject("bar").equals(new ValueObject("bar")),
                   is(true));
    }
    
    public static class ValueObject extends AbstractValueObject {
        @SuppressWarnings("unused")
        private final String value;
        
        public ValueObject(final String value) {
            this.value = value;
        }
    }
    
}
