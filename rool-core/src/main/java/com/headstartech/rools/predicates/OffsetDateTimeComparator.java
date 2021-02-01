package com.headstartech.rools.predicates;


import com.headstartech.rools.Value;
import com.headstartech.rools.values.OffsetDateTimeLiteralValue;

import java.time.OffsetDateTime;

public class OffsetDateTimeComparator implements LessThanComparator, EqualsComparator {

    @Override
    public boolean evaluateLessThan(Value a, Value b) {
        return toOffsetDateTime(a).compareTo(toOffsetDateTime(b)) < 0;
    }

    @Override
    public boolean evaluateEquals(Value a, Value b) {
        return toOffsetDateTime(a).equals(toOffsetDateTime(b));
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
        return (a instanceof OffsetDateTimeLiteralValue)
                || (b instanceof OffsetDateTimeLiteralValue);
    }

    protected OffsetDateTime toOffsetDateTime(Value o) {
        return ((OffsetDateTimeLiteralValue) o).get();
    }
}
