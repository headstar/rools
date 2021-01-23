package com.headstartech.rool;


import java.time.OffsetDateTime;

public class OffsetDateTimeComparator implements LessThanComparator, EqualsComparator {

    @Override
    public boolean evaluateLessThan(Object a, Object b) {
        return ((OffsetDateTime) a).compareTo((OffsetDateTime) b) < 0;
    }

    @Override
    public boolean evaluateEquals(Object a, Object b) {
        return ((OffsetDateTime) a).compareTo((OffsetDateTime) b) == 0;
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
        return a instanceof OffsetDateTime && b instanceof OffsetDateTime;
    }
}
