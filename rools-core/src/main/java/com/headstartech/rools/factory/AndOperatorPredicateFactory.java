package com.headstartech.rools.factory;

import com.headstartech.rools.Predicate;
import com.headstartech.rools.predicates.AndPredicate;

import java.util.List;
import java.util.stream.Collectors;

public class AndOperatorPredicateFactory implements OperatorPredicateFactory {

    public Predicate createPredicate(MapPredicateFactory mapPredicateFactory, Object o) {
        List<Object> operands = FactoryUtil.toList(o);
        List<Predicate> predicates = operands.stream()
                .map(FactoryUtil::toMap)
                .map(mapPredicateFactory::createPredicate)
                .collect(Collectors.toList());
        return new AndPredicate(predicates);
    }
}
