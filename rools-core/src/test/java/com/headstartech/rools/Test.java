package com.headstartech.rools;

import com.headstartech.rools.contexts.MapContext;
import com.headstartech.rools.functions.DayOfMonthFunction;
import com.headstartech.rools.predicates.*;
import com.headstartech.rools.values.*;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        LongComparator longComparator = new LongComparator();
        StringComparator stringComparator = new StringComparator();
        OffsetDateTimeComparator offsetDateTimeComparator = new OffsetDateTimeComparator();
        BooleanComparator booleanComparator = new BooleanComparator();

        Collection<LessThanComparator> lessThanComparators = Arrays.asList(longComparator, stringComparator, offsetDateTimeComparator);
        Collection<EqualsComparator> equalsComparators = Arrays.asList(booleanComparator, longComparator, stringComparator, offsetDateTimeComparator);

        OffsetDateTime d1 = OffsetDateTime.parse("2007-12-03T10:15:30+01:00");
        Value v1 = new OffsetDateTimeLiteralValue(d1);
        Value v2 = new OffsetDateTimeLiteralValue(OffsetDateTime.parse("2017-12-23T10:15:30+01:00"));

        Predicate p1 = new EqualsPredicate(equalsComparators, new LongLiteralValue(3), new DayOfMonthFunction(new ContextValue("date")));
        Predicate p2 = new LessThanPredicate(lessThanComparators, new StringLiteralValue("abc"), new StringLiteralValue("def"));
        Predicate p3 = new EqualsPredicate(equalsComparators, new ContextValue("fruit"), new StringLiteralValue("apple"));
        Predicate p4 = new LessThanPredicate(lessThanComparators, v1, v2);
        Predicate p5 = new NotPredicate(new EqualsPredicate(equalsComparators, new ContextValue("flag"), new BooleanLiteralValue(true)));

        Predicate root = new AndPredicate(Arrays.asList(p1, p2, p3, p4, p5));

        Map<String, Value> values = new HashMap<>();
        values.put("fruit", new StringLiteralValue("apple"));
        values.put("date", new OffsetDateTimeLiteralValue(d1));
        values.put("flag", new BooleanLiteralValue(false));

        Context context = new MapContext(values);
        System.out.println(root.evaluate(context));
    }
}
