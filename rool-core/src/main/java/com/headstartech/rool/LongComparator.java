package com.headstartech.rool;

public class LongComparator implements LessThanComparator, EqualsComparator {

    @Override
    public boolean evaluateLessThan(Object a, Object b) {
        return ((Long) a) < ((Long) b);
    }

    @Override
    public boolean evaluateEquals(Object a, Object b) {
        return ((Long) a).equals((Long) b);
    }

    @Override
    public boolean supportsLessThan(Object a, Object b) {
        return supports(a, b);
    }

    @Override
    public boolean supportsEquals(Object a, Object b) {
        return supports(a, b);
    }

    protected boolean supports(Object a, Object b) {
        return a instanceof Long && b instanceof Long;
    }
}
