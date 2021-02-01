package com.headstartech.rools.predicates;

import com.headstartech.rools.Context;
import com.headstartech.rools.NotSupportedException;
import com.headstartech.rools.Predicate;
import com.headstartech.rools.Value;

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
        Value evaluatedA = a.evaluate(context);
        Value evaluatedB = b.evaluate(context);
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
