package com.headstartech.rools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.headstartech.rools.contexts.MapContext;
import com.headstartech.rools.factory.AndOperatorPredicateFactory;
import com.headstartech.rools.factory.DefaultValueFactory;
import com.headstartech.rools.factory.LessThanPredicateFactory;
import com.headstartech.rools.factory.MapPredicateFactory;
import com.headstartech.rools.factory.OperatorPredicateFactory;
import com.headstartech.rools.factory.ValueFactory;
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

    @org.junit.jupiter.api.Test
    public void predicateTest() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String doc = "{\"and\":[{\"lt\":{\"a\":\"${age}\",\"b\":18}},{\"lt\":{\"a\":\"${length}\",\"b\":190}}]}";
        TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {};
        Map<String, Object> map = om.readValue(doc, typeRef);

        LongComparator longComparator = new LongComparator();
        StringComparator stringComparator = new StringComparator();
        Collection<LessThanComparator> lessThanComparators = Arrays.asList(longComparator, stringComparator);

        ValueFactory valueFactory = new DefaultValueFactory();

        LessThanPredicateFactory lessThanPredicateFactory = new LessThanPredicateFactory(lessThanComparators,
                valueFactory);
        AndOperatorPredicateFactory andOperatorPredicateFactory = new AndOperatorPredicateFactory();
        Map<String, OperatorPredicateFactory> operatorPredicateFactoryMap = new HashMap<>();
        operatorPredicateFactoryMap.put("lt", lessThanPredicateFactory);
        operatorPredicateFactoryMap.put("and", andOperatorPredicateFactory);

        MapPredicateFactory mapPredicateFactory = new MapPredicateFactory(operatorPredicateFactoryMap);
        Predicate p = mapPredicateFactory.createPredicate(map);
    }
}
