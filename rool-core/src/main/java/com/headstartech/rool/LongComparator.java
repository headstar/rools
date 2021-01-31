package com.headstartech.rool;

public class LongComparator implements LessThanComparator, EqualsComparator {

    @Override
    public boolean evaluateLessThan(Value a, Value b) {
        return toLong(a) < toLong(b);
    }

    @Override
    public boolean evaluateEquals(Value a, Value b) {
        return toLong(a).equals(toLong(b));
    }

    @Override
    public boolean supportsLessThan(Value a, Value b) {
        return supports(a, b);
    }

    @Override
    public boolean supportsEquals(Value a, Value b) {
        return supports(a, b);
    }

    protected boolean supports(Value a, Value b) {
        return (a instanceof LongLiteralValue)
            || (b instanceof LongLiteralValue);
    }

    protected Long toLong(Value o) {
        return ((LongLiteralValue) o).get();
    }
}
