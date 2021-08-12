package com.headstartech.rools.factory;

import com.headstartech.rools.Value;

import java.util.List;

public class CompositeValueFactory implements ValueFactory {

    private final List<ValueFactory> valueFactories;

    public CompositeValueFactory(List<ValueFactory> valueFactories) {
        this.valueFactories = valueFactories;
    }

    @Override
    public Value createValue(Object o) {
        Value v = null;
        for(ValueFactory vf : valueFactories) {
            v = vf.createValue(o);
            if(v != null) {
                break;
            }
        }
        if(v == null) {
            throw new RuntimeException(String.format("no ValueFactory handling %s", o));
        }
        return v;
    }
}
