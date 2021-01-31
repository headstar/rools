package com.headstartech.rool;

public interface EqualsComparator {

    boolean supportsEquals(Value a, Value b);

    boolean evaluateEquals(Value a, Value b);
}
