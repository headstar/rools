package com.headstartech.rool;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        LongComparator longComparator = new LongComparator();
        StringComparator stringComparator = new StringComparator();
        OffsetDateTimeComparator offsetDateTimeComparator = new OffsetDateTimeComparator();

        Collection<LessThanComparator> lessThanComparators = Arrays.asList(longComparator, stringComparator, offsetDateTimeComparator);
        Collection<EqualsComparator> equalsComparators = Arrays.asList(longComparator, stringComparator, offsetDateTimeComparator);

        Predicate p1 = new LessThanPredicate(lessThanComparators, new LiteralValue(5L), new LiteralValue(7L));
        Predicate p2 = new LessThanPredicate(lessThanComparators, new LiteralValue("abc"), new LiteralValue("def"));
        Predicate p3 = new EqualsPredicate(equalsComparators, new ContextValue("fruit"), new LiteralValue("apple"));
        Predicate p4 = new LessThanPredicate(lessThanComparators, new LiteralValue(OffsetDateTime.parse("2007-12-03T10:15:30+01:00")),
                new LiteralValue(OffsetDateTime.parse("2017-12-03T10:15:30+01:00")));

        Predicate p = new AndPredicate(Arrays.asList(p1, p2, p3, p4));

        Map<String, Object> values = new HashMap<>();
        values.put("fruit", "apple");
        Context context = new MapContext(values);
        System.out.println(p.evaluate(context));
    }


}
