package com.headstartech.rools.predicates;

import com.headstartech.rools.Value;
import com.headstartech.rools.values.LongLiteralValue;

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
        return (a instanceof LongLiteralValue) && (((LongLiteralValue) a).get() != null)
            && (b instanceof LongLiteralValue) && (((LongLiteralValue) b).get() != null);
    }

    protected Long toLong(Value o) {
        return ((LongLiteralValue) o).get();
    }
}
