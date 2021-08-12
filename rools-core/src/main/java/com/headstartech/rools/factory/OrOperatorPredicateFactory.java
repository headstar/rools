package com.headstartech.rools.factory;

import com.headstartech.rools.Predicate;
import com.headstartech.rools.predicates.OrPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrOperatorPredicateFactory implements OperatorPredicateFactory {

    public Predicate createPredicate(MapPredicateFactory mapPredicateFactory, Object o) {
        if(!(o instanceof List)) {
            throw new RuntimeException(String.format("Expected List, got %s", o.getClass().getSimpleName()));
        }
        List<Object> operands = (List<Object>) o;
        List<Predicate> predicates = new ArrayList<>();
        for(Object e : operands) {
            Map<String, Object> m = (Map<String, Object>) e;
            predicates.add(mapPredicateFactory.createPredicate(m));
        }
        return new OrPredicate(predicates);
    }
}
