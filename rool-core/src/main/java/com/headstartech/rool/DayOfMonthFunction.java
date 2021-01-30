package com.headstartech.rool;

import java.time.OffsetDateTime;

public class DayOfMonthFunction implements Value {

    private final Value value;

    public DayOfMonthFunction(Value value) {
        this.value = value;
    }

    @Override
    public Object evaluate(Context context) {
        Object evaluatedValue = value.evaluate(context);
        if(evaluatedValue instanceof OffsetDateTime) {
            OffsetDateTime t = (OffsetDateTime) evaluatedValue;
            return t.getDayOfMonth();
        } else {
            throw new InvalidTypeException();
        }
    }
}
