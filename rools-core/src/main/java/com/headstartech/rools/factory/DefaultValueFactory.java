package com.headstartech.rools.factory;

import com.headstartech.rools.Value;
import com.headstartech.rools.values.LongLiteralValue;
import com.headstartech.rools.values.StringLiteralValue;

public class DefaultValueFactory implements ValueFactory {

    @Override
    public Value createValue(Object o) {
        if(o instanceof Long) {
            return new LongLiteralValue((Long) o);
        } else if(o instanceof Integer) {
            return new LongLiteralValue((Integer) o);
        } else if(o instanceof String) {
            return new StringLiteralValue((String) o);
        } else {
            throw new RuntimeException(String.format("unknown value %s", o.getClass().getSimpleName()));
        }
    }
}
