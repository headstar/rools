package com.headstartech.rools.factory;

import com.headstartech.rools.Value;
import com.headstartech.rools.values.LongLiteralValue;

public class LongValueFactory implements ValueFactory {

    @Override
    public Value createValue(Object o) {
        if(o instanceof Long) {
            return new LongLiteralValue((Long) o);
        } else if(o instanceof Integer) {
            return new LongLiteralValue((Integer) o);
        } else {
            return null;
        }
    }
}
