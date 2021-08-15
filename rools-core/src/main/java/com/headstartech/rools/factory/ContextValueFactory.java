package com.headstartech.rools.factory;

import com.headstartech.rools.Value;
import com.headstartech.rools.values.ContextValue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContextValueFactory implements ValueFactory {

    private static final Pattern pattern = Pattern.compile("^\\$\\{(\\w+)\\}$");

    @Override
    public Value createValue(Object o) {
        if(o instanceof String) {
            Matcher m = pattern.matcher((String) o);
            if(m.matches()) {
                return new ContextValue(m.group(1));
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
