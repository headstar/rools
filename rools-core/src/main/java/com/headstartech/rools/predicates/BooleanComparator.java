package com.headstartech.rools.predicates;

import com.headstartech.rools.Value;
import com.headstartech.rools.values.BooleanLiteralValue;
import com.headstartech.rools.values.LongLiteralValue;

public class BooleanComparator implements EqualsComparator {

    @Override
    public boolean evaluateEquals(Value a, Value b) {
        return toBoolean(a).equals(toBoolean(b));
    }

    @Override
    public boolean supportsEquals(Value a, Value b) {
        return supports(a, b);
    }

    protected boolean supports(Value a, Value b) {
        return (a instanceof BooleanLiteralValue)
            || (b instanceof BooleanLiteralValue);
    }

    protected Boolean toBoolean(Value o) {
        return ((BooleanLiteralValue) o).get();
    }
}
