package com.github.asufana.ddd.funtions;

import java.lang.reflect.*;
import java.util.*;

import org.apache.commons.lang3.builder.*;

public abstract class ToStringFunction {
    
    public static String toString(final Object vo) {
        final Optional<Field> valueField = getValueField(vo);
        return valueField.isPresent()
                ? toStringByValueField(vo, valueField.get())
                : toStringByReflection(vo);
    }
    
    /** valueフィールド値を返却 */
    private static String toStringByValueField(final Object vo,
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
    private static String toStringByReflection(final Object vo) {
        return ReflectionToStringBuilder.toString(vo,
                                                  ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
    /** valueフィールドがあるかどうか */
    private static Optional<Field> getValueField(final Object object) {
        return Arrays.asList(object.getClass().getDeclaredFields())
                     .stream()
                     .filter(field -> field.getName().equals("value"))
                     .findAny();
    }
}
