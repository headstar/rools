package com.headstartech.rools.predicates;

import com.headstartech.rools.Value;
import com.headstartech.rools.values.StringLiteralValue;

public class StringComparator implements LessThanComparator, EqualsComparator {

    @Override
    public boolean evaluateLessThan(Value a, Value b) {
        return toString(a).compareTo(toString(b)) < 0;
    }

    @Override
    public boolean evaluateEquals(Value a, Value b) {
        return toString(a).equals(toString(b));
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
        return (a instanceof StringLiteralValue) && ((StringLiteralValue) a).get() != null
                && (b instanceof StringLiteralValue) && ((StringLiteralValue) b).get() != null;
    }

    protected String toString(Value o) {
        return ((StringLiteralValue) o).get();
    }
}
