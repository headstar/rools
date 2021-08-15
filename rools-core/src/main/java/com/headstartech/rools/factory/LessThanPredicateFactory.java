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
        Map<String, Object> operands = FactoryUtil.toMap(o);
        Value a = valueFactory.createValue(operands.get("a"));
        Value b = valueFactory.createValue(operands.get("b"));
        return createPredicate(a, b);
    }

    public Predicate createPredicate(Value a, Value b) {
        return new LessThanPredicate(lessThanComparators, a, b);
    }
}
