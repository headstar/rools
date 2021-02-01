package com.headstartech.rools.predicates;

import com.headstartech.rools.Value;

public interface LessThanComparator {

    boolean supportsLessThan(Value a, Value b);

    boolean evaluateLessThan(Value a, Value b);
}
