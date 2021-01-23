package com.headstartech.rool;

import java.util.List;

public class EqualsPredicate implements Predicate {

    private final List<EqualsComparator> comparators;
    private final Value a;
    private final Value b;

    public EqualsPredicate(List<EqualsComparator> comparators, Value a, Value b) {
        this.comparators = comparators;
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean evaluate(Context context) {
        Object evaluatedA = a.evaluate(context);
        Object evaluatedB = b.evaluate(context);
        for(EqualsComparator e : comparators) {
            if(e.supportsEquals(evaluatedA, evaluatedB)) {
                return e.evaluateEquals(a, b);
            }
        }
        throw new NotSupportedException();
    }
}
