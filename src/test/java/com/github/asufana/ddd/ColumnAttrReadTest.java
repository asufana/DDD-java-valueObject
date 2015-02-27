package com.github.asufana.ddd;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.persistence.*;

import org.junit.*;

import com.github.asufana.ddd.funtions.ColumnAnnotationValidateFunction.FieldInfo;

public class ColumnAttrReadTest {
    
    //@Column read test
    @Test
    public void testStringFields01() throws Exception {
        final FieldInfo field = new StringVo("test").fields().get("value");
        assertThat(field, is(not(nullValue())));
        assertThat(field.length(), is(255));
        assertThat(field.nullable(), is(true));
    }
    
    static class StringVo extends AbstractValueObject {
        @Column
        public final String value;
        
        public StringVo(final String value) {
            this.value = value;
            validate();
        }
    }
    
    //-----------------------------------------
    
    //@Column read test
    @Test
    public void testStringFields02() throws Exception {
        final FieldInfo field = new StringVoWithColumnAttr("test").fields()
                                                                  .get("value");
        assertThat(field, is(not(nullValue())));
        assertThat(field.length(), is(4));
        assertThat(field.nullable(), is(false));
    }
    
    static class StringVoWithColumnAttr extends AbstractValueObject {
        @Column(nullable = false, length = 4)
        public final String value;
        
        public StringVoWithColumnAttr(final String value) {
            this.value = value;
            validate();
        }
    }
    
    //-----------------------------------------
    
    //@Column read test
    @Test
    public void testIntegerFields01() throws Exception {
        final FieldInfo field = new IntegerVo(null).fields().get("value");
        assertThat(field, is(not(nullValue())));
        assertThat(field.length(), is(nullValue()));
        assertThat(field.nullable(), is(true));
    }
    
    static class IntegerVo extends AbstractValueObject {
        @Column
        public final Integer value;
        
        public IntegerVo(final Integer value) {
            this.value = value;
            validate();
        }
    }
    
    //-----------------------------------------
    
    //@Column read test
    @Test
    public void testIntegerFields02() throws Exception {
        final FieldInfo field = new IntegerVoWithColumnAttr(123).fields()
                                                                .get("value");
        assertThat(field, is(not(nullValue())));
        assertThat(field.length(), is(nullValue()));
        assertThat(field.nullable(), is(false));
    }
    
    static class IntegerVoWithColumnAttr extends AbstractValueObject {
        @Column(nullable = false)
        public final Integer value;
        
        public IntegerVoWithColumnAttr(final Integer value) {
            this.value = value;
            validate();
        }
    }
    
}
