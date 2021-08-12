package com.headstartech.rools.factory;

import com.headstartech.rools.Predicate;
import com.headstartech.rools.Value;
import com.headstartech.rools.predicates.LessThanComparator;
import com.headstartech.rools.predicates.LessThanPredicate;

import java.util.Collection;
import java.util.Map;

public class LessThanPredicateFactory implements OperatorPredicateFactory {

    private final Collection<LessThanComparator> lessThanComparators;
    private final ValueFactory valueFactory;

    public LessThanPredicateFactory(Collection<LessThanComparator> lessThanComparators, ValueFactory valueFactory) {
        this.lessThanComparators = lessThanComparators;
        this.valueFactory = valueFactory;
    }

    public Predicate createPredicate(MapPredicateFactory mapPredicateFactory, Object o) {
        if(!(o instanceof Map)) {
            throw new RuntimeException(String.format("Expected Map, got %s", o.getClass().getSimpleName()));
        }
        Map<String, Object> operands = (Map<String, Object>) o;
        Value a = valueFactory.createValue(operands.get("a"));
        Value b = valueFactory.createValue(operands.get("b"));
        return new LessThanPredicate(lessThanComparators, a, b);
    }
}
