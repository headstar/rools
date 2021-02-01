package com.headstartech.rools.functions;

import com.headstartech.rools.Context;
import com.headstartech.rools.Value;
import com.headstartech.rools.support.ValueTypeUtil;
import com.headstartech.rools.values.LiteralValue;
import com.headstartech.rools.values.LongLiteralValue;
import com.headstartech.rools.values.OffsetDateTimeLiteralValue;

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
