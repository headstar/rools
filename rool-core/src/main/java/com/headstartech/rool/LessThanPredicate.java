package com.headstartech.rool;

import java.util.Collection;
import java.util.stream.Collectors;

public class LessThanPredicate extends BinaryComparisonPredicate {

    public LessThanPredicate(Collection<LessThanComparator> comparators, Value a, Value b) {
        super(comparators.stream().map(e -> {
            return new BinaryComparator() {
                @Override
                public boolean supports(Object a, Object b) {
                    return e.supportsLessThan(a, b);
                }

                @Override
                public boolean evaluate(Object a, Object b) {
                    return e.evaluateLessThan(a, b);
                }
            };
        }).collect(Collectors.toList()), a, b);
    }

}
