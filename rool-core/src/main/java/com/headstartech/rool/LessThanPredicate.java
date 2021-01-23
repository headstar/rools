package com.headstartech.rool;

import java.util.List;

public class LessThanPredicate implements Predicate {

    private final List<LessThanComparator> comparators;
    private final Value a;
    private final Value b;

    public LessThanPredicate(List<LessThanComparator> comparators, Value a, Value b) {
        this.comparators = comparators;
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean evaluate(Context context) {
        Object evaluatedA = a.evaluate(context);
        Object evaluatedB = b.evaluate(context);
        for(LessThanComparator e : comparators) {
            if(e.supportsLessThan(evaluatedA, evaluatedB)) {
                return e.evaluateLessThan(a, b);
            }
        }
        throw new NotSupportedException();
    }
}
