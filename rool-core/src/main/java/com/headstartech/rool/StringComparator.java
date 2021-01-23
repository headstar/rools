package com.headstartech.rool;

public class StringComparator implements LessThanComparator, EqualsComparator {

    @Override
    public boolean evaluateLessThan(Object a, Object b) {
        return ((String) a).compareTo((String) b) < 0;
    }

    @Override
    public boolean evaluateEquals(Object a, Object b) {
        return ((String) a).compareTo((String) b) == 0;
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
        return a instanceof String && b instanceof String;
    }
}
