package com.headstartech.rools;

interface BinaryComparator {

    boolean supports(Value a, Value b);

    boolean evaluate(Value a, Value b);

}
