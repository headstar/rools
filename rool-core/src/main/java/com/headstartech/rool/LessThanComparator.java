package com.headstartech.rool;

public interface LessThanComparator {

    boolean supportsLessThan(Object a, Object b);

    boolean evaluateLessThan(Object a, Object b);
}
