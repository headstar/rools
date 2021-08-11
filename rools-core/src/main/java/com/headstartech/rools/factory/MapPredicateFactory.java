package com.headstartech.rools.factory;

import com.headstartech.rools.Predicate;

import java.util.Map;

public class MapPredicateFactory {

    private final Map<String, OperatorPredicateFactory> operatorsPredicateFactories;
    private boolean topLevel = true;

    public MapPredicateFactory(Map<String, OperatorPredicateFactory> operatorsPredicateFactories) {
        this.operatorsPredicateFactories = operatorsPredicateFactories;
    }

    public Predicate createPredicate(Map<String, Object> m) {
        String operatorKey = getOperatorKey(m);
        OperatorPredicateFactory operatorPredicateFactory = findOperatorPredicateFactory(m, operatorKey);
        return operatorPredicateFactory.createPredicate(this, m.get(operatorKey));
    }

    private OperatorPredicateFactory findOperatorPredicateFactory(Map<String, Object> m, String operatorKey) {
        if(m.keySet().size() == 1) {
            OperatorPredicateFactory operatorPredicateFactory = operatorsPredicateFactories.get(operatorKey);
            if(operatorPredicateFactory == null) {
                throw new RuntimeException(String.format("no operator for %s found", operatorKey));
            } else {
                return operatorPredicateFactory;
            }
        } else {
            throw new RuntimeException("Only one key expected");
        }
    }

    private String getOperatorKey(Map<String, Object> m) {
        if(m.keySet().size() == 1) {
            return m.keySet().stream().findFirst().get();
        } else {
            throw new RuntimeException("Only one key expected");
        }
    }
}
