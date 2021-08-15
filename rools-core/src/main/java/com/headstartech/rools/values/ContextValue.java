package com.headstartech.rools.values;

import com.headstartech.rools.Context;
import com.headstartech.rools.Value;
import com.headstartech.rools.ValueNotFoundException;

public class ContextValue implements Value {

    private final String key;

    public ContextValue(String key) {
        this.key = key;
    }

    @Override
    public Value evaluate(Context context) {
        Value o = context.get(key);
        if(o == null) {
            throw new ValueNotFoundException(String.format("Context value not found: key=%s", key));
        }
        return o;
    }

}
