package com.headstartech.rools.predicates;

import com.headstartech.rools.Value;

public interface BinaryComparator {

    boolean supports(Value a, Value b);

    boolean evaluate(Value a, Value b);

}
