package com.headstartech.rool;

import java.util.Collection;
import java.util.stream.Collectors;

public class EqualsPredicate extends BinaryComparisonPredicate {

    public EqualsPredicate(Collection<EqualsComparator> comparators, Value a, Value b) {
        super(comparators.stream().map(e -> {
            return new BinaryComparator() {
                @Override
                public boolean supports(Object a, Object b) {
                    return e.supportsEquals(a, b);
                }

                @Override
                public boolean evaluate(Object a, Object b) {
                    return e.evaluateEquals(
                            a, b);
                }
            };
        }).collect(Collectors.toList()), a, b);
    }
}
