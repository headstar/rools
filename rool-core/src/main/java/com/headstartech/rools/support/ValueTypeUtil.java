package com.headstartech.rools.support;

import com.headstartech.rools.InvalidTypeException;
import com.headstartech.rools.Value;

public class ValueTypeUtil {

    private ValueTypeUtil() {}

    public static <T> T to(Value value, Class<T> clazz) {
        if(clazz.isAssignableFrom(value.getClass())) {
            return clazz.cast(value);
        } else {
            throw new InvalidTypeException(String.format("Expected %s but got %s", clazz.getName(), value.getClass().getName()));
        }
    }

}
