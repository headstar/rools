package com.headstartech.rool;

interface BinaryComparator {

    boolean supports(Value a, Value b);

    boolean evaluate(Value a, Value b);

}
