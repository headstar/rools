package com.headstartech.rools.predicates;

import com.headstartech.rools.Context;
import com.headstartech.rools.Predicate;

import java.util.List;

public class AndPredicate implements Predicate {

    private final List<Predicate> predicates;

    public AndPredicate(List<Predicate> predicates) {
        this.predicates = predicates;
    }

    @Override
    public boolean evaluate(Context context) {
        boolean result = true;
        for(Predicate e : predicates) {
            if(!e.evaluate(context)) {
                return false;
            }
        }
        return result;
    }
}
