package com.headstartech.rools.factory;

import com.headstartech.rools.Value;
import com.headstartech.rools.values.StringLiteralValue;

public class StringValueFactory implements ValueFactory {

    @Override
    public Value createValue(Object o) {
        if(o instanceof String) {
            return new StringLiteralValue((String) o);
        } else {
            return null;
        }
    }
}
