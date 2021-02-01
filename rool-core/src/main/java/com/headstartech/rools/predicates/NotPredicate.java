package com.headstartech.rools.predicates;

import com.headstartech.rools.Context;
import com.headstartech.rools.Predicate;

public class NotPredicate implements Predicate {

    private final Predicate predicate;

    public NotPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean evaluate(Context context) {
        return !predicate.evaluate(context);
    }
}
