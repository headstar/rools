package com.headstartech.rools.factory;

import com.headstartech.rools.Predicate;
import com.headstartech.rools.predicates.NotPredicate;

import java.util.Map;

public class NotOperatorPredicateFactory implements OperatorPredicateFactory {

    public Predicate createPredicate(MapPredicateFactory mapPredicateFactory, Object o) {
        Map<String, Object> operand = FactoryUtil.toMap(o);
        return new NotPredicate(mapPredicateFactory.createPredicate(operand));
    }
}
