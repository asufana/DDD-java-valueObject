package com.github.asufana.ddd.functions;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;

import com.github.asufana.ddd.*;

public class ReflectionUtil {
    
    // get "value" field
    public static <T extends AbstractValueObject> Field getValueField(final T vo) {
        return getFields(vo).stream()
                            .filter(field -> field.getName().equals("value"))
                            .findAny()
                            .orElse(null);
    }
    
    public static <T extends AbstractValueObject> List<AbstractValueObject> getValueObjects(final T vo) {
        return getFields(vo).stream()
                            .map(field -> {
                                field.setAccessible(true);
                                try {
                                    if (field.get(vo) instanceof AbstractValueObject) {
                                        return (AbstractValueObject) field.get(vo);
                                    }
                                }
                                catch (final Exception e) {}
                                return null;
                            })
                            .filter(valueObject -> valueObject != null)
                            .collect(Collectors.toList());
    }
    
    private static <T extends AbstractValueObject> List<Field> getFields(final T vo) {
        return Arrays.asList(vo.getClass().getDeclaredFields());
    }
}
