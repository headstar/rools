package com.headstartech.rool;

public interface LessThanComparator {

    boolean supportsLessThan(Value a, Value b);

    boolean evaluateLessThan(Value a, Value b);
}
