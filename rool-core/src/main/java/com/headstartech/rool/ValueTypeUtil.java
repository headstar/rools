package com.headstartech.rool;

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
