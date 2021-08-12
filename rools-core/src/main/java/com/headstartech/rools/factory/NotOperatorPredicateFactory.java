package com.headstartech.rools.factory;

import com.headstartech.rools.Predicate;
import com.headstartech.rools.predicates.NotPredicate;

import java.util.Map;

public class NotOperatorPredicateFactory implements OperatorPredicateFactory {

    public Predicate createPredicate(MapPredicateFactory mapPredicateFactory, Object o) {
        if(!(o instanceof Map)) {
            throw new RuntimeException(String.format("Expected Map, got %s", o.getClass().getSimpleName()));
        }
        Map<String, Object> operand = (Map<String, Object>) o;
        return new NotPredicate(mapPredicateFactory.createPredicate(operand));
    }
}
