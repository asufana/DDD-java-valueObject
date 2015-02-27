package com.github.asufana.ddd;

import javax.persistence.*;

import org.junit.*;

import com.github.asufana.ddd.annotations.*;

public class VoPatternAnnotationValidateTest {
    
    @Test
    public void testValidate01() throws Exception {
        //例外発生しないこと
        new StringVo("A123");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testValidate02() throws Exception {
        //例外発生すること
        new StringVo("123A");
    }
    
    static class StringVo extends AbstractValueObject {
        
        @Column
        @Pattern(regexp = "^[A-Z][0-9]{3}$")
        public final String value;
        
        public StringVo(final String value) {
            this.value = value;
            validate();
        }
    }
    
}
