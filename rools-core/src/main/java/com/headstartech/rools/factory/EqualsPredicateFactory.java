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
        if(!(o instanceof Map)) {
            throw new RuntimeException(String.format("Expected Map, got %s", o.getClass().getSimpleName()));
        }
        Map<String, Object> operands = (Map<String, Object>) o;
        Value a = valueFactory.createValue(operands.get("a"));
        Value b = valueFactory.createValue(operands.get("b"));
        return new EqualsPredicate(comparators, a, b);
    }
}
