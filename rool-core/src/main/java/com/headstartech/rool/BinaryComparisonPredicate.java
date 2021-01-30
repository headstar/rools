package com.headstartech.rool;

import java.util.Collection;

public class BinaryComparisonPredicate implements Predicate {

    private final Collection<BinaryComparator> comparators;
    private final Value a;
    private final Value b;

    public BinaryComparisonPredicate(Collection<BinaryComparator> comparators, Value a, Value b) {
        this.comparators = comparators;
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean evaluate(Context context) {
        Object evaluatedA = a.evaluate(context);
        Object evaluatedB = b.evaluate(context);
        for(BinaryComparator e : comparators) {
            if(e.supports(evaluatedA, evaluatedB)) {
                return e.evaluate(evaluatedA, evaluatedB);
            }
        }
        return onNotSupported();
    }

    protected boolean onNotSupported() {
        throw new NotSupportedException();
    }

}
