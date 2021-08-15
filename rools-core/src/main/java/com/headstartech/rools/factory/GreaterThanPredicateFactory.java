package com.headstartech.rools.factory;

import com.headstartech.rools.Predicate;
import com.headstartech.rools.Value;
import com.headstartech.rools.predicates.NotPredicate;
import com.headstartech.rools.predicates.OrPredicate;

import java.util.Arrays;
import java.util.Map;

public class GreaterThanPredicateFactory implements OperatorPredicateFactory {

    private final EqualsPredicateFactory equalsPredicateFactory;
    private final LessThanPredicateFactory lessThanPredicateFactory;
    private final ValueFactory valueFactory;

    public GreaterThanPredicateFactory(EqualsPredicateFactory equalsPredicateFactory, LessThanPredicateFactory lessThanPredicateFactory, ValueFactory valueFactory) {
        this.equalsPredicateFactory = equalsPredicateFactory;
        this.lessThanPredicateFactory = lessThanPredicateFactory;
        this.valueFactory = valueFactory;
    }

    public Predicate createPredicate(MapPredicateFactory mapPredicateFactory, Object o) {
        Map<String, Object> operands = FactoryUtil.toMap(o);
        Value a = valueFactory.createValue(operands.get("a"));
        Value b = valueFactory.createValue(operands.get("b"));

        Predicate eq = equalsPredicateFactory.createPredicate(a, b);
        Predicate lt = lessThanPredicateFactory.createPredicate(a, b);
        Predicate or = new OrPredicate(Arrays.asList(eq, lt));
        return new NotPredicate(or);
    }
}
