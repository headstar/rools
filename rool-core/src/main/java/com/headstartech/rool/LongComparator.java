package com.headstartech.rool;

public class LongComparator implements LessThanComparator, EqualsComparator {

    @Override
    public boolean evaluateLessThan(Object a, Object b) {
        return toLong(a) < toLong(b);
    }

    @Override
    public boolean evaluateEquals(Object a, Object b) {
        return toLong(a).equals(toLong(b));
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
        return (a instanceof Long || a instanceof Integer)
                && (b instanceof Long || b instanceof Integer);
    }

    protected Long toLong(Object o) {
        if(o instanceof Long) {
            return (Long) o;
        }
        if(o instanceof Integer) {
            return ((Integer) o).longValue();
        }
        throw new IllegalStateException("Expected Long or Integer");
    }
}
