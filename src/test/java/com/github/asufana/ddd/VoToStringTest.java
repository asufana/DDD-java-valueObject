package com.github.asufana.ddd;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

public class VoToStringTest {
    
    @Test
    public void testToString() throws Exception {
        //by toString()
        assertThat(new ValueObject(null).toString(), is(nullValue()));
        assertThat(new ValueObject("foo").toString(), is("foo"));
        
        //by value field
        assertThat(new ValueObjectWithoutToString(null).toString(), is(""));
        assertThat(new ValueObjectWithoutToString("foo").toString(), is("foo"));
        
        //by reflection
        assertThat(new ValueObjectWithoutValueField(null).toString(),
                   is("VoToStringTest.ValueObjectWithoutValueField[data=<null>]"));
        assertThat(new ValueObjectWithoutValueField("foo").toString(),
                   is("VoToStringTest.ValueObjectWithoutValueField[data=foo]"));
    }
    
    public static class ValueObject extends AbstractValueObject {
        private final String value;
        
        public ValueObject(final String value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return value;
        }
    }
    
    public static class ValueObjectWithoutToString extends AbstractValueObject {
        @SuppressWarnings("unused")
        private final String value;
        
        public ValueObjectWithoutToString(final String value) {
            this.value = value;
        }
    }
    
    public static class ValueObjectWithoutValueField extends AbstractValueObject {
        @SuppressWarnings("unused")
        private final String data;
        
        public ValueObjectWithoutValueField(final String data) {
            this.data = data;
        }
    }
    
}
