package com.headstartech.rool;

public interface EqualsComparator {

    boolean supportsEquals(Object a, Object b);

    boolean evaluateEquals(Object a, Object b);
}
