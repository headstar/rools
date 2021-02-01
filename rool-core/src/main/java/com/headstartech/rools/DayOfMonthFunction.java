package com.headstartech.rools;

import java.time.OffsetDateTime;

public class DayOfMonthFunction implements Value {

    private final Value value;

    public DayOfMonthFunction(Value value) {
        this.value = value;
    }

    @Override
    public LiteralValue<Long> evaluate(Context context) {
        Value evaluatedValue = value.evaluate(context);
        OffsetDateTime t = ValueTypeUtil.to(evaluatedValue, OffsetDateTimeLiteralValue.class).get();
        return new LongLiteralValue(t.getDayOfMonth());
    }
}
