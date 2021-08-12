package com.headstartech.rools.factory;

import com.headstartech.rools.Value;
import com.headstartech.rools.values.BooleanLiteralValue;

public class BooleanValueFactory implements ValueFactory {

    @Override
    public Value createValue(Object o) {
        if(o instanceof Boolean) {
            return new BooleanLiteralValue((Boolean) o);
        } else {
            return null;
        }
    }
}
