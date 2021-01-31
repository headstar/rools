package com.headstartech.rool;

public abstract class LiteralValue<T> implements Value {

    private final T o;
    private final Class<T> clazz;

    public LiteralValue(T o, Class<T> clazz) {
        this.o = o;
        this.clazz = clazz;
    }

    @Override
    public Value evaluate(Context context) {
        return this;
    }

    public T get() {
        return clazz.cast(o);
    }

}
