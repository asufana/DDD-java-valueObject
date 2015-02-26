package com.github.asufana.ddd;

import java.math.*;

import javax.persistence.*;

import org.joda.time.*;
import org.junit.*;

public class AbstractValueObjectValidateTest {
    
    //null test
    @Test
    public void testValidateionNullableString01() throws Exception {
        //例外とならないこと
        new StringVo(null);
    }
    
    //null test
    @Test
    public void testValidateionNullableString02() throws Exception {
        //例外とならないこと
        new StringVo("");
    }
    
    static class StringVo extends AbstractValueObject {
        private static final long serialVersionUID = 1L;
        
        @Column
        public final String value;
        
        public StringVo(final String value) {
            this.value = value;
            validate();
        }
    }
    
    //-----------------------------------------
    
    //null test
    @Test(expected = IllegalArgumentException.class)
    public void testValidateionNullableString03() throws Exception {
        //例外となること
        new StringVoWithColumnAttr(null);
    }
    
    //null test
    @Test(expected = IllegalArgumentException.class)
    public void testValidateionNullableString04() throws Exception {
        //例外となること
        new StringVoWithColumnAttr("");
    }
    
    //length test
    @Test(expected = IllegalArgumentException.class)
    public void testValidateionLength() throws Exception {
        //例外となること
        new StringVoWithColumnAttr("aaaaaaaaaaaaa");
    }
    
    static class StringVoWithColumnAttr extends AbstractValueObject {
        private static final long serialVersionUID = 1L;
        
        @Column(nullable = false, length = 4)
        public final String value;
        
        public StringVoWithColumnAttr(final String value) {
            this.value = value;
            validate();
        }
    }
    
    //-----------------------------------------
    
    //null test
    @Test
    public void testValidateionNullableInteger01() throws Exception {
        //例外とならないこと
        new IntegerVo(null);
    }
    
    static class IntegerVo extends AbstractValueObject {
        private static final long serialVersionUID = 1L;
        
        @Column
        public final Integer value;
        
        public IntegerVo(final Integer value) {
            this.value = value;
            validate();
        }
    }
    
    //-----------------------------------------
    
    //null test
    @Test(expected = IllegalArgumentException.class)
    public void testValidateionNullableInteger02() throws Exception {
        //例外となること
        new IntegerVoWithColumnAttr(null);
    }
    
    static class IntegerVoWithColumnAttr extends AbstractValueObject {
        private static final long serialVersionUID = 1L;
        
        @Column(nullable = false)
        public final Integer value;
        
        public IntegerVoWithColumnAttr(final Integer value) {
            this.value = value;
            validate();
        }
    }
    
    //-----------------------------------------
    
    //null test
    @Test
    public void testValidateionNullableLong01() throws Exception {
        //例外とならないこと
        new LongVo(null);
    }
    
    static class LongVo extends AbstractValueObject {
        private static final long serialVersionUID = 1L;
        
        @Column
        public final Long value;
        
        public LongVo(final Long value) {
            this.value = value;
            validate();
        }
    }
    
    //-----------------------------------------
    
    //null test
    @Test(expected = IllegalArgumentException.class)
    public void testValidateionNullableLong02() throws Exception {
        //例外となること
        new LongVoWithColumnAttr(null);
    }
    
    static class LongVoWithColumnAttr extends AbstractValueObject {
        private static final long serialVersionUID = 1L;
        
        @Column(nullable = false)
        public final Long value;
        
        public LongVoWithColumnAttr(final Long value) {
            this.value = value;
            validate();
        }
    }
    
    //-----------------------------------------
    
    //null test
    @Test
    public void testValidateionNullableBigDecimal01() throws Exception {
        //例外とならないこと
        new BigDecimalVo(null);
    }
    
    static class BigDecimalVo extends AbstractValueObject {
        private static final long serialVersionUID = 1L;
        
        @Column
        public final BigDecimal value;
        
        public BigDecimalVo(final BigDecimal value) {
            this.value = value;
            validate();
        }
    }
    
    //-----------------------------------------
    
    //null test
    @Test(expected = IllegalArgumentException.class)
    public void testValidateionNullableBigDecimal02() throws Exception {
        //例外となること
        new BigDecimalVoWithColumnAttr(null);
    }
    
    static class BigDecimalVoWithColumnAttr extends AbstractValueObject {
        private static final long serialVersionUID = 1L;
        
        @Column(nullable = false)
        public final BigDecimal value;
        
        public BigDecimalVoWithColumnAttr(final BigDecimal value) {
            this.value = value;
            validate();
        }
    }
    
    //-----------------------------------------
    
    //null test
    @Test
    public void testValidateionNullableDateTime01() throws Exception {
        //例外とならないこと
        new DateTimeVo(null);
    }
    
    static class DateTimeVo extends AbstractValueObject {
        private static final long serialVersionUID = 1L;
        
        @Column
        public final DateTime value;
        
        public DateTimeVo(final DateTime value) {
            this.value = value;
            validate();
        }
    }
    
    //-----------------------------------------
    
    //null test
    @Test(expected = IllegalArgumentException.class)
    public void testValidateionNullableDateTime02() throws Exception {
        //例外となること
        new DateTimeVoWithColumnAttr(null);
    }
    
    static class DateTimeVoWithColumnAttr extends AbstractValueObject {
        private static final long serialVersionUID = 1L;
        
        @Column(nullable = false)
        public final DateTime value;
        
        public DateTimeVoWithColumnAttr(final DateTime value) {
            this.value = value;
            validate();
        }
    }
    
    //-----------------------------------------
    
    //null test
    @Test
    public void testValidateionNullableBoolean01() throws Exception {
        //例外とならないこと
        new BooleanVo(null);
    }
    
    static class BooleanVo extends AbstractValueObject {
        private static final long serialVersionUID = 1L;
        
        @Column
        public final Boolean value;
        
        public BooleanVo(final Boolean value) {
            this.value = value;
            validate();
        }
    }
    
    //-----------------------------------------
    
    //null test
    @Test(expected = IllegalArgumentException.class)
    public void testValidateionNullableBoolean02() throws Exception {
        //例外となること
        new BooleanVoWithColumnAttr(null);
    }
    
    static class BooleanVoWithColumnAttr extends AbstractValueObject {
        private static final long serialVersionUID = 1L;
        
        @Column(nullable = false)
        public final Boolean value;
        
        public BooleanVoWithColumnAttr(final Boolean value) {
            this.value = value;
            validate();
        }
    }
}
