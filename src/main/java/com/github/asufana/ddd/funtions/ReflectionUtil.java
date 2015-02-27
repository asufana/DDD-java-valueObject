package com.github.asufana.ddd.funtions;

import java.lang.reflect.*;
import java.util.*;

import com.github.asufana.ddd.*;

public class ReflectionUtil {
    
    static <T extends AbstractValueObject> Field getValueField(final T object) {
        return Arrays.asList(object.getClass().getDeclaredFields())
                     .stream()
                     .filter(field -> field.getName().equals("value"))
                     .findAny()
                     .orElse(null);
    }
}
