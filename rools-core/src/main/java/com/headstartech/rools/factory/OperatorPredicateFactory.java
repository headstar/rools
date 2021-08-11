package com.headstartech.rools.factory;

import com.headstartech.rools.Predicate;

public interface OperatorPredicateFactory {

    Predicate createPredicate(MapPredicateFactory mapPredicateFactory, Object o);
}
