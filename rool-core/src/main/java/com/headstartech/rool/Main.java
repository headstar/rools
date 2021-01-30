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

        OffsetDateTime d1 = OffsetDateTime.parse("2007-12-03T10:15:30+01:00");
        Value v1 = new LiteralValue(d1);
        Value v2 = new LiteralValue(OffsetDateTime.parse("2017-12-23T10:15:30+01:00"));

        Predicate p1 = new EqualsPredicate(equalsComparators, new LiteralValue(3L), new DayOfMonthFunction(new ContextValue("date")));
        Predicate p2 = new LessThanPredicate(lessThanComparators, new LiteralValue("abc"), new LiteralValue("def"));
        Predicate p3 = new EqualsPredicate(equalsComparators, new ContextValue("fruit"), new LiteralValue("apple"));
        Predicate p4 = new LessThanPredicate(lessThanComparators, v1, v2);

        Predicate p = new AndPredicate(Arrays.asList(p1, p2, p3, p4));

        Map<String, Object> values = new HashMap<>();
        values.put("fruit", "apple");
        values.put("date", d1);

        Context context = new MapContext(values);
        System.out.println(p.evaluate(context));

    }
}
