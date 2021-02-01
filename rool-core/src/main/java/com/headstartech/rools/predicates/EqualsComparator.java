package com.headstartech.rools.predicates;

import com.headstartech.rools.Value;

public interface EqualsComparator {

    boolean supportsEquals(Value a, Value b);

    boolean evaluateEquals(Value a, Value b);
}
