package com.headstartech.rool;

import java.util.Map;

public class MapContext implements Context {

    private final Map<String, LiteralValue<?>> contextMap;

    public MapContext(Map<String, LiteralValue<?>> contextMap) {
        this.contextMap = contextMap;
    }

    @Override
    public LiteralValue<?> get(String key) {
        return contextMap.get(key);
    }
}
