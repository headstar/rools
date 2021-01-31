package com.headstartech.rool;

import java.time.OffsetDateTime;

public class DayOfMonthFunction implements Value {

    private final Value value;

    public DayOfMonthFunction(Value value) {
        this.value = value;
    }

    @Override
    public LiteralValue<Long> evaluate(Context context) {
        Value evaluatedValue = value.evaluate(context);
        if(evaluatedValue instanceof OffsetDateTimeLiteralValue) {
            OffsetDateTime t = ((OffsetDateTimeLiteralValue) evaluatedValue).get();
            return new LongLiteralValue(t.getDayOfMonth());
        } else {
            throw new InvalidTypeException();
        }
    }
}
