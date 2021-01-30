package com.headstartech.rool;

import java.util.Map;

public class MapContext implements Context {

    private final Map<String, Object> contextMap;

    public MapContext(Map<String, Object> contextMap) {
        this.contextMap = contextMap;
    }

    @Override
    public Object get(String key) {
        return contextMap.get(key);
    }
}
