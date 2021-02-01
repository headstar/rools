package com.headstartech.rools;

public class LongLiteralValue extends LiteralValue<Long> {

    public LongLiteralValue(Long o) {
        super(o, Long.class);
    }

    public LongLiteralValue(Integer o) {
        super(o.longValue(), Long.class);
    }
}
