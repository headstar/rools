package com.headstartech.rool;

public class ContextValue implements Value {

    private final String key;

    public ContextValue(String key) {
        this.key = key;
    }

    @Override
    public Object evaluate(Context context) {
        Object o = context.get(key);
        if(o == null) {
            throw new ValueNotFoundException();
        }
        return o;
    }

}
