package com.headstartech.rools.factory;

import java.util.List;
import java.util.Map;

public class FactoryUtil {

    private FactoryUtil() {}

    public static Map<String, Object> toMap(Object o) {
        if(!(o instanceof Map)) {
            throw new RuntimeException(String.format("Expected Map, got %s", o.getClass().getSimpleName()));
        }
        return (Map<String, Object>) o;
    }

    public static Object getOrThrow(Map<String, Object> m, String key) {
        Object v = m.get(key);
        if(v == null) {
            throw new RuntimeException(String.format("No value for %s", key));
        }
        return v;
    }

    public static List<Object> getListOrThrow(Map<String, Object> m, String key) {
        Object v = m.get(key);
        if(v == null) {
            throw new RuntimeException(String.format("No value for %s", key));
        }
        return toList(v);
    }

    public static List<Object> toList(Object o) {
        if(!(o instanceof List)) {
            throw new RuntimeException(String.format("Expected List, got %s", o.getClass().getSimpleName()));
        }
        return (List<Object>) o;
    }
}
