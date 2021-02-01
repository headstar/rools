package com.headstartech.rools;

import java.util.Map;

public class MapContext implements Context {

    private final Map<String, Value> contextMap;

    public MapContext(Map<String, Value> contextMap) {
        this.contextMap = contextMap;
    }

    @Override
    public Value get(String key) {
        return contextMap.get(key);
    }
}
