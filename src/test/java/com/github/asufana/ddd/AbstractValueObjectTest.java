package com.github.asufana.ddd;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

import com.github.asufana.ddd.annotations.*;

public class AbstractValueObjectTest {
    
    private ValueObject nil, foo, bar, BAR;
    
    @Before
    public void before() {
        nil = new ValueObject(null);
        foo = new ValueObject("foo");
        bar = new ValueObject("bar");
        BAR = new ValueObject("bar");
    }
    
    @Test
    public void testEquals() {
        assertThat(nil.equals(foo), is(false));
        assertThat(foo.equals(bar), is(false));
        assertThat(bar.equals(bar), is(true));
        assertThat(bar.equals(BAR), is(true));
    }
    
    @Test
    public void testToString() throws Exception {
        
    }
    
    public static class ValueObject extends AbstractValueObject {
        private static final long serialVersionUID = 1L;
        
        @ToString
        private final String value;
        
        public ValueObject(final String value) {
            this.value = value;
        }
        
        public String value() {
            return value;
        }
    }
    
}
