package com.headstartech.rools.factory;

import com.headstartech.rools.Predicate;
import com.headstartech.rools.Value;
import com.headstartech.rools.predicates.EqualsComparator;
import com.headstartech.rools.predicates.EqualsPredicate;

import java.util.Collection;
import java.util.Map;

public class EqualsPredicateFactory implements OperatorPredicateFactory {

    private final Collection<EqualsComparator> comparators;
    private final ValueFactory valueFactory;

    public EqualsPredicateFactory(Collection<EqualsComparator> comparators, ValueFactory valueFactory) {
        this.comparators = comparators;
        this.valueFactory = valueFactory;
    }

    public Predicate createPredicate(MapPredicateFactory mapPredicateFactory, Object o) {
        Map<String, Object> operands = FactoryUtil.toMap(o);
        Value a = valueFactory.createValue(operands.get("a"));
        Value b = valueFactory.createValue(operands.get("b"));
        return createPredicate(a, b);
    }

    public Predicate createPredicate(Value a, Value b) {
        return new EqualsPredicate(comparators, a, b);
    }
}
