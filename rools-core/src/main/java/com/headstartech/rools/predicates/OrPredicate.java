package com.headstartech.rools.predicates;

import com.headstartech.rools.Context;
import com.headstartech.rools.Predicate;

import java.util.List;

public class OrPredicate implements Predicate {

    private final List<Predicate> predicates;

    public OrPredicate(List<Predicate> predicates) {
        this.predicates = predicates;
    }

    @Override
    public boolean evaluate(Context context) {
        boolean result = false;
        for(Predicate e : predicates) {
            if(e.evaluate(context)) {
                return true;
            }
        }
        return result;
    }
}
