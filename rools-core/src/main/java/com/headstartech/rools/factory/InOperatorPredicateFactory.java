package com.headstartech.rools.factory;

import com.headstartech.rools.Predicate;
import com.headstartech.rools.Value;
import com.headstartech.rools.predicates.OrPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        List<Predicate> orPredicates = new ArrayList<>();
        List<Object> coll = getListOrThrow(operands, "coll");
        for(Object p : coll) {
            Value pv = valueFactory.createValue(p);
            Predicate eqPred = equalsPredicateFactory.createPredicate(elem, pv);
            orPredicates.add(eqPred);
        }
        return new OrPredicate(orPredicates);
    }
}
