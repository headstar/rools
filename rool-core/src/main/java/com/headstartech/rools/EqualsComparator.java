package com.headstartech.rools;

public interface EqualsComparator {

    boolean supportsEquals(Value a, Value b);

    boolean evaluateEquals(Value a, Value b);
}
