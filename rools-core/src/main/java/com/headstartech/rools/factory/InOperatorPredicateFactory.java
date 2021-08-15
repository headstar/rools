package com.headstartech.rools.factory;

import com.headstartech.rools.Predicate;
import com.headstartech.rools.Value;
import com.headstartech.rools.predicates.OrPredicate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.headstartech.rools.factory.FactoryUtil.getListOrThrow;
import static com.headstartech.rools.factory.FactoryUtil.getOrThrow;

public class InOperatorPredicateFactory implements OperatorPredicateFactory {

    private final EqualsPredicateFactory equalsPredicateFactory;
    private final ValueFactory valueFactory;

    public InOperatorPredicateFactory(EqualsPredicateFactory equalsPredicateFactory, ValueFactory valueFactory) {
        this.equalsPredicateFactory = equalsPredicateFactory;
        this.valueFactory = valueFactory;
    }

    @Override
    public Predicate createPredicate(MapPredicateFactory mapPredicateFactory, Object o) {
        Map<String, Object> operands = FactoryUtil.toMap(o);
        Value elem = valueFactory.createValue(getOrThrow(operands, "elem"));
        List<Predicate> orPredicates = getListOrThrow(operands, "coll")
                .stream()
                .map(valueFactory::createValue)
                .map(e -> equalsPredicateFactory.createPredicate(elem, e))
                .collect(Collectors.toList());
        return new OrPredicate(orPredicates);
    }
}
