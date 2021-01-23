package com.headstartech.rool;

public class LiteralValue implements Value {

    private final Object o;

    public LiteralValue(Object o ) {
        this.o = o;
    }

    @Override
    public Object evaluate(Context context) {
        return o;
    }

}
