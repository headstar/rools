package com.headstartech.rools.predicates;

import com.headstartech.rools.Value;

import java.util.Collection;
import java.util.stream.Collectors;

public class LessThanPredicate extends BinaryComparisonPredicate {

    public LessThanPredicate(Collection<LessThanComparator> comparators, Value a, Value b) {
        super(comparators.stream().map(e -> {
            return new BinaryComparator() {
                @Override
                public boolean supports(Value a, Value b) {
                    return e.supportsLessThan(a, b);
                }

                @Override
                public boolean evaluate(Value a, Value b) {
                    return e.evaluateLessThan(a, b);
                }
            };
        }).collect(Collectors.toList()), a, b);
    }

}
