package com.headstartech.rools.values;

import java.time.OffsetDateTime;

public class OffsetDateTimeLiteralValue extends LiteralValue<OffsetDateTime> {

    public OffsetDateTimeLiteralValue(OffsetDateTime o) {
        super(o, OffsetDateTime.class);
    }

}
