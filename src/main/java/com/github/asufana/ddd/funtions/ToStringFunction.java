package com.github.asufana.ddd.funtions;

import java.lang.reflect.*;
import java.util.*;

import org.apache.commons.lang3.builder.*;

import com.github.asufana.ddd.*;

public abstract class ToStringFunction {
    
    public static <T extends AbstractValueObject> String toString(final T vo) {
        final Optional<Field> valueField = getValueField(vo);
        return valueField.isPresent()
                ? toStringByValueField(vo, valueField.get())
                : toStringByReflection(vo);
    }
    
    /** valueフィールド値を返却 */
    private static <T extends AbstractValueObject> String toStringByValueField(final T vo,
                                                                               final Field field) {
        try {
            field.setAccessible(true);
            final Object object = field.get(vo);
            return object != null
                    ? (String) object
                    : "";
        }
        catch (IllegalArgumentException | IllegalAccessException e) {
            return "";
        }
    }
    
    /** リフレクションでフィールド値を返却 */
    private static <T extends AbstractValueObject> String toStringByReflection(final T vo) {
        return ReflectionToStringBuilder.toString(vo,
                                                  ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
    /** valueフィールドがあるかどうか */
    private static <T extends AbstractValueObject> Optional<Field> getValueField(final T object) {
        return Arrays.asList(object.getClass().getDeclaredFields())
                     .stream()
                     .filter(field -> field.getName().equals("value"))
                     .findAny();
    }
}
